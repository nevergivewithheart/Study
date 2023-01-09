# make的学习
>make file 的代码去的开头使用tab键，不能利用空格替换
## 1、make可以自动寻找编译
```make
make HelloWorld
```
make就会在当前目录下寻找该名称的源文件进行编译
编译是针对单个文件进行生成汇编
### 编译过程
- 预处理
- 编译
- 汇编
- 链接
### gcc基本使用
-  -c仅对源文件进行编译，不链接生成执行文件.
-  -g [gdb]生成调试信息
-  -o [0、1、2、3]优化等级
-  -Idir 编译源程序搜索头文件的额外目录--**dir**,即include增加一个搜索的额外目录
-  -Ldir 编译源文件时增加一个搜索库的额外目录--**dir**
-  -llibrary 编译链接文件时增加一个额外的库，库名为liblibrary.so
-  -w 禁止所有警告
-  Wwarning 允许产生warning类型的告警  最常用的是wall
-  -E 进行预处理
-  -S 进行编译
-  -c 进行汇编转二进制
-  -o 链接

> 在windows上链接与运行的库是两种文件件：链接用lib文件，运行则使用dll文件；linux则两个过程使用相同文件。

### make和makefile

#### makefile包含5部分内容
- 显式规则：说明了如何生成一个或多个目标文件【要生成的文件、文件的依赖文件、生成命令】。
- 隐式规则：利用make自动推导的功能，粗略地书写makefile文件
- 变量定义
- 文件指示：1、Makefile文件之间相互引用；2、指定文件中有效的部分；
- 注释：#

#### makefile变量
 - 系统自带变量
  - 手动定义变量
  - make传递变量
  - 自动推理参数设置
  
预定义变量
-  CXX: 默认g++
-  RM：默认为rm -f
-  CXXFLAGS:c++编译器的选项，无默认值（头文件路径）

系统变量
-  $* :不包含扩展名的目标文件名称
-  $+ :所有依赖的文件，以空格分开，并以出现的先后的序，可能包含重复的依赖文件；
-  $< :第一个依赖文件的名称
-  $? :所有时间戳比目标文件晚的依赖文件，并以空格分开
-  $@ ：目标文件的完整名称
-  $^ :所有不重复的依赖文件，以空格分开
-  $% :如果目标是归档成员，则该变量表示目标的归档成员名称；

第一次赋值直接使用= ；
后面修改需要使用:= ;

变量使用
>#系统变量
>- $(变量名)
>
>自定义变量
>TARGET=test
>$(TARGET)

代码区间可以添加命令
- 在命令前添加@ 可以让执行的命令隐藏
- 在命令前加-可以要求：即便当前命令执行失败，下面的命令继续正常执行

#### 自动推导 
- CXXFLAGS

#### 伪目标
- .PHONY: 伪目标名 

## gcc编译链接库
>静态库和动态库都是由.o文件生成

>在Windows下静态库的后缀为：.lib，动态库后缀为：.dll;
>在Linux下静态库后缀为：.a;动态库后缀为:.so;
### 静态链接库的编译
```shell
# 1、生成.o  由FuncTools.cpp生成FuncTools.o
g++ -c FuncTools.cpp

# 2、生成静态库 .a  由 FuncTools.o生成libFuncTools.a  
ar cr libFuncTools.a  FuncTools.o

# 3、链接调用  需要-l后面加对应的库名  -L后面加.h文件寻找的路径
g++ main.cpp -o  main -static -lFuncTools -L.

```

### 动态链接库的编译
>-fPIC 作用于编译阶段，告知编译器生成与位置无关代码（Position-Independent Code）,产生的代码中没有绝对地址，全部都是相对地址，所以代码能被加载内存的任意位置，实现真正意义上的共享。

>-shared表示共享的，用于实现程序的动态链接功能，和前一个参数往往搭配使用。

```shell
#生成.o文件
g++ xthread.cpp -fPIC -c  

#生成动态库
g++ -shared xthread.o -o libxthread.so

#链接动态库生成可执行文件
g++ main.cpp -L. -lDealData -o main

#通过ldd命令查看可执行文件的链接状况
ldd main
        linux-vdso.so.1 (0x00007ffe9e773000)
        libDealData.so => not found
        libstdc++.so.6 => /usr/lib/x86_64-linux-gnu/libstdc++.so.6 (0x00007fdf8ffb6000)
        libc.so.6 => /lib/x86_64-linux-gnu/libc.so.6 (0x00007fdf8fbc5000)
        libm.so.6 => /lib/x86_64-linux-gnu/libm.so.6 (0x00007fdf8f827000)
        /lib64/ld-linux-x86-64.so.2 (0x00007fdf90542000)
        libgcc_s.so.1 => /lib/x86_64-linux-gnu/libgcc_s.so.1 (0x00007fdf8f60f000)

#LD_LIBRARY_PATH：这个环境变量指示动态链接器可以装载动态库的路径
export LD_LIBRARY_PATH=./
```
库的命名规范在其他笔记中添加
