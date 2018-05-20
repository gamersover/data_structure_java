/**
 * ���ѵ�ʵ��
 */
package Heap;

// ����ڵ�
class Node{
	private int idata;
	public Node(int data){
		idata = data;
	}
	public int getKey(){
		return idata;
	}
}

// �����
class Heap{
	private Node[] heapArray;		// �洢�ڵ������
	private int maxSize;			// ���洢��С
	private int currSize;			// ��ǰ��С
	public Heap(int size){
		maxSize = size;
		currSize = 0;
		heapArray = new Node[size];
	}
	// �ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return (currSize == 0);
	}
	// ����Ԫ��
	public boolean insert(int key){
		// �洢����
		if (currSize == maxSize)
			return false;
		Node node = new Node(key);
		// ���½ڵ�ŵ��������
		heapArray[currSize] = node;
		// �����ѽṹ
		trickleUp(currSize++);
		return true;
	}
	// ���ϱȽ�
	private void trickleUp(int i) {
		// ���ڵ�Ǳ�
		int parent = (i - 1) / 2;
		Node temp = heapArray[i];
		// ��ǰ�ڵ�ؼ��ִ��ڸ��ڵ�ؼ���
		while (i > 0 && temp.getKey() > heapArray[parent].getKey()){
			heapArray[i] = heapArray[parent];
			i = parent;
			parent = (i - 1) / 2; 
		}
		heapArray[i] = temp;
	}
	// ɾ��Ԫ��
	public Node remove(){
		Node root = heapArray[0];
		// ���һ��Ԫ�طŵ��Ѷ�
		heapArray[0] = heapArray[--currSize];
		// ���±Ƚ�
		trickleDown(0);
		return root;
	}
	// ���±Ƚ�
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
