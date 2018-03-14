## mysql数据库

### 开启慢查询
```mysql
slow-query-log=On
slow_query_log_file=/data/mysql/log/mysql_slow_query.log
long_query_time=2
log_queries_not_using_indexes = ON
``` 
  * 如何定位慢sql