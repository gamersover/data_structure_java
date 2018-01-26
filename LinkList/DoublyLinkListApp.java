/**
 *双向链表的实现
 */
package java_learn;

class Link
{
	public long dData;         //节点存储的数据
	public Link next;          //指向下一节点的指针
	public Link previous;      //指向前一节点的指针
	
	public Link(long d)
	{
		this.dData = d;
	}
	
	public void displayLink()
	{
		System.out.print(dData+" ");
	}
}

class DoublyLinkList
{
	private Link first;
	
	public DoublyLinkList()
	{ this.first = null; }
	
	public boolean isEmpty()
	{ return (this.first==null); }
	
	public void insertFirst(long dd)
	{
		Link newLink = new Link(dd);                //新建节点
		if (!isEmpty())
			this.first.previous = newLink;          //第一步
			newLink.next = this.first;              //第二步
		this.first = newLink;	                    //第三步
	}

	public Link deleteFirst()
	{
		Link temp = this.first;               //返回删除的节点
		this.first.next.previous = null;      //第一步
		this.first = this.first.next;         //第二步
		return temp;
	}

	public boolean insertAfter(long key, long dd)
	{
		//遍历链表查找节点key
		Link current = first;
		while(current.dData!=key)
		{
			current = current.next;
			if(current==null)
				return false;                  //没找到返回false
		}
		//在current后插入新节点
		Link newLink = new Link(dd);
		
		if(current.next!=null)
			current.next.previous = newLink;   //第一步
		newLink.next = current.next;           //第二步
		newLink.previous = current;            //第三步
		current.next = newLink;                //第四步
		return true;
	}

	public Link deleteKey(long key)
	{
		//遍历链表查找节点
		Link current = this.first;
		while(current.dData!=key)
		{
			current = current.next;
			if(current==null)
				return null;
		}
		//如果是头节点，则按照删除头节点的方式删除节点
		if(current==this.first)
			this.first = this.first.next;
		//否则
		else
		{
			current.previous.next = current.next;          //第一步
			if(current.next!=null)
				current.next.previous = current.previous;  //第二步
		}
		return current;
	}

	public void displayForward()
	{
		Link current = this.first;
		System.out.print("List (first-->last): ");
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
}

public class DoublyLinkListApp {
	public static void main(String[] args)
	{
		DoublyLinkList theList = new DoublyLinkList();
		
		theList.insertFirst(11);
		theList.insertFirst(33);
		theList.insertFirst(55);
		
		theList.displayForward();
		
		theList.insertAfter(11, 22);
		theList.insertAfter(33, 44);
		
		theList.displayForward();
		
		theList.deleteFirst();
		theList.deleteKey(22);
		
		theList.displayForward();
	}
}
