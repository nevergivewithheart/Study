# git使用指南

## 一、Git的安装与常用命令

## 1.1 	Git环境配置

### 1.1.1	下载与安装

### 1.1.2 	基本配置

- 在本地配置用户信息

```shell
###1、查看本地配置的个人信息
git config --list

###2、定义全局的用户名
git config --global user.name "*****"
###3、定义全局的邮件地址
git config --global user.email "****"
```

### 1.1.3  	为常用命令配置别名（可选）

1. 在用户目录下创建.bashrc文件

   1. ```shell
      touch .bashrc
      ```

2. 在.bashrc文件中输入下面内容

   1. ```shell
      ##用于输出git提交日志
      alias git-log='git log --pretty=online --all --graph --abbrev-commit'
      #用于输出当前目录下所有文件及基本信息
      alias ll='ls -al'
      ```

3. 打开git bash,执行source ~/.bashrc

   1. ```shell
      source ~/.bashrc
      ```


### 1.1.4	 解决Git Bash乱码

1. 打开git bash执行下面命令

   1. ```SHE
      git config --global core.quotepath false
      ```

2. ${git_home}/etc/bash.bashrc 文件最后加入下面两行

   1. ```shell
      export LAN='zh_CN.UTF-8'
      export LC_ALL='zh_CN.UTF-8'
      ```

## 1.2 	获取本地仓库



## 1.3	 基础操作指令

### 1.3.1	查看修改状态（status）

### 1.3.2	 添加工作区到暂存区(add)

### 1.3.3	 提交暂存区到本地仓库

### 1.3.4	 查看提交日志（log）

### 1.3.5	 版本回退

### 1.3.6	添加文件至忽略列表



## 1.4 分支



## 二、提交的类型

- **约定式提交**

> 格式
>
> ​	<类型>[可选 范围]：<描述>
>
> ​	[可选正文]
>
> ​	[可选 脚注]

> - **fix**:修复了某个bug
> - **feat**：新增了某个功能
> - **build**：一些影响构建系统的更新
> - **chore**:一些不更改核心代码的更新
> - **ci**:变更了一些CI系统的配置
> - **docs**：对文档做出修改
> - **test**: 新增或者修改测试文件
> - **refactor**：重构了代码（但是没有新增或者修复和任何东西）

