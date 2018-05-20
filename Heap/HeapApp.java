/**
 * 最大堆的实现
 */
package Heap;

// 定义节点
class Node{
	private int idata;
	public Node(int data){
		idata = data;
	}
	public int getKey(){
		return idata;
	}
}

// 定义堆
class Heap{
	private Node[] heapArray;		// 存储节点的数组
	private int maxSize;			// 最大存储大小
	private int currSize;			// 当前大小
	public Heap(int size){
		maxSize = size;
		currSize = 0;
		heapArray = new Node[size];
	}
	// 判断是否为空
	public boolean isEmpty(){
		return (currSize == 0);
	}
	// 插入元素
	public boolean insert(int key){
		// 存储已满
		if (currSize == maxSize)
			return false;
		Node node = new Node(key);
		// 将新节点放到数组最后
		heapArray[currSize] = node;
		// 调整堆结构
		trickleUp(currSize++);
		return true;
	}
	// 向上比较
	private void trickleUp(int i) {
		// 父节点角标
		int parent = (i - 1) / 2;
		Node temp = heapArray[i];
		// 当前节点关键字大于父节点关键字
		while (i > 0 && temp.getKey() > heapArray[parent].getKey()){
			heapArray[i] = heapArray[parent];
			i = parent;
			parent = (i - 1) / 2; 
		}
		heapArray[i] = temp;
	}
	// 删除元素
	public Node remove(){
		Node root = heapArray[0];
		// 最后一个元素放到堆顶
		heapArray[0] = heapArray[--currSize];
		// 向下比较
		trickleDown(0);
		return root;
	}
	// 向下比较
	private void trickleDown(int i){
		int largeChild;
		Node top = heapArray[i];
		while (i < currSize/2){
			int leftChild = 2*i + 1;
			int rightChild = leftChild + 1;
			if (rightChild < currSize && 
					heapArray[rightChild].getKey() > heapArray[leftChild].getKey())
				largeChild = rightChild;
			else
				largeChild = leftChild;
			if (top.getKey() >= heapArray[largeChild].getKey())
				break;
			heapArray[i] = heapArray[largeChild];
			i = largeChild;
		}
		heapArray[i] = top;
	}
}

public class HeapApp {

	public static void main(String[] args) {
		Heap theHeap = new Heap(20);
		theHeap.insert(13);
		theHeap.insert(43);
		theHeap.insert(57);
		theHeap.insert(52);
		theHeap.insert(33);
		theHeap.insert(70);
		theHeap.insert(8);
		theHeap.insert(75);
		theHeap.insert(22);
		theHeap.insert(65);
		theHeap.insert(90);
		while (!theHeap.isEmpty()){
			System.out.print(theHeap.remove().getKey() + " ");
		}
	}

}
