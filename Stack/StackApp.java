package stack;
/**
 * 栈的实现
 */
class Stack{
	
	private int maxSize;  				//栈的最大存储
	private int[] arr;					//内部数组
	private int top;					//栈顶指针
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
	public boolean push(int key){		//压入元素
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
