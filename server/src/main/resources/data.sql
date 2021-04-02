insert into country (continent, name)
select 'Europe', 'Macedonia'
where not exists(select 1 from country where name = 'Macedonia');

insert into country (continent, name)
select 'North America', 'United States of America'
where not exists(select 1 from country where name = 'United States of America');

insert into country (continent, name)
select 'Africa', 'Egypt'
where not exists(select 1 from country where name = 'Egypt');

insert into author (name, surname, country_id)
select 'Stefan', 'Krstikj', (select id from country where name = 'Macedonia')
where not exists(select 1 from author where name = 'Stefan' and surname = 'Krstikj');

insert into author (name, surname, country_id)
select 'Stephen', 'King', (select id from country where name = 'United States of America')
where not exists(select 1 from author where name = 'Stephen' and surname = 'King');

insert into category (description, name)
select 'Horror is a scary category', 'Horror'
where not exists (select 1 from category where name = 'Horror');

insert into category (description, name)
select 'February 14 is my favorite day', 'Romance'
where not exists (select 1 from category where name = 'Romance');

insert into category (description, name)
select 'I have no imagination', 'Fantasy'
where not exists (select id from category where name = 'Fantasy');

insert into book (available_copies, name, author_id, category_id)
select 10, 'The Shining', (select id from author where name = 'Stephen' and surname = 'King'),
        (select id from category where name = 'Horror')
        where not exists (select 1 from book where name = 'The Shining');
