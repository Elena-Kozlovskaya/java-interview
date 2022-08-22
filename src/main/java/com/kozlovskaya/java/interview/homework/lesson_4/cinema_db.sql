use new_cinema;
drop table if exists movies;
create table movies
(
    id       bigint auto_increment primary key,
    title    varchar(150) not null,
    duration time         not null
);

drop table if exists tickets;
create table tickets
(
    id    int auto_increment primary key,
    price int not null,
    constraint tickets_price_uindex unique (price)
);

drop table if exists sessions;
create table sessions
(
    id     bigint auto_increment primary key,
    start_date_time datetime not null,
    movie_id        bigint   not null,
    ticket_id       int      not null,
    constraint sessions_fk_movie_id
        foreign key (movie_id) references movies (id)
            on update cascade,
    constraint sessions_fk_ticket_id
        foreign key (ticket_id) references tickets (id)
            on update cascade
);

drop table if exists sale_information;
create table sale_information
(
    ticket_number bigint auto_increment primary key,
    session_id    bigint not null,
    constraint sale_information_fk_session_id
        foreign key (session_id) references sessions (id)
            on update cascade
);

insert into movies(title, duration)
values ('Бэтмен', '02:00:00'),
       ('Фиксики', '01:00:00'),
       ('Гарри Поттер', '01:30:00');

insert into tickets(price)
values (500),
       (600),
       (700);

insert into sessions(start_date_time, movie_id, ticket_id)
values ('2022-09-01 08:00:00', 1, 3),
       ('2022-09-01 21:00:00', 1, 2),
       ('2022-09-01 15:30:00', 1, 2),
       ('2022-09-01 12:00:00', 2, 1),
       ('2022-09-01 10:30:00', 2, 2),
       ('2022-09-01 14:30:00', 2, 1),
       ('2022-09-01 18:00:00', 3, 3),
       ('2022-09-01 09:15:00', 3, 3),
       ('2022-09-01 19:30:00', 3, 2);

insert into sale_information(session_id)
values(1),(1),(1),(1),(2),(2),(2),(3),(3),(4),(4),(4),(4),(4),(5),(5),(5),(6),(6),(6),(6),(7),(7),
      (1),(1),(1),(1),(2),(2),(2),(3),(3),(4),(4),(4),(4),(4),(5),(5),(5),(6),(6),(6),(6),(7),(7),
      (8),(8),(8),(8),(2),(9),(9),(3),(9),(8),(4),(8),(4),(8),(9),(9),(5),(9),(9),(8),(8),(8),(8);

/*
1. Ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
*/
select m1.title, s1.start_date_time, m1.duration,
       m2.title, s2.start_date_time, m2.duration
from movies m1
inner join sessions s1 on m1.id = s1.movie_id
inner join sessions s2 on s2.start_date_time >= s1.start_date_time and addtime(m1.duration, time(s1.start_date_time)) > time(s2.start_date_time)
inner join movies m2 on s2.movie_id = m2.id
where s1.id <> s2.id
order by s1.start_date_time;

/*
2. Перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
*/
select * from(
select m1.title, s1.start_date_time as s1_start_time, m1.duration, addtime(m1.duration, time(s1.start_date_time)) as m1_finish_time,
       time(s2.start_date_time) as s2_start_time,
      timestampdiff(minute,addtime(m1.duration, time(s1.start_date_time)), time(s2.start_date_time)) as movie_interval
from movies m1
         inner join sessions s1 on m1.id = s1.movie_id
         inner join sessions s2 on s2.id =(select s.id from sessions s where addtime(m1.duration, time(s1.start_date_time)) < time(s.start_date_time)
         order by s.start_date_time limit 1)
         inner join movies m2 on s2.movie_id = m2.id) as m
where m.movie_interval >= 30
order by m.movie_interval desc;

/*
3. Список фильмов, для каждого — с указанием общего числа посетителей за все время,
среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
*/
with result as(select m1.title, count(ticket_number) as ticket_count,
      round(cast(count(ticket_number) as double)/ cast(count(distinct session_id) as double)) as avg_number_of_tickets_by_session,
      sum(price) as total_sale_sum
from movies m1
inner join sessions s on m1.id = s.movie_id
inner join sale_information i1 on s.id = i1.session_id
inner join tickets t on s.ticket_id = t.id
group by m1.title
order by total_sale_sum desc)
select * from result
union all
select 'Итого', sum(result.ticket_count), round(avg(result.avg_number_of_tickets_by_session)), sum(result.total_sale_sum)
from result;

/*
4. Число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).
*/
select '9-15', count(i.ticket_number), sum(t.price)
from sessions s
inner join sale_information i on i.session_id = s.id
inner join tickets t on s.ticket_id = t.id where hour(s.start_date_time) between 9 and 14
union all
select '15-18', count(i.ticket_number), sum(t.price)
from sessions s
         inner join sale_information i on i.session_id = s.id
         inner join tickets t on s.ticket_id = t.id where hour(s.start_date_time) between 15 and 17
union all
select '18-21', count(i.ticket_number), sum(t.price)
from sessions s
         inner join sale_information i on i.session_id = s.id
         inner join tickets t on s.ticket_id = t.id where hour(s.start_date_time) between 18 and 20
union all
select '21-00:00', count(i.ticket_number), sum(t.price)
from sessions s
         inner join sale_information i on i.session_id = s.id
         inner join tickets t on s.ticket_id = t.id where hour(s.start_date_time) between 21 and 23
;