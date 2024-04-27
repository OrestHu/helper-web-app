----liquibase formatted sql

--changeset OrestHutovych:create-identity_help-schema
--comment create new identity_help schema
create schema identity_help;
--rollback drop schema identity_help;


--changeset OrestHutovych:create-identity_help-users-table
--comment create table identity_help.users
create table identity_help.users (
    id          serial primary key,
    full_name    varchar(100) not null,
    username    varchar(150) unique not null,
    password    varchar(150) not null
);
--rollback drop table identity_help.users;

--changeset OrestHutovych:create-identity_help-roles-table
--comment create table identity_help.roles
create table identity_help.roles (
     id      serial primary key,
     name    varchar(50) not null
);
--rollback drop table identity_help.roles;

--changeset OrestHutovych:create-identity_help-users_roles-table
--comment create table identity_help.users_roles
create table identity_help.users_roles (
   user_id     integer not null,
   role_id     integer not null
);
--rollback drop table identity_help.users_roles;

--changeset OrestHutovych:add-users_roles-table-constraints
--comment add constraints to users_roles
alter table identity_help.users_roles
    add constraint users_roles__user_id__fk
        foreign key (user_id) references identity_help.users(id);

alter table identity_help.users_roles
    add constraint users_roles__role_id__fk
        foreign key (role_id) references identity_help.roles(id);

alter table identity_help.users_roles
    add constraint users_roles_unique
        unique (user_id, role_id);
--rollback alter table identity_help.users_roles drop constraints users_roles__user_id__fk;
--rollback alter table identity_help.users_roles drop constraints users_roles__role_id__fk;
--rollback alter table identity_help.users_roles drop constraints users_roles_unique;

--changeset OrestHutovych:add-data-to-roles-table
--commit add name to roles table
insert into identity_help.roles(name)
values ('ROLE_USER_RECEIVER'),
       ('ROLE_USER_HELPER'),
       ('ROLE_ADMIN');
--rollback truncate table identity_help.roles;

