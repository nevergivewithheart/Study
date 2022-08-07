## 一、GDB常用命令
|      |      |      |
| ---- | ---- | ---- |
|命令名|命令缩写|命令说明|
|run|r|运行待调试的程序|
|continue|c|让暂停的程序继续运行|
|next|n|运行到下一行|
|step|s|单步执行，遇到函数会进入|
|until|u|运行到指定位置停下|
|finish|fi|结束当前函数调用，会到上一层函数调用处|
|return|return|结束当前函数并返回指定值，到上一层函数|
|jump|j|将当前程序执行流转到指定行或者地址|
|print|p|打印变量或者寄存器值|
|backtrace|bt|查看当前线程的调用堆栈|
|frame|f|切换到当前调用线程的指定堆栈|
|thread|thread|切换到指定线程|
|break|b|添加断点|
|tbreak|tb|添加临时断点|
|delete|d|删除断点|
|enable|enable|启用某个断点|
|disable|disable|禁用某个断点|
|watch|watch|监视某个变脸或者内存地址的值是否发生变化|
|list|l|显示源码|
|info|i|显示断点/线程等信息|
|ptype|ptype|查看变量类型|
|disassemble|dis|查看汇编代码|
|set args|set args|设置程序启动命令行参数|
|show args|show args|查看设置的命令行参数|
||||

## 二、GDB的使用流程
>### 1.编译一个可调试的可执行程序
>```shell
>g++ -g test.cpp -o test
>```
>### 2.启动GDB
>```shell
>#普通启动
>gdb 可执行程序名
>#带参数启动
>gdb -q 可执行程序名
>```
>### 3.执行程序
>```shell
>#简写（r）直接运行程序
>run
>```
>#### 单步执行
>```shell
>next (简化n) 单步步过，遇到函数直接跳过，不进入函数内部
>step (简化s) 单步步入，遇到函数会进入内部
>```
>#### 退出函数
>```shell
>return 立即退出当前函数，剩下的代码不会执行，可以指定函数的返回值
>finish 会继续执行完该函数剩余代码后正常退出
>```
>#### jump
>```shell
>#1、中间跳过的代码不会执行、
>#2、调到的位置如果没有断点，gdb会自动继续往后执行
>jump lineNum：跳转到代码lineNum的位置
>jump +10 跳转当前代码下10行位置
>jump *0x12323432 跳转到指定的地址代码处，地址前要加星号
>```
>### 4.设置断点
>```shell
>#简写（b）直接运行程序
>1、位置断点
>break 行号
>b 路径、文件名：行号（ b /test/test.cpp:78）
>b 路径、文件名：函数名(b /test/test.cpp:funcName)
>#在当前程序暂停的位置前/后offset 行处下断点
>b -/+offset,
>#在函数入口处设置断点
>b 函数名 （b AddData）
>2、条件断点
> b  ... if condition
> ```
> #### 查看断点
> ```shell
> info breakpoints (简化 i  b)
> Num     Type          Disp Enb Address            What
>1       breakpoint     keep y   0x0000555555554ab1 in main() at test.cpp:55
>        breakpoint already hit 1 time
>2       breakpoint     keep y   0x0000555555554ac8 in main() at test.cpp:58
>        breakpoint already hit 32 times
>3       breakpoint     keep y   0x0000555555554ace in main() at test.cpp:60
>        breakpoint already hit 31 times
> Num:断点编号
> Disp:执行一次后是否有效【kep:有效；dis:无效】
> En:当前断点是否有效
> Adress:内存地址
> What:位置
> ```
>#### 修改断点信息
> ```shell
> delete 断点编号：删除第n个断点
> disable 断点编号：暂停第n个断点
> enable 断点编号：开启第n个断点
> clear 行号：清除第n行的断点
> 
>delete breakpoints :清除所有断点
>```
>### 3.查看源码
>```shell
>list 简化为l
>#以某行为中心前后10行
>list 行号(list 路径/文件名：行号)
>
>#列出函数名所在函数的代码附近代码
>list 函数名(list 路径名/文件名:函数名)
>
>#显示上一次list命令查出的code
>list -
>
>#显示指定位置的代码
>list from to
>
>#默认每次显示10行
>list
>
>#查看list显示的代码行数以及进行修改
>show listsize : 查看list命令显示的代码行数；
>set listsize count :设置list命令显示的行数
>```
>### 4.打印表达式
>```shell
>print (简化为p)
> print a 打印变量值
> print *this 在c++对象中，输出当前对象的各个变量的值
> print pragma=value 用于在调试过程中修改变量的值
> print ++a 打印表达式
> print func(22) 打印函数调用结果
> print func(a) 打印以某个变量为参数的函数调用
>```
>#### **display**
>```shell
>作用：设置表达式后每次单步执行都会打印该表达式
>display 表达式
>```
>#### **watch**
>```shell
>作用：设置监视点，一旦被监视的表达式值发生改变，gdb则强行终止正在被调试的程序；
>//TODO:不知道意义在哪里
>watch 表达式
>```
>#### **whatis**
>```shell
>作用：查新变量或者函数类型
>whatis 表达式
>ptype val :作用于whatis类似，但是额外支持查看复合类型，会打出该类型的成员变量
>```
>#### **info locals**
>```shell
>作用:显示当前堆栈所有页的所有变量
>```
>### 5.查看运行信息
>```shell
>where/bt:当前运行的栈列表
>bt backtrace :显示当前的调用栈
>up/down 改变当前堆栈的显示深度
>set args参数：指定运行时的参数
>show args:查看设置好的参数、
>```
>### 6.分割窗口
>```shell
>layout src:显示源代码窗口
>layout asm:显示反汇编窗口
>layout regs:显示源代码/反汇编窗口和cpu寄存器窗口
>layout split:显示源码和反汇编窗口
>ctrl+L:刷新窗口
>```

