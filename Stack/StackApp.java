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
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public boolean isFull(){
		return top==maxSize-1;
	}
	public boolean push(int key){		//ѹ��Ԫ��
		if (isFull())
			return false;
		arr[++top] = key;
		return true;
	}
	
	public int pop(){
		return arr[top--];
	}
	
	public int peek() {
		
		return arr[top];
	}
}

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
