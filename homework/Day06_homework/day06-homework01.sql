-- 1. 查询所有的性别为男(gender 为 1)的 讲师 (job 为 2) , 并根据入职时间, 对员工进行升序排序
select * from emp where gender = '1' and job = '2' order by entry_date asc;

-- 2. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序
select * from emp  order by entry_date asc, id desc;

-- 3. 查询性别为男(gender 为 1) 且 薪资大于 6000 的员工, 并根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序
select * from emp where gender = '1' and salary > 6000 order by entry_date asc, id desc;

-- 4. 查询性别为男(gender 为 1)的员工 且 在 '2005-10-01' 至 '2018-10-01' 之间入职的员工, 并根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序
select * from emp where gender = '1' and entry_date between '2005-10-01' and '2018-10-01' order by entry_date asc, id desc;

-- 5. 查询姓 '阮' 且 在 '2010-10-01' 之后入职的员工, 并根据入职时间进行升序排序, 并对结果分页操作, 展示第1页员工数据, 每页展示5条记录
select * from emp where name like '阮%' and entry_date > '2010-10-01' order by entry_date asc limit 0,5;