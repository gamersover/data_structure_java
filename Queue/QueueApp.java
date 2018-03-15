package queue;
/**
 * ʵ�ֶ���
 */

class Queue{
	private int rear;				//��βָ��
	private int front;				//��ͷָ��
	private int maxSize;			//�������洢
	private int nItems;				//�����е�Ԫ�ظ���
	int[] arr;
	Queue(int maxSize){
		this.maxSize = maxSize;
		arr = new int[maxSize];
		rear = -1;
		front = 0;
		nItems = 0;
	}
									
	public boolean isFull(){		//�ж϶����Ƿ�����
		return nItems==maxSize;
	}
	
	public boolean isEmpty(){       //�ж϶����Ƿ�Ϊ��
		return nItems==0;
	}
	
	public void insert(int key){    //Ԫ�����
		if (rear == maxSize-1)
			rear = -1;
		arr[++rear] = key;
		nItems++;
	}
	
	public int remove(){            //Ԫ�س���
		int temp = arr[front++];
		if (front==maxSize)
			front = 0;
		nItems--;
		return temp;
	}
	
	public int frontPeek(){         //�鿴��ͷԪ��
		return arr[front];
	}
	
	public int size(){              //�鿴������ʵ��С
		return nItems;
	}
}

//��������ȷ��
public class QueueApp {
	public static void main(String[] args) {
		Queue theQueue = new Queue(10);
		theQueue.insert(10);
		theQueue.insert(8);
		theQueue.insert(6);
		theQueue.insert(4);
		theQueue.insert(2);
		
		System.out.println("�鿴��ͷԪ��: " + theQueue.frontPeek());
		
		System.out.print("��������Ԫ��: ");
		while (!theQueue.isEmpty()){
			int n = theQueue.remove();
			System.out.print(n+" ");
		}
		System.out.println();
	}
}
