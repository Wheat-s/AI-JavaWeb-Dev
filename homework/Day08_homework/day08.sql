-- 部门管理
create table tb_dept
(
    id          int unsigned primary key auto_increment comment '主键ID',
    name        varchar(10) not null unique comment '部门名称',
    create_time datetime    not null comment '创建时间',
    update_time datetime    not null comment '修改时间'
) comment '部门表';

insert into tb_dept (id, name, create_time, update_time)
values (1, '学工部', now(), now()),
       (2, '教研部', now(), now()),
       (3, '咨询部', now(), now()),
       (4, '就业部', now(), now()),
       (5, '人事部', now(), now());

-- 员工管理
create table tb_emp
(
    id          int unsigned primary key auto_increment comment 'ID',
    username    varchar(20)      not null unique comment '用户名',
    password    varchar(32) default '123456' comment '密码',
    name        varchar(10)      not null comment '姓名',
    gender      tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
    image       varchar(300) comment '图像',
    job         tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
    entrydate   date comment '入职时间',
    dept_id     int unsigned comment '部门ID',
    salary      int unsigned comment '工资',
    create_time datetime         not null comment '创建时间',
    update_time datetime         not null comment '修改时间'
) comment '员工表';

INSERT INTO tb_emp
(id, username, password, name, gender, image, job, entrydate, dept_id, salary, create_time, update_time)
VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, 20000, now(), now()),
       (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, 18000, now(), now()),
       (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, 16800, now(), now()),
       (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, 12000, now(), now()),
       (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, 9000, now(), now()),
       (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, 6000, now(), now()),
       (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, 6500, now(), now()),
       (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, 7200, now(), now()),
       (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, 5300, now(), now()),
       (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, 12000, now(), now()),
       (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, 8900, now(), now()),
       (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, 7800, now(), now()),
       (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, 6800, now(), now()),
       (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, 15800, now(), now()),
       (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', 2, 11500, now(), now()),
       (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2007-01-01', 2, 8300, now(), now()),
       (17, 'chenyouliang', '123456', '陈友谅', 1, '17.jpg', NULL, '2015-03-21', NULL, 4500, now(), now());


-- 薪资等级表
create table tb_salgrade
(
    grade int comment '等级',
    losal int comment '该等级最低薪资',
    hisal int comment '该等级最高薪资'
) comment '薪资等级表';

insert into tb_salgrade
values (1, 0, 3000);
insert into tb_salgrade
values (2, 3001, 5000);
insert into tb_salgrade
values (3, 5001, 8000);
insert into tb_salgrade
values (4, 8001, 10000);
insert into tb_salgrade
values (5, 10001, 15000);
insert into tb_salgrade
values (6, 15001, 20000);
insert into tb_salgrade
values (7, 20001, 25000);
insert into tb_salgrade
values (8, 25001, 30000);


-- 1. 查询员工的姓名 , 及所属的部门名称 (隐式内连接实现)
select e.name, d.name
from tb_emp e,
     tb_dept d
where e.dept_id = d.id;

-- 2. 查询员工的姓名 , 及所属的部门名称 (显式内连接实现)
select e.name, d.name
from tb_emp e
         inner join tb_dept d on e.dept_id = d.id;

-- 3. 查询员工的 姓名、性别、职位、部门名称 （隐式内连接）
select e.name, e.gender, e.job, d.name
from tb_emp e,
     tb_dept d
where e.dept_id = d.id;

-- 4. 查询 薪资 高于 10000 的员工的姓名、性别、职位、部门名称（显式内连接）
select e.name, e.gender, e.job, e.salary, d.name
from tb_emp e
         join
     tb_dept d
     on e.dept_id = d.id
         and e.salary > 10000;

-- 5. 查询员工表 所有 员工的姓名, 和对应的部门名称 (左外连接)
select e.name, d.name
from tb_emp e
         left join tb_dept d on e.dept_id = d.id;

-- 6. 查询员工表 所有 员工的姓名, 和对应的部门名称 (右外连接)
select e.name, d.name
from tb_emp e
         right join tb_dept d on e.dept_id = d.id;

-- 7. 查询部门表 所有 部门的名称, 和对应的员工名称 (右外连接)
select d.name, e.name
from tb_dept d
         right join tb_emp e on d.id = e.dept_id;

-- 8. 查询 "教研部" 的所有员工信息 （标量子查询）
select id
from tb_dept
where name = '教研部';
select *
from tb_emp
where dept_id = (select id from tb_dept where name = '教研部');

-- 9. 查询在 "方东白" 入职之后的员工信息 （标量子查询）
select *
from tb_emp
where name = '方东白';
select *
from tb_emp
where entrydate > (select entrydate from tb_emp where name = '方东白');


-- 10. 查询 "教研部" 和 "咨询部" 的所有员工信息 （列子查询）
select id
from tb_dept
where name in ('教研部', '咨询部');
select *
from tb_emp
where dept_id in (3, 2);
select *
from tb_emp
where dept_id in (select id from tb_dept where name in ('教研部', '咨询部'));

-- 11. 查询与 "韦一笑" 的入职日期 及 职位都相同的员工信息 （行子查询）
select entrydate, salary
from tb_emp
where name = '韦一笑';
select *
from tb_emp
where (entrydate, job) = (select entrydate, job from tb_emp where name = '韦一笑');

-- 12. 查询入职日期是 "2006-01-01" 之后的员工信息 , 及其部门信息 （表子查询）
select *
from tb_emp
where entrydate > '2006-01-01';

select *
from (select * from tb_emp where entrydate > '2006-01-01') e
         join tb_dept d on e.dept_id = d.id;

SELECT e.name, d.name AS dept_name, e.entrydate
FROM (SELECT *
      FROM tb_emp
      WHERE entrydate > '2006-01-01') e
         JOIN tb_dept d ON e.dept_id = d.id;
-- 13. 查询 拥有员工的 部门ID、部门名称 (没有员工的部门无需展示)
select dept_id, d.name
from tb_emp e,
     tb_dept d
where e.dept_id = d.id;

select *
from tb_dept;

select *
from tb_dept
where id in (select dept_id from tb_emp);


-- 14. 查询所有 在 2010-01-01 之后入职的员工, 及其归属的部门名称; 如果员工没有分配部门, 也需要展示出来
select *
from tb_emp
where entrydate > '2010-01-01';

select e.name, e.entrydate, d.name AS dept_name
from tb_emp e
         left join tb_dept d on e.dept_id = d.id
where e.entrydate > '2010-01-01';

-- 15. 查询 "教研部" 员工的平均工资
select id
from tb_dept
where name = '教研部';

select *
from tb_emp
where dept_id = (select id from tb_dept where name = '教研部');

select avg(salary)
from tb_emp
where id in (select id from tb_emp where dept_id = (select id from tb_dept where name = '教研部'));
select avg(salary)
from tb_emp
where dept_id in (select id from tb_dept where name = '教研部');

-- 16. 查询工资比 "俞莲舟" 高的员工信息。
select salary
from tb_emp
where name = '俞莲舟';
select name, salary
from tb_emp
where salary > (select salary from tb_emp where name = '俞莲舟');

-- 17. 查询 工资 比该企业员工的平均薪资 还要高的员工信息
select avg(salary)
from tb_emp;
select name, salary
from tb_emp
where salary > (select avg(salary) from tb_emp);

-- 18. 查询所有的部门信息, 并统计部门的员工人数
select d.name, count(e.id) as emp_count
from tb_dept d
         left join tb_emp e on d.id = e.dept_id
group by d.name;
、
select d.name, count(e.id)
from tb_dept d
         left join tb_emp e on d.id = e.dept_id
group by d.name
SELECT d.name,
       (SELECT COUNT(*)
        FROM tb_emp e
        WHERE e.dept_id = d.id) AS emp_count
FROM tb_dept d;

-- 19. 查询所有员工的 姓名, 工资 , 及 工资等级 (有难度的哦)
select name, salary
from emp;
select *
from tb_salgrade;
select e.name, e.salary, s.grade
from emp e
         left join tb_salgrade s on e.salary between s.losal and s.hisal;
-- 20. 查询 "教研部" 所有员工的信息 及 工资等级 (有难度的哦)
select e.name, e.salary
from tb_dept d
         left join tb_emp e on d.id = e.dept_id
where d.name = '教研部';
select e.name, e.salary, s.grade
from (select e.name, e.salary
      from tb_dept d
               left join tb_emp e on d.id = e.dept_id
      where d.name = '教研部') e
         left join
     tb_salgrade s on e.salary between s.losal and s.hisal;

SELECT e.name, e.salary, s.grade
FROM tb_emp e
         JOIN tb_dept d ON e.dept_id = d.id
         JOIN tb_salgrade s ON e.salary BETWEEN s.losal AND s.hisal
WHERE d.name = '教研部';

-- 21. 查询 工资 低于 本部门平均工资的员工信息 (有难度的哦)
SELECT e.name, e.salary, e.dept_id
FROM tb_emp e
         JOIN (SELECT dept_id, AVG(salary) AS avg_salary
               FROM tb_emp
               GROUP BY dept_id) dept_avg
              ON e.dept_id = dept_avg.dept_id
WHERE e.salary < dept_avg.avg_salary;

-- 22. 列出所有部门的详细信息(包括部门ID, 部门名称)和人数
SELECT d.id, d.name, COUNT(e.id) AS emp_count
FROM tb_dept d
         LEFT JOIN tb_emp e ON d.id = e.dept_id
GROUP BY d.id, d.name;


-- 23、取得每个薪资等级有多少员工  (有难度的哦)
select *
from tb_salgrade;
select sal.grade, count(e.id)
from tb_emp e
         left join tb_salgrade sal on e.salary between sal.losal and sal.hisal
group by sal.grade
order by sal.grade;

-- 24. 取得每个部门最高薪水的人员名称
select dept_id, max(salary)
from tb_emp e
group by e.dept_id;

select e.name, e.salary
from tb_emp e
         JOIN tb_dept d ON e.dept_id = d.id
WHERE (e.dept_id, e.salary) IN (
    SELECT e.dept_id, MAX(e.salary)
    FROM tb_emp e
    GROUP BY e.dept_id
);