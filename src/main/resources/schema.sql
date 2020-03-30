drop table if exists User, Company, Phone;

create table User (
    id              int             auto_increment,
    first_name      varchar(50)     not null,
    last_name       varchar(50)     not null,
    user_name       varchar(50)     not null,
    password        varchar(255)     not null,
    roles           varchar(255)    not null
);

create table Company (
    id              int             auto_increment,
    name            varchar(50)     not null
);

create table Account (
    id              int             auto_increment,
    credit          decimal         not null,
    user_id         int             not null,
    company_id      int             not null,
    foreign key (user_id)           references User(id)            on delete cascade,
    foreign key (company_id)        references Company(id)         on delete cascade,
    UNIQUE(user_id, company_id)
);

create table Phone (
    id              int             auto_increment,
    number          varchar(12)     not null,
    user_id         int             not null,
    company_id      int             not null,
    foreign key (user_id)           references User(id)            on delete cascade,
    foreign key (company_id)        references Company(id)         on delete cascade,
    UNIQUE(number)
);