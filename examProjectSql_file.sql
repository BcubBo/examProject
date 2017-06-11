create Table book_type(
    
        id number(10)  primary key ,
        type_name varchar2(20) not null
        
        





);
Comment on Column book_type.id is 'id';
Comment on Column book_type.type_name is '图书类型名称';
create sequence book_type_seq;

insert into book_type values(book_type_seq.nextval,'科技');
insert into book_type values(book_type_seq.nextval,'小说');
insert into book_type values(book_type_seq.nextval,'艺术');
insert into book_type values(book_type_seq.nextval,'少儿');
commit;
--------------------------------------------

create Table users(
    user_id number(10) primary key ,
    user_code varchar2(50) not null,
    password varchar2(32) not null ,
    
    email varchar2(50) not null,
    gender varchar2(7) not null ,
    register_time date not null ,
    last_logintime date not null
    




);

Comment on Column users.user_id is '用户id';
Comment on Column users.user_code is '用户编码';
Comment on Column users.email is '邮箱地址';
Comment on Column users.register_time is '注册时间';
Comment on Column users.last_logintime is '最后登录时间';
Comment on Column users.gender is '性别';
Comment on Column users.password is '密码';
create sequence users_seq;
insert into users values(users_seq.nextval,'bcubbo1','11111111','v@v.v','1',To_Date('09-06-2017','dd-mm-yyyy'),To_Date('10-06-2017','dd-mm-yyyy'));
insert into users values(users_seq.nextval,'bcubbo2','11111111','v@v.v','1',To_Date('10-06-2017','dd-mm-yyyy'),To_Date('11-06-2017','dd-mm-yyyy'));
commit;

------测试用数据-------



--------------------------------------------

create table book_info(
    book_id number(10) ,
    book_code varchar2(50) not null,
    book_name varchar2(50) not null,
    book_type number(10) not null,
    book_author number(20) not null,
    publish_press varchar2(200) not null,
    publish_date date not null,
    is_borrow number not null,
    createBy varchar2(50) not null,
    creation_time date not null,
    last_updatetime date not null




);

commit;
Comment on Column book_info.book_id        is  '图书id';
Comment on Column book_info.book_code      is    '图书编号';
Comment on Column book_info.book_name     is     '图书名称';
Comment on Column book_info.book_type       is   '来源于图书类型表book_type中的id字段';
Comment on Column book_info.book_author      is    '图书作者';
Comment on Column book_info.publish_press      is    '出版社';
Comment on Column book_info.publish_date      is    '出版日期';
Comment on Column book_info.is_borrow       is   '是否借阅（1，已借阅0，未借阅';
Comment on Column book_info.createBy     is     '创建人';
Comment on Column book_info.creation_time      is    '创建时间';
Comment on Column book_info.last_updatetime      is    '最新更新时间';
create sequence book_info_seq;
insert into book_info values(book_info_seq.nextval,'BK000023','企业应用架构模式5',5,100011,'机械工业出版社5',To_Date('09-07-2017','dd-mm-yyyy'),1,'bcubbo',To_Date('11-07-2016','dd-mm-yyyy'),To_Date('08-07-2017','dd-mm-yyyy'));
insert into book_info values(book_info_seq.nextval,'BK000024','企业应用架构模式4',4,100011,'机械工业出版社4',To_Date('09-07-2017','dd-mm-yyyy'),1,'bcubbo',To_Date('12-07-2016','dd-mm-yyyy'),To_Date('08-07-2017','dd-mm-yyyy'));
insert into book_info values(book_info_seq.nextval,'BK000025','企业应用架构模式3',3,100011,'机械工业出版社3',To_Date('09-07-2017','dd-mm-yyyy'),1,'bcubbo',To_Date('13-07-2016','dd-mm-yyyy'),To_Date('08-07-2017','dd-mm-yyyy'));
insert into book_info values(book_info_seq.nextval,'BK000026','企业应用架构模式2',2,100011,'机械工业出版社2',To_Date('09-07-2017','dd-mm-yyyy'),1,'bcubbo',To_Date('14-07-2016','dd-mm-yyyy'),To_Date('08-07-2017','dd-mm-yyyy'));
insert into book_info values(book_info_seq.nextval,'BK000027','企业应用架构模式5',5,100011,'机械工业出版社5',To_Date('09-07-2017','dd-mm-yyyy'),1,'bcubbo',To_Date('15-07-2016','dd-mm-yyyy'),To_Date('08-07-2017','dd-mm-yyyy'));

commit;

--select book_code,book_name,book_type.type_name,book_author,publish_date,is_borrow,createby,creation_time,last_updatetime from book_info inner join book_type on book_info.book_type = book_type.id order by creation_time desc;
--select book_code,book_name,book_type.type_name,book_info.book_type,book_author,publish_date,is_borrow,createby,creation_time,last_updatetime from book_info inner join book_type on book_info.book_type = book_type.id order by creation_time desc;
--select book_code,book_name,book_type.type_name,book_info.book_type,book_author,publish_date,is_borrow,createby,creation_time,last_updatetime from book_info inner join book_type on book_info.book_type = book_type.id order by creation_time desc;