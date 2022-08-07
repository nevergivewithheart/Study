# Mysql数据库
>关系型数据库管理系统
## 数据库安装
```shell
#启动mysql
systemctl start

#查看mysql状态
systemctl status mysql

#查看mysql版本
mysqladmin --version
```
## 一、数据库管理
>首次登录，使用root用户默认无需密码登录
### 用户管理
```shell
# 登录
mysql -u 用户名 -p

#修改root用户为有密码登录(赋权以及修改密码)
grant all privileges on *.* to root@localhost identified by '密码';

#创建用户

create user 'username'@'host' identified by 'password'；
```
### 数据库信息查询
```sql
-- 查看所有数据库
show databases; 

-- 切换数据库(数据库名为DBName)
use DBName;

--列出所有的当前数据库中的表
show tables;

--列出表中的所有字段
show colums from 表名;

--列出所有表中的索引
show index from 表名;

--列出所有数据库的性能以及统计信息
show table status from 表名 ;
```

### 连接
```sql
--连接
mysql -u 用户名 -p
--推出
exit
```

## 二、数据库编辑
### 1、数据库的创建和删除
```sql
--  创建数据库
create database 数据库名;

--删除数据库
drop database 数据库名;
```
### 2、数据类型
|      |      |      |      |      |
| ---- | ---- | ---- | ---- | ---- |
|  类型 | 大小| 范围(无符号) | 范围(无符号) |用途|
|TINYINT|1 Byte|(-128,127)|(0,255)|小整数|
|SMALLINT|2 Byte|(-32768,32767)|(0,65535)|大整数|
|MEDIUMINT|3 Byte|(-838608,8388607)|(0,16777215)|大整数|
|INT或INTEGER|4 Byte|(-2147483648,2147483647)|(0,4294967295)|大整数|
|BIGINT|8 Byte|||极大整数|
|FLOAT|4 Byte|||单精度浮点类型|
|DOUBLE|8 Byte|||双精度浮点型|
|DECIMAL|对DECIMAL(M,D),如果M>D，为M+2，否则为D+2|||小数值|
||||

### 数据库