create table memo(
    id int not null generated always as
        identity(start with 1, increment by 1),
    memo varchar(512),
    constraint pk_memo primary key(id)
)
