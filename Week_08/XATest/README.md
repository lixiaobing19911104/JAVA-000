#ShardingSphere RAW JDBC XA
##作业
    基于hmily TCC或ShardingSphere的Atomikos XA实现一个简单的分布式事务应用demo（二选一），提交到github

##环境
```sql
# 启动两个mysql
docker run --name mysql11 -p 3311:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_HOST=% -d mysql:5.7
docker run --name mysql12 -p 3312:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_ROOT_HOST=% -d mysql:5.7

# 在11上创建数据库demo_ds_0，运行下面的SQL语句初始化数据库和表
docker exec -ti mysql11 mysql -u root -p

create database demo_ds_0;
use demo_ds_0;
CREATE TABLE IF NOT EXISTS t_order_0 (order_id BIGINT NOT NULL, user_id INT NOT NULL, PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS t_order_1 (order_id BIGINT NOT NULL, user_id INT NOT NULL, PRIMARY KEY (order_id));
    

# 在12上创建数据库demo_ds_1，运行下面的SQL语句初始化数据库和表
docker exec -ti mysql12 mysql -u root -p

create database demo_ds_1;
use demo_ds_1;
CREATE TABLE IF NOT EXISTS t_order_0 (order_id BIGINT NOT NULL, user_id INT NOT NULL, PRIMARY KEY (order_id));
CREATE TABLE IF NOT EXISTS t_order_1 (order_id BIGINT NOT NULL, user_id INT NOT NULL, PRIMARY KEY (order_id));

```