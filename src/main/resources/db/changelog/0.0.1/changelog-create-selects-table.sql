--liquibase formatted sql

--changeset OrestHutovych:create-help-selects-table
--comment create table help.selects
create table help.selects(
   id                serial primary key,
   user_id     integer not null,
   post_id     integer not null
);
--rollback drop table help.selects;

--changeset OrestHutovych:add-selects-table-constraints
--comment add constraints to reviews
alter table help.selects
    add constraint selects__user_id__fk
        foreign key (user_id) references identity_help.users(id);

alter table help.selects
    add constraint selects__post_id__fk
        foreign key (post_id) references help.posts(id);

alter table help.selects
    add constraint selects_unique
        unique (user_id, post_id);
--rollback alter table  help.selects drop constraints selects__user_id__fk;
--rollback alter table  help.selects drop constraints selects__post_id__fk;
--rollback alter table  help.selects drop constraints selects_unique;