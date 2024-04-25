--liquibase formatted sql

--changeset OrestHutovych:create-help-posts-table
--comment create table help.posts
create table help.posts(
    id                serial primary key,
    name              varchar(150) unique not null,
    description       varchar(255),
    city              varchar(100) not null,
    img               varchar(255),
    created_time_stamp  timestamp not null,
    user_id           integer not null
);
--rollback drop table help.posts;

--changeset OrestHutovych:add-posts-table-constraints
--comment add constraints to reviews
alter table help.posts
    add constraint posts__user_id__fk
        foreign key (user_id) references identity_help.users(id);
--rollback alter table help.posts drop constraints posts__user_id__fk;