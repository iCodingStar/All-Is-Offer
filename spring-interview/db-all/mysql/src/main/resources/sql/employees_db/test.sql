USE employees;
# 查看表employees.titles中存在的索引
SHOW INDEX FROM employees.titles;

# 丢弃掉辅助索引emp_no
# ALTER TABLE employees.titles DROP INDEX emp_no;

# 最左前缀原理---完全匹配
EXPLAIN
SELECT *
FROM employees.titles
WHERE emp_no = '10001'
      AND from_date = '1986-06-26';

# 查看title几种不同的值
SELECT DISTINCT (title)
FROM employees.titles;

# 使用IN补坑使其符合最左前缀的原理
EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no = '10001'
              AND from_date = '1986-06-26';

EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no = '10001'
              AND title IN
                  ('Senior Engineer', 'Staff', 'Engineer', 'Senior Staff', 'Assistant Engineer', 'Technique Leader', 'Manager')
              AND from_date = '1986-06-26';

SHOW PROFILES;
# 开启SHOW PROFILES性能展示功能
SHOW VARIABLES LIKE '%profil%';
SHOW PROFILES;
SET PROFILING = 1;
SET PROFILING_HISTORY_SIZE = 100;
SHOW PROFILES;
# 查询条件没有指定索引第一列
EXPLAIN SELECT *
        FROM employees.titles
        WHERE from_date = '1986-06-26';

SHOW PROFILES;

# 匹配某列的前缀字符串
EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no = '10001' AND title LIKE 'Senior%';

# 范围查询
EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no < '10010' AND title = 'Senior Engineer';

# between and 不一定就是范围查询
EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no BETWEEN '10001' AND '10010'
              AND title = 'Senior Engineer'
              AND from_date BETWEEN '1986-01-01' AND '1986-12-31';

# 包含函数与表达式
EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no = '10001' AND left(title, 6) = 'Senior';

# 包含计算，不会使用索引
EXPLAIN SELECT *
        FROM employees.titles
        WHERE emp_no - 1 = '10000';

# 计算索引的选择性
SELECT COUNT(DISTINCT (title))
FROM titles;
SELECT COUNT(*)
FROM titles;
SELECT
  COUNT(DISTINCT (title))            AS Dis_Title,
  COUNT(*)                           AS All_records,
  COUNT(DISTINCT (title)) / COUNT(*) AS Selectivity
FROM titles;

SHOW INDEX FROM employees.employees;

# 查看employees表
EXPLAIN SELECT *
        FROM employees.employees
        WHERE first_name = 'Eric' AND last_name = 'Anido';

SELECT count(DISTINCT (first_name)) / count(*) AS Selectivity
FROM employees.employees;

SELECT count(DISTINCT (concat(first_name, last_name))) / count(*) AS Selectivity
FROM employees.employees;

SELECT
  count(*)                                        AS total,
  count(DISTINCT (concat(first_name, last_name))) AS new_total
FROM employees.employees;


SELECT count(DISTINCT (concat(left(first_name, 8), left(last_name, 7)))) / count(*) AS Selectivity
FROM employees.employees;

# 为employee表添加索引 (no images.mysql.index time:0.000234,add images.mysql.index time:0.00020075)
ALTER TABLE employees.employees
  ADD INDEX `first_name_last_name4` (first_name, last_name(4));

# 删除索引
ALTER TABLE employees.employees
    DROP INDEX `first_name_last_name4`;

SHOW INDEX FROM employees.employees;

SELECT *
FROM employees.employees
WHERE first_name = 'Eric' AND last_name = 'Anido';

SHOW PROFILES ;
# 未添加索引时,查询时间 0.105929
# 添加索引后,查询时间 0.0003165
