
public class LinkedListUtility {
	public static Node insertNode(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		while (node.getNext() != null) {
			node = node.getNext();
		}
		node.setNext(new Node(data));
		Node temp = node;
		return temp;
	}
	
	public static void printLinkedList(Node node) {
		if (node == null) return;
		while (node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
	}
}
