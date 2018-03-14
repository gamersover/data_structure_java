package stack;
/**
 * ջ��ʵ��
 */
class Stack{
	
	private int maxSize;  				//ջ�����洢
	private int[] arr;					//�ڲ�����
	private int top;					//ջ��ָ��
	public Stack(int maxSize){
		this.maxSize = maxSize;
		arr = new int[maxSize];
		top = -1;
	}
	
	public boolean isEmpty(){			//�ж�ջ�Ƿ�Ϊ��
		return top==-1;
	}
	
	public boolean isFull(){			//�ж�ջ�Ƿ�����
		return top==maxSize-1;
	}
	public boolean push(int key){		//��ջ
		if (isFull())
			return false;
		arr[++top] = key;				//ÿѹ��һ��Ԫ�أ�topָ���1
		return true;
	}
	
	public int pop(){					//��ջ
		return arr[top--];				//����ջ��Ԫ�أ�topָ���1
	}
	
	public int peek() {					//�鿴ջ��Ԫ��
		
		return arr[top];
	}
}

//������ȷ��
public class StackApp {
	public static void main(String[] args) {
		Stack theStack = new Stack(10);
		theStack.push(2);
		theStack.push(4);
		theStack.push(6);
		theStack.push(8);
		theStack.push(10);
		System.out.println("current element: "+theStack.peek());
		System.out.print("all element: ");
		while (!theStack.isEmpty()){
			int value = theStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println();
	}
	
}
