-- 查询所有数据库
show databases;

-- 查询当前数据库
select database();

-- 使用/切换数据库
use db01;

-- 查询当前正在使用的数据库
select database();

-- 创建数据库
create database db01;
create database db02;

-- 删除数据库
drop database if exists db02;

-- --------------------> DDL 表操作 <---------------
-- 创建表
create table user
(
    id       int comment 'ID, 唯一标识',
    username varchar(50) comment '用户名',
    name     varchar(10) comment '姓名',
    age      int comment '年龄',
    gender   char(1) comment '性别'
) comment '用户信息表';


-- 创建表(约束)
create table user
(
    id       int primary key auto_increment comment 'ID, 唯一标识', -- 主键约束 auto_increment 主键自增
    username varchar(50) not null unique comment '用户名',          -- 非空 唯一
    name     varchar(10) not null comment '姓名',                   -- 非空
    age      int comment '年龄',
    gender   char(1) default '男' comment '性别'                    -- 默认: 男
) comment '用户信息表';

-- 案例: 设计员工表 emp
-- 基础字段: id 主键; create_time 创建时间; update_time 修改时间;
create table emp
(
    id          int unsigned primary key auto_increment comment 'ID 主键',
    username    varchar(20)      not null unique comment '用户名',
    password    varchar(32)               default '123456' comment '密码',
    name        varchar(10)      not null comment '姓名',
    gender      tinyint unsigned not null comment '性别: 1: 男, 2: 女',
    phone       char(11)         not null unique comment '手机号',
    job         tinyint unsigned comment '职位: 1.班主任, 2.讲师, 3.学工主管, 4.教研主管, 5.咨询师',
    salary      int unsigned comment '薪资',
    entry_date  date comment '入职日期',
    image       varchar(255) comment '图像',
    create_time datetime         not null default current_timestamp comment '创建时间',
    update_time datetime         not null default current_timestamp on update current_timestamp comment '修改时间'
) comment '员工表';

-- 查询当前数据库所有表
show tables;

-- 查看表结构
desc emp;

-- 查询建表语句
show create table db01.emp;

-- 字段：添加字段 qq varchar(13）
alter table emp
    add qq varchar(13) comment 'qq号码';

-- 字段：修改字段类型 qq varchar(15）
alter table emp
    modify qq varchar(15) comment 'qq号码';

-- 字段：修改字段名qq ->qq_num varchar(15）
alter table emp
    change qq qq_num varchar(15) comment 'qq号码';

-- 字段：删除字段 qq_num
alter table emp
    drop column qq_num;

-- 修改表名
alter table emp rename to employee;
# alter table employee rename to emp;

-- 删除表
drop table emp;
drop table if exists emp;

-- DML : 数据操作语言
-- DML : 插入数据 - insert
-- 1. 为 emp 表的 username, password, name, gender, phone 字段插入值
insert into emp(username, password, name, gender, phone)
    value (
           'zhangsan',
           '123123',
           '张三',
           '1',
           '12300001234'
    );

-- 2. 为 emp 表的 所有字段插入值
insert into emp(username, password, name, gender, phone, job, salary, entry_date, image)
    value
    ('lisi', '1231231', '李四', '1', '12300001235', '2', '1000', '2020-01-01', '1.jpg');

-- 3. 批量为 emp 表的 username, password, name, gender, phone  字段插入数据
INSERT INTO emp (username, password, name, gender, phone)
VALUES ('zhangsan', '123456', '张三', 1, '13800000001'),
       ('lisi', 'abcdef', '李四', 2, '13800000002'),
       ('wangwu', 'qwerty', '王五', 1, '13800000003');

-- DML : 更新数据 - update
-- 1. 将 emp 表的ID为1员工 用户名更新为 'zhangsan', 姓名name字段更新为 '张三'
UPDATE emp
SET username = 'heihei',
    name     = '嘿嘿'
WHERE id = 1;

-- 2. 将 emp 表的所有员工的入职日期更新为 '2010-01-01'
UPDATE emp
SET entry_date = '2010-01-01';

-- DML : 删除数据 - delete
-- 1. 删除 emp 表中 ID为1的员工
DELETE
FROM emp
WHERE id = 1;

-- 2. 删除 emp 表中的所有员工
/*
    如果你还想重置自增主键计数，可以加一句：
    TRUNCATE TABLE emp;
    •	TRUNCATE 是一种更快的清空表数据方式；
	•	它不仅删除所有数据，还会将自增主键 id 从 1 重新开始；
	•	但注意：它是 不可回滚的操作，执行前请确认无误
 */
DELETE
FROM emp;
TRUNCATE TABLE emp;

-- --------DQL语句 基本查询-------

create table emp02(
                    id int unsigned primary key auto_increment comment 'ID,主键',
                    username varchar(20) not null unique comment '用户名',
                    password varchar(32) not null comment '密码',
                    name varchar(10) not null comment '姓名',
                    gender tinyint unsigned not null comment '性别, 1:男, 2:女',
                    phone char(11) not null unique comment '手机号',
                    job tinyint unsigned comment '职位, 1:班主任,2:讲师,3:学工主管,4:教研主管,5:咨询师',
                    salary int unsigned comment '薪资',
                    image varchar(255) comment '头像',
                    entry_date date comment '入职日期',
                    create_time datetime comment '创建时间',
                    update_time datetime comment '修改时间'
) comment '员工表';


-- 准备测试数据
INSERT INTO emp02(id, username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time)
VALUES (1,'shinaian','123456','施耐庵',1,'13309090001',4,15000,'1.jpg','2000-01-01','2024-04-11 16:35:33','2024-04-11 16:35:35'),
       (2,'songjiang','123456','宋江',1,'13309090002',2,8600,'2.jpg','2015-01-01','2024-04-11 16:35:33','2024-04-11 16:35:37'),
       (3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'3.jpg','2008-05-01','2024-04-11 16:35:33','2024-04-11 16:35:39'),
       (4,'wuyong','123456','吴用',1,'13309090004',2,9200,'4.jpg','2007-01-01','2024-04-11 16:35:33','2024-04-11 16:35:41'),
       (5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'5.jpg','2012-12-05','2024-04-11 16:35:33','2024-04-11 16:35:43'),
       (6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'6.jpg','2013-09-05','2024-04-11 16:35:33','2024-04-11 16:35:45'),
       (7,'chaijin','123456','柴进',1,'13309090007',1,4700,'7.jpg','2005-08-01','2024-04-11 16:35:33','2024-04-11 16:35:47'),
       (8,'likui','123456','李逵',1,'13309090008',1,4800,'8.jpg','2014-11-09','2024-04-11 16:35:33','2024-04-11 16:35:49'),
       (9,'wusong','123456','武松',1,'13309090009',1,4900,'9.jpg','2011-03-11','2024-04-11 16:35:33','2024-04-11 16:35:51'),
       (10,'lichong','123456','林冲',1,'13309090010',1,5000,'10.jpg','2013-09-05','2024-04-11 16:35:33','2024-04-11 16:35:53'),
       (11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'11.jpg','2007-02-01','2024-04-11 16:35:33','2024-04-11 16:35:55'),
       (12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'12.jpg','2008-08-18','2024-04-11 16:35:33','2024-04-11 16:35:57'),
       (13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'13.jpg','2012-11-01','2024-04-11 16:35:33','2024-04-11 16:35:59'),
       (14,'shijin','123456','史进',1,'13309090014',2,10600,'14.jpg','2002-08-01','2024-04-11 16:35:33','2024-04-11 16:36:01'),
       (15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'15.jpg','2011-05-01','2024-04-11 16:35:33','2024-04-11 16:36:03'),
       (16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'16.jpg','2010-01-01','2024-04-11 16:35:33','2024-04-11 16:36:05'),
       (17,'liying','12345678','李应',1,'13309090017',1,5800,'17.jpg','2015-03-21','2024-04-11 16:35:33','2024-04-11 16:36:07'),
       (18,'shiqian','123456','时迁',1,'13309090018',2,10200,'18.jpg','2015-01-01','2024-04-11 16:35:33','2024-04-11 16:36:09'),
       (19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'19.jpg','2008-01-01','2024-04-11 16:35:33','2024-04-11 16:36:11'),
       (20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'20.jpg','2018-01-01','2024-04-11 16:35:33','2024-04-11 16:36:13'),
       (21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'21.jpg','2015-01-01','2024-04-11 16:35:33','2024-04-11 16:36:15'),
       (22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'22.jpg','2016-01-01','2024-04-11 16:35:33','2024-04-11 16:36:17'),
       (23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'23.jpg','2012-01-01','2024-04-11 16:35:33','2024-04-11 16:36:19'),
       (24,'tongwei','123456','童威',1,'13309090024',5,5000,'24.jpg','2006-01-01','2024-04-11 16:35:33','2024-04-11 16:36:21'),
       (25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'25.jpg','2002-01-01','2024-04-11 16:35:33','2024-04-11 16:36:23'),
       (26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'26.jpg','2011-01-01','2024-04-11 16:35:33','2024-04-11 16:36:25'),
       (27,'lijun','123456','李俊',1,'13309090027',5,6600,'27.jpg','2004-01-01','2024-04-11 16:35:33','2024-04-11 16:36:27'),
       (28,'lizhong','123456','李忠',1,'13309090028',5,5000,'28.jpg','2007-01-01','2024-04-11 16:35:33','2024-04-11 16:36:29'),
       (29,'songqing','123456','宋清',1,'13309090029',5,5100,'29.jpg','2020-01-01','2024-04-11 16:35:33','2024-04-11 16:36:31'),
       (30,'liyun','123456','李云',1,'13309090030',NULL,NULL,'30.jpg','2020-03-01','2024-04-11 16:35:33','2024-04-11 16:36:31');

--  =================== DQL: 基本查询 ======================
-- 1. 查询指定字段 name,entry_date 并返回
select name, entry_date from emp02;

-- 2. 查询返回所有字段
select id, username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time from emp02;

select * from emp02;

-- 3. 查询所有员工的 name,entry_date, 并起别名(姓名、入职日期)
select name as 姓名, entry_date as 入职日期 from emp02;

select name as '姓 名', entry_date as 入职日期 from emp02;

-- 4. 查询已有的员工关联了哪几种职位(不要重复)
select distinct job from emp02;



--  =================== DQL: 条件查询 ======================
-- 1. 查询 姓名 为 柴进 的员工
select * from emp02 where name = '柴进';

-- 2. 查询 薪资小于等于5000 的员工信息
select * from emp02 where salary <= 5000;

-- 3. 查询 没有分配职位 的员工信息
select * from emp02 where job is null;

-- 4. 查询 有职位 的员工信息
select * from emp02 where job is not null;

-- 5. 查询 密码不等于 '123456' 的员工信息
select * from emp02 where password != '123456';

select * from emp02 where password <> '123456';

-- 6. 查询 入职日期 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间的员工信息
select * from emp02 where entry_date between '2000-01-01' and '2010-01-01';

-- select * from emp02 where entry_date between '最小值' and '最大值';

-- 7. 查询 入职时间 在 '2000-01-01' (包含) 到 '2010-01-01'(包含) 之间 且 性别为女 的员工信息
select * from emp02 where entry_date between '2000-01-01' and '2010-01-01' and gender = 2;

select * from emp02 where (entry_date between '2000-01-01' and '2010-01-01') and gender = 2;

-- 8. 查询 职位是 2 (讲师), 3 (学工主管), 4 (教研主管) 的员工信息
select * from emp02 where job = 2 or job = 3 or job = 4;

select * from emp02 where job in (2, 3, 4);

-- 9. 查询 姓名 为两个字的员工信息
select * from emp02 where name like '__';

-- 10. 查询 姓 '李' 的员工信息
select * from emp02 where name like '李%';

-- 11. 查询 姓名中包含 '二' 的员工信息
select * from emp02 where name like '%二%'



--  =================== DQL: 分组查询 ======================
-- 聚合函数

-- 1. 统计该企业员工数量
-- count(*)
select count(*) from emp02;

-- count(字段)
select count(username) from emp02;

-- count(常量) 1 -1
select count(1) from emp02;

-- 2. 统计该企业员工的平均薪资
select avg(salary) from emp02;

-- 3. 统计该企业员工的最低薪资
select min(salary) from emp02;


-- 4. 统计该企业员工的最高薪资
select max(salary) from emp02;

-- 5. 统计该企业每月要给员工发放的薪资总额(薪资之和)
select sum(salary) from emp02;




-- 分组
-- 1. 根据性别分组 , 统计男性和女性员工的数量
select gender, count(*) from emp02 group by gender;

-- 2. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
select job, count(*) from emp02 where entry_date <= '2015-01-01' group by job having count(*) >= 2;



--  =================== 排序查询 ======================
-- 1. 根据入职时间, 对员工进行升序排序
select * from emp02 order by entry_date;
select * from emp02 order by entry_date asc;

-- 2. 根据入职时间, 对员工进行降序排序
select * from emp02 order by entry_date desc;

-- 3. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 更新时间 进行降序排序
select * from emp02 order by entry_date, update_time desc;



--  =================== 分页查询 ======================
-- 1. 从起始索引0开始查询员工数据, 每页展示5条记录
select * from emp02 limit 0, 5;
select * from emp02 limit 5;

-- 2. 查询 第1页 员工数据, 每页展示5条记录
select * from emp02 limit 0, 5;


-- 3. 查询 第2页 员工数据, 每页展示5条记录
select * from emp02 limit 5, 5;

-- 4. 查询 第3页 员工数据, 每页展示5条记录
select * from emp02 limit 10, 5;

-- 页码
-- 起始索引 = ( 页码 - 1 ) * 每页展示记录数

# 1.DQL语句中的分页查询
# • 语法：Limit 起始索引，每页展示记录数
# • 注意：项目开发中，前端传递过来的是页码，需要转换为起始索引
# • 公式：（页码-1）* 每页展示记录数
