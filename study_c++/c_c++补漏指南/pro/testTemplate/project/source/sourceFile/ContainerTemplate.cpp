#include "../headFile/ContainerTemplate.h"
namespace selfTemplate
{
    template<class T>
    void ContainerTemplate::PushItem(const T& itemData)
    {
        selfTemplate::Node* pNode= new Node;
        pNode->data=itemData;
        
        pNode->next=m_pFirst->pNext;
        m_pFirst->pNext = pNode;
    }

    bool ContainerTemplate::PopItem()
    {
        if(!m_pFirst->pNext)
        {
            reutrn false;
        }

        Node* pNode=m_First->next;
        m_pFirst->next=m=pNode->pNext;

        delete pNode;
        if(!pNode)
        {
            pNode=nullptr;
        }

    }
}