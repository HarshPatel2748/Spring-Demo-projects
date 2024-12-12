create table question (
                          id integer not null auto_increment,
                          answer varchar(255),
                          category varchar(255),
                          difficulty varchar(255),
                          option1 varchar(255),
                          option2 varchar(255),
                          option3 varchar(255),
                          option4 varchar(255),
                          question varchar(255),
                          primary key (id)
);