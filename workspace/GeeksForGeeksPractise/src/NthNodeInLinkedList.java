
public class NthNodeInLinkedList {
	
	public static void main(String[] args) {
		Node head = new Node(10);
		Node node = head;
		LinkedListUtility.insertNode(node, 12);
		LinkedListUtility.insertNode(node, 14);
		LinkedListUtility.insertNode(node, 16);
		LinkedListUtility.insertNode(node, 18);
		LinkedListUtility.printLinkedList(node);
	}
}
