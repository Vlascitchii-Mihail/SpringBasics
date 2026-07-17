create table if not exists purchase(
    id int auto_increment primary key,
    product varchar(50) not null,
    price double not null
);

create table account(
    it int not null auto_increment,
    name varchar(50) not null,
    amount double not null
)