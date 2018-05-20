/**
 * �������ʵ��
 */

package LinkList;

//���嵥�����ӵ�
class Link{
	public int iData;          		  				//�ڵ㱣�����������
	public double dData;       						//�ڵ㱣���˫���ȸ���������
	public Link next;          						//�ڵ���ָ�����һ���ڵ�
	
	public Link(int id, double dd)   				//���캯��
	{
		this.iData = id;
		this.dData = dd;
	}
	
	public void displayLink()						//��ӡ�ڵ�
	{         				
		System.out.print("{"+iData+","+dData+"} ");
	}
}

//��������
class LinkList{
	private Link first;        						//����ڵ�ĵ�һ���ڵ�
	
	public LinkList()								//���캯��
	{								
		this.first = null;							//�ڵ㲻ָ���κνڵ㣬��ʾ������
	}
	
	public boolean isEmpty()						//�ж������Ƿ�Ϊ��
	{						
		return (this.first==null);		
	}
	
	public void insertFirst(int id, double dd)		//ͷ�������½ڵ�
	{		
		Link newLink = new Link(id, dd);			//�����ڵ����
		newLink.next = this.first;					//newLink.nextָ��ԭ��firstָ���λ��
		this.first = newLink;						//firstָ��newLink
	}
	
	public Link deleteFirst()						//ɾ��ͷ�ڵ�
	{
		if(isEmpty())
		{
			System.out.println("LinkList is empty, there is no Link to delet!!");
			return null;
		}
		else
		{
			Link temp = this.first;					//�ݴ�ͷ���
			this.first = this.first.next;			//firstָ��ͷ������һ���ڵ�
			return temp;
		}
	}
	
	public Link find(int key)						//���ҽڵ�,���ﰴ���������ݲ���
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
	
	public Link delete(int key)						//������������ɾ����Ӧ�ڵ�
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
		Link current = this.first;					//��ͷ�ڵ㿪ʼ
		while (current != null)						//�жϽڵ��Ƿ�Ϊ��
		{
			current.displayLink();					//��ӡ�ڵ�
			current = current.next;					//�ƶ�����һ�ڵ�
		}
		System.out.println("");
	}
}

//������
public class LinkListApp {
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();			//�½�����
		
		theList.insertFirst(22, 2.49);				//����ڵ�
		theList.insertFirst(44, 4.49);
		theList.insertFirst(66, 6.49);
		theList.insertFirst(88, 8.49);
		
		theList.dispalyList();						//��ӡ����
		
		Link fLink = theList.find(2);				//���ҽڵ�
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
		
		while(!theList.isEmpty())					//��ͷ��ɾ���ڵ�
		{
			Link aLink = theList.deleteFirst();
			System.out.print("Deleted ");
			aLink.displayLink();
			System.out.println("");
		}
		theList.dispalyList();
	}
}
