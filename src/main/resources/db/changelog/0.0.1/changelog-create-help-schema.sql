--liquibase formatted sql

--changeset OrestHutovych:create-help-schema
--comment create new schema
create schema help;
--rollback drop schema help;