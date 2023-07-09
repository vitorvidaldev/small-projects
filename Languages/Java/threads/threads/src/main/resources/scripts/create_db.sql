DROP TABLE IF EXISTS `like`;
DROP TABLE IF EXISTS `view`;
DROP TABLE IF EXISTS `thread`;
DROP TABLE IF EXISTS `account`;

create table account (
    account_id binary(16) primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    `password` varchar(255) not null,
    created_at timestamp not null default CURRENT_TIMESTAMP,
    updated_at timestamp not null default CURRENT_TIMESTAMP
);

create table thread (
    thread_id binary(16) primary key,
    thread_content varchar(255) not null,
    account_id binary(16) not null,
    parent_thread_id binary(16),
    created_at timestamp not null default CURRENT_TIMESTAMP,
    foreign key (account_id) references account(account_id)
);

-- add self reference foreign key
alter table thread add foreign key (parent_thread_id) references thread(thread_id);

create table `like` (
    like_id binary(16) primary key,
    account_id binary(16) not null,
    thread_id binary(16) not null,
    created_at timestamp not null default CURRENT_TIMESTAMP,
    foreign key (account_id) references account(account_id),
    foreign key (thread_id) references thread(thread_id)
);

create table `view` (
    view_id binary(16) primary key,
    account_id binary(16) not null,
    thread_id binary(16) not null,
    created_at timestamp not null default CURRENT_TIMESTAMP,
    foreign key (account_id) references account(account_id),
    foreign key (thread_id) references thread(thread_id)
);