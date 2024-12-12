create table question(
    id integer not null auto_increment,

    question varchar(255),
    answer varchar(255),

    option1 varchar(255),
    option2 varchar(255),
    option3 varchar(255),
    option4 varchar(255),

    category varchar(10),
    difficulty varchar(10),

    primary key (id)
);