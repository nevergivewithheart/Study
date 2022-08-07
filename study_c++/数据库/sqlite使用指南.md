# sqlite3使用指南

前言

## sqlite库的编译及使用

### 一、windows平台的编译链接



## sql语句以及常用指令

### 一、创建/打开数据库

```shell
sqlite3 databaseFilename
# 具体操作如下
sqlite3  test.db
```

### 二、数据库基本命令

```shell
#查看所有数据
.databases

#查看所有的表
.tables

#设置显示的信息按列排好
.mode column

#查看表中的字段信息
PRAGMA table_info(tableName);

#查看创建指定表的sql语句
.schema tablename

#在查询数据显示结果时显示(关闭)表字段名
.header on|off
```

### 三、SQL语句的使用

#### 1.1 select语句

```sql
select 列名1，列名2  from 表名  where  条件;
/*如下为用户管理的简单的表的结构*/
cid         name        type        notnull     dflt_value  pk        
----------  ----------  ----------  ----------  ----------  ----------
0           id          integer     0                       1         
1           userName    text        1                       0         
2           userType    integer     1                       0         
3           userBuildT  integer     1                       0         
4           userPasswo  text        1                       0    

/*查找表的所有数据*/
select * from userInfo;
/*结果如下：*/
id  userName    userType  userBuildType  userPassword
--  ----------  --------  -------------  ------------
1   SuperAdmin  0         1              Netvine123
2   Admin       1         1              Netvine123
3   Audit       2         1              Netvine123

/*搜索用户类型大于1的用户数据*/
select * from userInfo where userType>=1;

/*结果如下*/
id  userName  userType  userBuildType  userPassword
--  --------  --------  -------------  ------------
2   Admin     1         1              Netvine123
3   Audit     2         1              Netvine123

/*查看所有用户名和密码*/
select userName, userPassword from userInfo;
/*结果如下*/
userName    userPassword
----------  ------------
SuperAdmin  Netvine123
Admin       Netvine123
Audit       Netvine123
```

##### 1.1.1 关键字 distinct

```sql
/*搜索某一列不重复的数据*/
select distinct 字段名 from 表名  where  条件；/*条件可以省略*/
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           mike        1           0              yqgy981202  
2           naxy        1           0              981202      
3           nocpo       1           1              12rafafa    
4           note        2           1              12rafafa    
5           sir         0           1              12rafafa   

select id,  distinct userPassword from userInfo;
/*执行结果*/
userPassword
------------
yqgy981202  
981202      
12rafafa   
```

##### 1.1.2限制结果

```sql
/*只需要检索结果的前n行*/
select 列名1，列名2.... from  表名  where  条件   limit n;

sqlite> select * from userInfo limit 2;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           mike        1           0              yqgy981202  
2           naxy        1           0              981202     

/*从n2行后开始检索显示前n1行结果*/
select 列名1，列名2.... from  表名  where  条件   limit n1  offset n2;

sqlite>  select * from userInfo  where  userType=1 limit 2 offset 1;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
2           naxy        1           0              981202      
3           nocpo       1           1              12rafafa    

sqlite>  select * from userInfo  where  userType=1 limit 2 offset 2;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
3           nocpo       1           1              12rafafa  
```

##### 1.1.3  注释

```sql
/*注释*/
```

##### 1.1.4 排序检索数据

```sql
/*排序数据*/
select 列名1，列名2，列名2 from userInfo  order  by 列名1，列名2，列名2....；
sqlite>  select * from userInfo order by userPassword;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
3           nocpo       1           1              12rafafa    
4           note        2           1              12rafafa    
5           sir         0           1              12rafafa    
2           naxy        1           0              981202      
1           mike        1           0              yqgy981202  

/*使用编号代替列名*/
select 列名1，列名2，列名2 from userInfo  order  by n1,n2；
sqlite>  select * from userInfo order by 3;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
5           sir         0           1              12rafafa    
1           mike        1           0              yqgy981202  
2           naxy        1           0              981202      
3           nocpo       1           1              12rafafa    
4           note        2           1              12rafafa    

/*按照指定的顺序进行排序，默认按照升序，使用DESC进行降序*/
select * from userInfo order by id DESC;

sqlite> select * from userInfo order by id DESC;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
5           sir         0           1              12rafafa    
4           note        2           1              12rafafa    
3           nocpo       1           1              12rafafa    
2           naxy        1           0              981202      
1           mike        1           0              yqgy981202  
```

##### 1.1.5 过滤数据

> 使用where语句进行条件过滤。

|    操作符     | 说明             |
| :-----------: | ---------------- |
|       =       | 等于             |
|      <>       | 不等于           |
|       <       | 小于             |
|      <=       | 小于等于         |
| ！<    (！>） | 不小于(不大于)   |
|       >       | 大于             |
|      >=       | 大于等于         |
|    IS NULL    | 为NULL空值       |
|    BETWEEN    | 在指定两个值之间 |

##### 1.1.6 操作符

> 与==where==组合使用的操作符号

- and操作符号

> ==and==操作符可用来连接多个条件，且条件之间的关系是‘且’，取条件的交集

``` sql
/**/
sqlite> select * from userInfo;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
3           似懂非懂        2           1              kakakak     
4           便条先生        2           1              notesir     
5           便条          2           1              notesir     
sqlite> select * from userInfo where userPassword ='notesir';
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
4           便条先生        2           1              notesir     
5           便条          2           1              notesir     
sqlite> select * from userInfo where userPassword ='notesir' and userName="便条先生";
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
4           便条先生        2           1              notesir   
```

- or操作符

> ==or==操作符可用来连接多个条件，且条件之间的关系是‘或’，取条件的并集

```sql
sqlite> select * from userInfo;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
3           似懂非懂        2           1              kakakak     
4           便条先生        2           1              notesir     
5           便条          2           1              notesir     
sqlite> select * from userInfo where userType=1;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
sqlite> select * from userInfo where userType=1 or userName='便条';
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
5           便条          2           1              notesir 
```

- in操作符号

> in操作符用来指定条件范围，in取一组可以由逗号分开，括在圆括号中的合法值

```shell
sqlite> select * from userInfo;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
3           似懂非懂        2           1              kakakak     
4           便条先生        2           1              notesir     
5           便条          2           1              notesir     
sqlite> select * from userInfo where userType in (1,2);
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
3           似懂非懂        2           1              kakakak     
4           便条先生        2           1              notesir     
5           便条          2           1              notesir     
sqlite> select * from userInfo where userType in (1);
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test    
```

#####  1.1.7 通配符

> like 操作符号，通配符只能用于文本字段（字符串）

```sql
/*通配符与like一起使用*/
sqlite> select * from userInfo;
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
2           sir         1           1              test        
3           似懂非懂        2           1              kakakak     
4           便条先生        2           1              notesir     
sqlite> select * from userInfo where userPassword like "%e%";
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
2           sir         1           1              test        
4           便条先生        2           1              notesir     
sqlite> select * from userInfo where userPassword like "%a%";
id          userName    userType    userBuildType  userPassword
----------  ----------  ----------  -------------  ------------
1           note        1           1              jkokhahhah  
3           似懂非懂        2           1              kakakak   
```



### 四、使用时的坑位

#### 1.1 错误返回

- out  of memory :sqlite 数据库的db指针可能为空，即数据库打开失败

### 五、修改表

#### 1、删除表的字段

> sqlite 目前不支持删除字段，可以考虑进行新表的创建，导入数据，以及新表重命名，最后删除旧表。

#### 2、添加表的字段

> sqlite支持表添加新字段，但是不支持修改表的名称。

```sqlite
--添加字段（表名：testTable  添加的字段：testColumn 字段类型：integer）
alter table testTable add testColumn integer;
```

#### 3、重命名表

> sqlite 支持修改表名

```sqlite
--重命名表 （原表名：oldTable  新表名：newTable）
alter table oldTable rename to newTable;
```

#### 4、表之间的数据导入

##### 4.1两表结构相同

```sqlite
--表a  表b  两表都存在
insert into b  select *from b;
```

##### 4.2 两表结构存在差异

```sqlite
--表a（a,b,c）字段的类型与表b的（d，e，f）的类型相同(假设b表为数据源表)
insert into a(a,b,c) select d,e,f from b;
```

#### 5、删除表

```sqlite
--删除表  表名：tempTable
drop table tempTable;
```

#### 6、更新表字段值

```sqlite
--更新表名：tempTable  字段名：tempColumn  字段类型：text
update tempTable set tempColumn = 'test' where id =1;
```

#### 7、判断表是否存在

```sqlite
--如果表不存在则创建
create table if not exists userInfo(uid integer primary key,uname varchar(20),mobile varchar(20));
--判断表是否存在se
select count(*) from sqlite_master where type="table" and name ="userInfo";
```



### 六、高级特性

### 1、sqlite  pragma

>- pragma 命令是一个特殊的命令，可以在SQLite环境内控制各种环境变量和状态标志（**大概率是针对已有的配置值生效**）。
>- pragma 可以设置与读取数据库的配置信息
> - **在内存中页面缓存的最大尺寸：cache_size**
>   - 内置页面缓存的默认大小为2000页，最小尺寸为10页。
> - **数据库的允许的最大页数：max_page_count**
>   - 默认值是1，073，741，823,这是一个千兆的页面，如果默认1KB的页面大小，那么数据库中增长一个兆字节
> - **数据库页的大小：page_size**
>   - 默认情况，允许的尺寸：512，1024，2048，4096，8192，16384，32768字节。改变现有数据库页面大小的唯一方式就是设置页面大小，然后立即VACUUM该数据库。6
> - **数据库的页的数量：page_count**
>   - 数据库文件的大小为page_count*page_size
>
> - **数据库的索引信息：index_info**
>   - 结果集将为每一个包含在给出列列序列的索引、表格内的列表引、列名称的列显示一行
>   - pragma index_info(index_name)
> - **数据库所有与表相关的索引：index_list**
>   - 结果集将为每个给出列序列的索引、索引名称、表示索引是否唯一的标识显示一列。
>   - pragma index_list(table_name)
> - **控制Like表达式的大小写敏感度：case_sensitive_like**
>   - 该值为false,为该操作符忽略大小写；否则，反之。
> - **数据库操作语句的返回值开关：count_changes    对于：update  insert和delete语句**
>   - 默认情况下，该值为false，即无相应的返回值。
>   - 设置为true，则每一个提到的语句将返回单行单列语句，由单一的的整数值组成，该操作整数表示操作影响的行。
> - **数据库的字符编码以及存储：encoding**
>   - 格式可以是UTF-8、UTF-16le或者UTF-16le之一。
> - **可以保存用户自定义的版本：user_version**
>   - 该值为一个32位的有符号整型值，可由开发人员设置,用于版本跟踪的目的。
> - **数据库头中的架构版本值：shema_version**
>   - 这是一个32位有符号整型，用来跟踪架构变化。
>   - 每当架构改变命令执行（如create  ...,drop....）该值就会递增
> - **临时数据库文件所使用的存储模式：temp_store**
>   - 有三种模式：
>     - 0或者DEFAULT：默认使用编译时的模式，通常时FILE.
>     - 1或者FILE：使用基于文件的存储。
>     - 2或者MEMORY：使用基于内存的存储。
> - **临时数据库文件的位置：temp_store_directory**
>   - 设置或者获取文件路径
> - **当前磁盘的同步模式：synchronous**
>   - 该模式几位控制SQLite如何将数据写入磁盘。
>   - 共有三种同步模式：
>     - 0或者OFF：不进行同步
>     - 1或者NORMAL：在关键的磁盘操作的每一个序列后同步。
>     - 2或者FULL：在每个关键的磁盘操作后同步。
>
>几个不太理解参数
>
>- **列出所有数据库的连接：database_list**
>  - 返回一个单行三列的表格，每当打开或者附加数据库时，会给出数据库中的序列号，它相关的文件。
>- **当前被标记为免费可用的数据库的页数：freelist_count**
>- **解析sql命令来控制打印状态：parser_trace**
>  - 默认情况设置为false。
>  - 设置为true时，则会打印sql解析过程的状态信息
>- **递归触发器功能：recursive_tiggers**
>  - 如果未启用递归触发器，一个出发动作将不会出发另一个出发。
>  - pragma  recursive_tiggers=true;
>- **控制数据库的删除：secure_delete**
>  - pragma secure-delete =true;
>  - 安全删除标记的默认值通常是关闭的，但是可用通过SQLITE_DELETE构建选项来改变的。
>- **将SQL跟踪结果转储到屏幕上：sql_trace**
>  - PRAGMA sql_trace=true;
>- **能否修改系统表：writable_schema**
>  - 如果设置了该参数，则以sqlite_开始的表可以创建和修改，包括sqlite_master,但是修改可能会导致该数据库损坏。

#### 1.1 vacuum

**此处说的页可是操作系统中的文件分页**

目前的两个方案都不是特别完善，目前最佳方案：开启auto-vacuum并且每天固定时间进行一次vacuum。

> 背景：
>
> - sqlite的不足之处：**对数据库的表进行删除的时候，数据库文件不会变小**
> - 原因：**sqlite只是将删除的页打了标记，即该部分数据为脏数据**。
>
> 功能：**对数据库进行反碎片化 **；
>
> 原理：**通过复制主数据库中的内容到一个临时数据库文件中，然后清空主数据，并从副本中重新载入原始的数据库文件。如此，便消除了空闲页，表中的数据排列为连续，另外会清理数据库的文件结构**。
>
> 缺点：
>
> - **需要两倍当前数据库大小的容量，增加内存占用。（与它整理碎片的原理有关，首先创建临时表存放数据，再进行整理处理）**
> - **执行命令特别耗时间**
>
> 如果表中没有明确的整型主键（integer  primary key）,**vacuum**命令可能会改变表中的条目行id；

```sqlite
-- 设置实现vacuum的实现命令
VACUUM;
--可以在特定的表上实现
VACUUM tableName;  
```



#### 1.2 auto-vacuum

> 原理：**auto-vacuum原理是将空闲的页移动到数据库的末尾，从而减小数据库的大小。**
>
> 缺陷：**数据库出现碎片化**
>
> pragma schema.auto_vacuum;
>
> pragma schema.autadmin

auto-vacuum的模式有如下三种：

> - mode的值如下：
>   - 0或者NONE：禁用 Auto-vacuum。这是默认模式，意味着数据库文件尺寸带下不会缩小，除非手动使用VACUUM命令。
>   - 1或者FULL：启用Auto-vacuum。是全自动的。在该模式下，允许数据库文件随着数据库的移除而缩小。
>   - 2或者INCREMENTAL：启用Auto-vacuum,但是必须手动激活。在该模式下，引用数据被维持，自由页面只放在自由列表中。这些页面可在任何时候使用inremental_vacuum pragma进行覆盖。 

开启、查看auto-vacuum的前提是：**在还未建表的过程中开启，成功建表后无法开启auto-vaccum** 



### 2、SQLite约束

> 约束是在表的数据列上强制执行的规则。可以用来限制插入到表中的数据类型。确保了数据库的准确性和可靠性。主要是以下常用的约束：
>
> - **NOT NULL约束**：确保某列不能有NULL值
> - **DEFAULT约束**：确保某列没有指定值时，为该列提供默认值。
> - **UNIQUE约束**：确保某列的所有值是不同的
> - **PRIMARY key 约束**：唯一标志数据库表中的各行记录。
> - **Check约束**：约束确保某列的所有值都满足一定的条件

**由于上述的约束比较见简单，不做详解，给出相应的使用例子**

```sqlite
--NOT NULL约束  PRIAMRY KEY 约束
create table company(
id 		integer primary key 	NOT NULL，
name 	text 	NOT NULL,
age 	int		NOT NULL
);

--DEFAULT 约束
create table company(
id	integer primary key NOT NULL,
name text NOT NULL,
age   int  NOT NULL,
salary real DEFAULT 500000.00
);

--UNIQUE约束
Create table company(
id integer primary key not null,
name text not null,
workId text NOT NULL UNIQUE
);

--check 约束
create table company(
id integer primary key not null,
name text not null,
age integer not null,
salay real check(salary>0)
);
```

### 3、join

> join子句用于结合两个或者多个数据库中表的记录，通过共同的值来结合两个表中字段的手段。
>
> sqlite定义了三种主要类型的连接：
>
> - 交叉连接：cross join
> - 内连接：inner join
> - 外连接：outer join

#### 3.1 交叉连接

> **交叉连接**（cross join）:把第一个表的每一行与第二个表的每一行进行匹配。如果连个输入表分别有x和y行，则产生的结果集则有x*y行。可能会产生非常大的表，使用时必须谨慎。(**又称笛卡尔积**)
>
> select  columnA,columnB,columnC  tableA  across join tableB;
>
> 其中字段a,b,c有来自a表的也有，也有来自b表的，那个表在前就按谁的顺序，单个轮询另一个表

效果如下图：

![交叉连接](./src/表交叉连接效果.png)

#### 3.2 内连接

> **内连接**（inner join）:根据连接谓词结合两个表的列值来创建一个新的结果表。查询会把table1中的每一行与table2中的每一行进行比较，找到所有满足连接谓词的行的匹配对。



#### 3.3 外连接

> **外连接**（outer join）:

  



###                      七、临时文件产生的途径

> - 临时文件的种类：
>   - 回滚日志
>   - 主数据库日志
>   - SQL语句日志
>   - 临时数据库日志
>   - 视图和子查询的临时持久化文件
>   - 临时索引文件
>   - VACUUM命令使用的临时数据库文件

#### 1、回滚日志

```sqlite
--事务的创建使用的过程中有如下
sqlite> begin;                                                                                                     sqlite> insert into test values(9,'boost',300);   
```

- 如下  .图,产生的后缀为.db-journal的临时文件文件，当事务结束后该文件将会被删除。

  <img src="./src/sqlite回滚临时文件.png" alt="产生的临时文件" style="zoom:50%;" />

- 该种i日志可以设置模式，如下

  > - DELETE：默认模式，在该模式下，在事务结束时，日志文件将被删除；
  > - TRUNCATE：日志文件被截断为0字节长度。
  > - PERSIST：日志文件被保留在原地，但头部被重写，表示日志不再有效。
  > - MEMORY：日志记录保留在内存中，而不是磁盘中。
  > - OFF:不保留任何日志记录。

```sqlite
--设置如下：注意在事务的过程中，无法改变该日志的模式。
sqlite> pragma journal_mode = PERSIST;                                                                              journal_mode                                                                                                       ------------                                                                                                        delete                                                                                                             sqlite> commit;                                                                                                     sqlite> pragma journal_mode = PERSIST;                                                                            journal_mode                                                                                                      ------------                                                                                                          persist                                                                                                              sqlite> begin;                                                                                                      sqlite> delete from test where id >4;                                                                                sqlite> select * from test;                                                                                          id  name  age                                                                                                        --  ----  ---                                                                                                        1   kill  11                                                                                                        2   kl    13                                                                                                        3   note  23                                                                                                        4   sir   30                                                                                                        sqlite> rollback;                                                                                                    sqlite> select * from test;                                                                                          id  name   age                                                                                                      --  -----  ---                                                                                                      1   kill   11                                                                                                       2   kl     13                                                                                                       3   note   23                                                                                                       4   sir    30                                                                                                       6   sir    30                                                                                                      9   boost  300                                                                                        
```

设置操作日志为常驻模式如下图：

<img src="./src/事务结束时日志依旧存在.png" alt="设置日志为常驻模式" style="zoom:50%;" />
