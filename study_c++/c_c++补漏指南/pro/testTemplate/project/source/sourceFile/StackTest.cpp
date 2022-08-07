#include "../headFile/StackTest.h"
#include <string>
#include <iostream>

namespace testTamplate
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
