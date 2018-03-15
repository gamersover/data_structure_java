package queue;
/**
 * 实现队列
 */

class Queue{
	private int rear;				//队尾指针
	private int front;				//队头指针
	private int maxSize;			//队列最大存储
	private int nItems;				//队列中的元素个数
	int[] arr;
	Queue(int maxSize){
		this.maxSize = maxSize;
		arr = new int[maxSize];
		rear = -1;
		front = 0;
		nItems = 0;
	}
									
	public boolean isFull(){		//判断队列是否满了
		return nItems==maxSize;
	}
	
	public boolean isEmpty(){       //判断队列是否为空
		return nItems==0;
	}
	
	public void insert(int key){    //元素入队
		if (rear == maxSize-1)
			rear = -1;
		arr[++rear] = key;
		nItems++;
	}
	
	public int remove(){            //元素出队
		int temp = arr[front++];
		if (front==maxSize)
			front = 0;
		nItems--;
		return temp;
	}
	
	public int frontPeek(){         //查看队头元素
		return arr[front];
	}
	
	public int size(){              //查看队列真实大小
		return nItems;
	}
}

//最后测试正确性
public class QueueApp {
	public static void main(String[] args) {
		Queue theQueue = new Queue(10);
		theQueue.insert(10);
		theQueue.insert(8);
		theQueue.insert(6);
		theQueue.insert(4);
		theQueue.insert(2);
		
		System.out.println("查看对头元素: " + theQueue.frontPeek());
		
		System.out.print("队列所有元素: ");
		while (!theQueue.isEmpty()){
			int n = theQueue.remove();
			System.out.print(n+" ");
		}
		System.out.println();
	}
}
