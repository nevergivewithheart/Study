# c++模板
## 一、template模板的分类与实现方式
### 1 分类
> - 函数模板
> -  类模板
### 2 实现方式
> 标准c++为编译模板代码定义了两种模式：
> - “包含”模型
> - “分别编译模型”

## 二、实现方式
### 1、声明和实现都放置到头文件中
```c++
//类模板的定义
template <class T>
class Base
{
    public:
        Base(){};
        ~Base(){};
        T AddBase(T x,T y);
}

template <class T>
T Base<T>::AddBase(T x,T y)
{
    return x+y;
}

//调用
#include "template_compile.h"

int main()
{
    Base<int> obj;
    std::cout<<obj.AddBase(2,3)<<std::endl;
}
```
### 2、使用包含模型
  > 在定义模板类的头文件中的末行中添加语句:#include "template_base.cpp"
- 在类模板头文件template_base.h中：
```c++
//类模板的定义
template <class T>
class Base
{
    public:
        Base(){};
        ~Base(){};
        T AddBase(T x,T y);
}

#include "template_base.cpp"
```
- 在cpp文件中实现,调用方式正常
```c++
template <class T>
T Base<T>::AddBase(T x,T y)
{
    return x+y;
}
```
### 3、修改包含的文件（调用文件数量）
> 模板实现的cpp文件正常包含.h文件

- 头文件
  ```c++
    template <class T>
    class Base
    {
     public:
         Base(){};
         ~Base(){};
         T AddBase(T x,T y);
    }
  ```
- cpp文件
  ```c++
    #include "template_base.h"
    template <class T>
    T Base<T>::AddBase(T x,T y)
    {
        return x+y;
    }
  ```
- 调用方式
  ```c++
    //需要在调用文件中包含cpp文件
    #include "template_base.cpp"
  ```
  