/**
 * 单链表的实现
 */

package LinkList;

//定义单个链接点
class Link{
	public int iData;          		  				//节点保存的整型数据
	public double dData;       						//节点保存的双精度浮点型数据
	public Link next;          						//节点所指向的下一个节点
	
	public Link(int id, double dd)   				//构造函数
	{
		this.iData = id;
		this.dData = dd;
	}
	
	public void displayLink()						//打印节点
	{         				
		System.out.print("{"+iData+","+dData+"} ");
	}
}

//定义链表
class LinkList{
	private Link first;        						//定义节点的第一个节点
	
	public LinkList()								//构造函数
	{								
		this.first = null;							//节点不指向任何节点，表示空链表
	}
	
	public boolean isEmpty()						//判断链表是否为空
	{						
		return (this.first==null);		
	}
	
	public void insertFirst(int id, double dd)		//头部插入新节点
	{		
		Link newLink = new Link(id, dd);			//创建节点对象
		newLink.next = this.first;					//newLink.next指向原来first指向的位置
		this.first = newLink;						//first指向newLink
	}
	
	public Link deleteFirst()						//删除头节点
	{
		if(isEmpty())
		{
			System.out.println("LinkList is empty, there is no Link to delet!!");
			return null;
		}
		else
		{
			Link temp = this.first;					//暂存头结点
			this.first = this.first.next;			//first指向头结点的下一个节点
			return temp;
		}
	}
	
	public Link find(int key)						//查找节点,这里按照整型数据查找
	{
		Link current = this.first;
		while(current!=null)
		{
			if(current.iData==key)
			{
				return current;
			}
			else
				current = current.next;
		}
		return null;
	}
	
	public Link delete(int key)						//根据整形数据删除相应节点
	{
		Link current = this.first;
		Link previous = this.first;
		while(current!=null)
		{
			if(current.iData==key)
			{
				if (current==first)
					first = first.next;
				else
					previous.next = current.next;
				return current;
			}
			else
			{
				previous = current;
				current = current.next;
			}
		}
		return null;
	}
	
	public void dispalyList()
	{
		System.out.print("List (First-->Last): ");
		Link current = this.first;					//从头节点开始
		while (current != null)						//判断节点是否为空
		{
			current.displayLink();					//打印节点
			current = current.next;					//移动至下一节点
		}
		System.out.println("");
	}
}

//主程序
public class LinkListApp {
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();			//新建链表
		
		theList.insertFirst(22, 2.49);				//插入节点
		theList.insertFirst(44, 4.49);
		theList.insertFirst(66, 6.49);
		theList.insertFirst(88, 8.49);
		
		theList.dispalyList();						//打印链表
		
		Link fLink = theList.find(2);				//查找节点
		if (fLink!=null)
		{
			System.out.print("find the key ");
			fLink.displayLink();
			System.out.println("");
		}
		else
			System.out.println("key is not exist");
		
		Link dLink = theList.delete(88);
		if (dLink!=null)
		{
			System.out.print("delete the key ");
			dLink.displayLink();
			System.out.println("");
		}
		else
			System.out.println("delete failed, key is not exist!!");
		System.out.print("after delete: ");
		theList.dispalyList();
		
		while(!theList.isEmpty())					//从头部删除节点
		{
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println("");
		}
		theList.dispalyList();
	}
}
