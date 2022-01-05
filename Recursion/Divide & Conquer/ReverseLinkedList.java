public class ReverseLinkedList {
    static Node head;
    static class Node {
        Object ele;
        Node next;
        Node(Object ele) {
            this.ele = ele;
            this.next = null;
        }
    }

    public void add(Object ele) {
        Node addEle = new Node(ele);

        if (head == null) head = addEle;
        else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = addEle;
        }
    } 

    public void reverseLinkedList(Node node) {
        if(node == null || node.next == null) {
            // Update the head Now
            head = node;
            return;
        }
        reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
    }

    public void printLinkedList() {
        System.out.println("PrintingThe Linked List:");
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.ele + "  ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public static void main (String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        for (int i = 1; i < 9; i++) {
            obj.add(i);
        }

        obj.printLinkedList();
        obj.reverseLinkedList(head);
        obj.printLinkedList();

    }
}