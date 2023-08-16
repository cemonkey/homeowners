create table person
(
  id           text                    not null
    constraint person_pk
      primary key,
  first_name   text                    not null,
  surname      text                    not null,
  created      timestamp               not null,
  last_updated timestamp               not null,
  version      integer                 not null
);

create table house
(
  id             text                    not null
    constraint house_pk
      primary key,
  street_address text                    not null,
  suburb         text                    not null,
  postcode       text                    not null,
  person_id      text                    not null
    constraint house_person_id_fk
      references person,
  created        timestamp               not null
);
