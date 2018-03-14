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
	
	public boolean isEmpty(){			//判断栈是否为空
		return top==-1;
	}
	
	public boolean isFull(){			//判断栈是否满了
		return top==maxSize-1;
	}
	public boolean push(int key){		//入栈
		if (isFull())
			return false;
		arr[++top] = key;				//每压入一个元素，top指针加1
		return true;
	}
	
	public int pop(){					//出栈
		return arr[top--];				//返回栈顶元素，top指针减1
	}
	
	public int peek() {					//查看栈顶元素
		
		return arr[top];
	}
}

//测试正确性
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
