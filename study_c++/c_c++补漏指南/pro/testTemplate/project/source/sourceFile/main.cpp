#include <iostream>
#include <thread>
#include <string>
#include "../headFile/StackTest.h"

namespace testTamplateTemp
{
    bool operator > (const std::string& dataOne,const std::string& dataTwo)
    {
        if(0>dataOne.compare(dataTwo))
        {
            return true;       
        }
        else
        {
            return false;
        }
    }

    template<typename T>
    bool IsLarger(const T& dataOne,const T& dataTwo)
    {
        bool result=dataOne>dataTwo;

        if(result)
        {
            std::cout<<"data one is larger than data two!"<<std::endl;
        }
        else
        {
            std::cout<<"data one is lower than or equal to data two!"<<std::endl;
        }
        return result;
    }
}


void test()
{
    for(int i=0;i<100;++i)
    {
        std::cout<<"test add data:"<<i<<std::endl;
    }
}

void temp()
{
    for(int i=0;i<10;i++)
    {
        std::cout<<"temp add data:"<<i<<std::endl;
    }
}

int main()
{
    std::string one("admin");
    std::string two("admin");
    bool result = testTamplateTemp::IsLarger(one,two);
   
   int num1=20;
   int num2=10;
   result=testTamplateTemp::IsLarger(num1,num2);
    return 0;
}