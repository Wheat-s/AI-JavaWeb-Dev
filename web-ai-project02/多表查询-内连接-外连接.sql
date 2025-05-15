-- 部门管理
create table dept(
                     id int unsigned primary key auto_increment comment 'ID, 主键',
                     name varchar(10) not null unique comment '部门名称',
                     create_time datetime comment '创建时间',
                     update_time datetime comment '修改时间'
) comment '部门表' ;

insert into dept (id, name, create_time, update_time) values
                                                          (1,'学工部',now(),now()),
                                                          (2,'教研部',now(),now()),
                                                          (3,'咨询部',now(),now()),
                                                          (4,'就业部',now(),now()),
                                                          (5,'人事部',now(),now());


-- 员工管理
create table emp(
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
                    dept_id int unsigned COMMENT '关联的部门ID',
                    create_time datetime comment '创建时间',
                    update_time datetime comment '修改时间'
) comment '员工表';


-- 准备测试数据
INSERT INTO `emp` VALUES (1,'shinaian','123456','施耐庵',1,'13309090001',4,15000,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2000-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:35:35'),
                         (2,'songjiang','123456','宋江',1,'13309090002',2,8600,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2015-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:35:37'),
                         (3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2008-05-01',2,'2024-10-27 16:35:33','2024-10-27 16:35:39'),
                         (4,'wuyong','123456','吴用',1,'13309090004',2,9200,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2007-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:35:41'),
                         (5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2012-12-05',2,'2024-10-27 16:35:33','2024-10-27 16:35:43'),
                         (6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2013-09-05',1,'2024-10-27 16:35:33','2024-10-27 16:35:45'),
                         (7,'chaijin','123456','柴进',1,'13309090007',1,4700,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2005-08-01',1,'2024-10-27 16:35:33','2024-10-27 16:35:47'),
                         (8,'likui','123456','李逵',1,'13309090008',1,4800,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2014-11-09',1,'2024-10-27 16:35:33','2024-10-27 16:35:49'),
                         (9,'wusong','123456','武松',1,'13309090009',1,4900,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2011-03-11',1,'2024-10-27 16:35:33','2024-10-27 16:35:51'),
                         (10,'lichong','123456','林冲',1,'13309090010',1,5000,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2013-09-05',1,'2024-10-27 16:35:33','2024-10-27 16:35:53'),
                         (11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2007-02-01',2,'2024-10-27 16:35:33','2024-10-27 16:35:55'),
                         (12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2008-08-18',2,'2024-10-27 16:35:33','2024-10-27 16:35:57'),
                         (13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2012-11-01',1,'2024-10-27 16:35:33','2024-10-27 16:35:59'),
                         (14,'shijin','123456','史进',1,'13309090014',2,10600,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2002-08-01',2,'2024-10-27 16:35:33','2024-10-27 16:36:01'),
                         (15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2011-05-01',2,'2024-10-27 16:35:33','2024-10-27 16:36:03'),
                         (16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2010-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:36:05'),
                         (17,'liying','12345678','李应',1,'13309090017',1,5800,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2015-03-21',1,'2024-10-27 16:35:33','2024-10-27 16:36:07'),
                         (18,'shiqian','123456','时迁',1,'13309090018',2,10200,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2015-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:36:09'),
                         (19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2008-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:36:11'),
                         (20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2018-01-01',2,'2024-10-27 16:35:33','2024-10-27 16:36:13'),
                         (21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2015-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:15'),
                         (22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2016-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:17'),
                         (23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2012-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:19'),
                         (24,'tongwei','123456','童威',1,'13309090024',5,5000,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2006-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:21'),
                         (25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2002-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:23'),
                         (26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2011-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:25'),
                         (27,'lijun','123456','李俊',1,'13309090027',5,6600,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2004-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:27'),
                         (28,'lizhong','123456','李忠',1,'13309090028',5,5000,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2007-01-01',3,'2024-10-27 16:35:33','2024-10-27 16:36:29'),
                         (29,'songqing','123456','宋清',1,'13309090029',NULL,5100,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2020-01-01',NULL,'2024-10-27 16:35:33','2024-10-27 16:36:31'),
                         (30,'liyun','123456','李云',1,'13309090030',NULL,NULL,'https://dawn-itcast.oss-cn-hangzhou.aliyuncs.com/01.png','2020-03-01',NULL,'2024-10-27 16:35:33','2024-10-27 16:36:31');


-- 查询
select * from emp;

select * from emp, dept;

select * from emp, dept where emp.dept_id = dept.id;


-- ============================= 内连接 ==========================
-- A. 查询所有员工的ID, 姓名 , 及所属的部门名称 (隐式、显式内连接实现)
-- 隐式
select emp.id, emp.name, dept.name  from emp, dept where emp.dept_id = dept.id;

-- 显式
select emp.id, emp.name, dept.name  from emp inner join dept on emp.dept_id = dept.id;

select emp.id, emp.name, dept.name  from emp join dept on emp.dept_id = dept.id;

-- B. 查询 性别为男, 且工资 高于8000 的员工的ID, 姓名, 及所属的部门名称 (隐式、显式内连接实现)
-- 隐式
select emp.id, emp.name, dept.name  from emp, dept where emp.dept_id = dept.id and emp.gender = 1 and emp.salary > 8000;

-- 显式
select emp.id, emp.name, dept.name  from emp join dept on emp.dept_id = dept.id where emp.gender = 1 and emp.salary > 8000;

-- 别名
select e.id, e.name, d.name  from emp e join dept d on e.dept_id = d.id where e.gender = 1 and e.salary > 8000;


-- =============================== 外连接 ============================
-- A. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select e.name, d.name from emp e left outer join dept d on e.dept_id = d.id;

-- B. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select d.name, e.name from emp e right  join dept d on e.dept_id = d.id;

-- C. 查询工资 高于8000 的 所有员工的姓名, 和对应的部门名称 (左外连接)
select e.name, d.name from emp e left join dept d on e.dept_id = d.id where e.salary > 8000;

select d.name, e.name from emp e right join dept d on e.dept_id = d.id where e.salary > 8000;























