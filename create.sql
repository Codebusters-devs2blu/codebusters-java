
    create table adult_user (
        id bigint generated by default as identity,
        user_id bigint unique,
        wallet_id bigint unique,
        cpf varchar(255) not null unique,
        email varchar(255) not null unique,
        job varchar(255),
        primary key (id)
    );

    create table child_task (
        status tinyint not null check (status between 0 and 3),
        task_value float(53),
        adult_user_id bigint,
        child_user_id bigint,
        id bigint generated by default as identity,
        description varchar(255) not null,
        primary key (id)
    );

    create table child_user (
        family tinyint check (family between 0 and 3),
        birthday timestamp(6) not null,
        guardian_id bigint,
        id bigint generated by default as identity,
        user_id bigint unique,
        wallet_id bigint unique,
        primary key (id)
    );

    create table objective (
        current_amount float(53) not null,
        objective_value float(53) not null,
        child_user_id bigint,
        id bigint generated by default as identity,
        description varchar(255) not null,
        primary key (id)
    );

    create table release (
        release_value float(53) not null,
        type tinyint not null check (type between 0 and 1),
        date timestamp(6) not null,
        id bigint generated by default as identity,
        wallet_id bigint,
        description varchar(255),
        primary key (id)
    );

    create table users (
        id bigint generated by default as identity,
        name varchar(255) not null,
        nickname varchar(255) not null,
        password varchar(255) not null,
        primary key (id)
    );

    create table wallet (
        money float(53) not null,
        id bigint generated by default as identity,
        primary key (id)
    );

    alter table if exists adult_user 
       add constraint FKoa5unhlvg4yn0x539y8w4m5i3 
       foreign key (user_id) 
       references users;

    alter table if exists adult_user 
       add constraint FKnt1cxkxka5p4ay00f9bta1r49 
       foreign key (wallet_id) 
       references wallet;

    alter table if exists child_task 
       add constraint FKn45wewbxg8wlpwqih471v87fu 
       foreign key (adult_user_id) 
       references adult_user;

    alter table if exists child_task 
       add constraint FKi9a1as0w51ip2ahcdlmrf3wnd 
       foreign key (child_user_id) 
       references child_user;

    alter table if exists child_user 
       add constraint FKnulfcpkkk11d7evcvfk7t977o 
       foreign key (guardian_id) 
       references adult_user;

    alter table if exists child_user 
       add constraint FKs7tpe5jlwpbh8vbrip5dodg02 
       foreign key (user_id) 
       references users;

    alter table if exists child_user 
       add constraint FKe7tsl4jqnbim8unyp1amrd3t3 
       foreign key (wallet_id) 
       references wallet;

    alter table if exists objective 
       add constraint FKrqyba89ln58vyxshix55h863x 
       foreign key (child_user_id) 
       references child_user;

    alter table if exists release 
       add constraint FKsts4i7fe65ys3bu0ilfsk05f9 
       foreign key (wallet_id) 
       references wallet;
