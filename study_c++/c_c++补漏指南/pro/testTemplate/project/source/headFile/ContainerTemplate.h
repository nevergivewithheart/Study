#include <iostream>
#include <vector>

namespace selfTemplate
{

    template<class T>
    struct Node
    {
        struct Node* pNext;
        T data;
    };

    class ContainerTemplate
    {
    private:
        Node* m_pFirst;
    public:
        ContainerTemplate()
        {
            m_pFirst=new Node;
            m_pFirst->pNext = nullptr;
        };

        ~ContainerTemplate()
        {
            if(m_pFirst)
            {
                delete m_pFirst;
                m_pFirst=nullptr;
            }
        };

        void PushItem(const T& item);
        bool PopItem();

        bool IsEmpty();

        T TopItem();
    };  
} // namespace selfTemplate

#include "../sourceFile/ContainerTemplate.cpp"
