
// Node Class
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class MergeTwoSortedLinkedList {
    Node head;
    // add Method
    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    // Printing the list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String args[]) {
        
        // The Two Lists
        MergeTwoSortedLinkedList llist1 = new MergeTwoSortedLinkedList();
        MergeTwoSortedLinkedList llist2 = new MergeTwoSortedLinkedList();

        llist1.add(new Node(5));
        llist1.add(new Node(10));
        llist1.add(new Node(15));

        llist2.add(new Node(2));
        llist2.add(new Node(3));
        llist2.add(new Node(20));

        llist1.head = new Gfg().mergeTwoSortedLists(llist1.head,
                llist2.head);
        llist1.printList();
    }
}

class Gfg {
    
    public Node sortedMerge(Node headA, Node headB) {

        Node dummyNode = new Node(0);
        // Wow.. The value of the dummy will change by reference .. Soft Copy
        Node tail = dummyNode; // Always Points to the last node
        
        while (true) {
            if (headA == null) {
                tail.next = headB;
                break;
            }
            if (headB == null) {
                tail.next = headA;
                break;
            }

            if (headA.data <= headB.data) {
                tail.next = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                headB = headB.next;
            }

            // Always Points to 
            tail = tail.next;
        }
        return dummyNode.next;
    }

    public Node mergeTwoSortedLists(Node A, Node B) {
        // Base Case
        if(A == null) return B;
        if(B == null) return A;

        // Recusrsion
        if(A.data < B.data) {
            A.next = mergeTwoSortedLists(A.next, B);
            return A;
        } else {
            B.next = mergeTwoSortedLists(A, B.next);
            return B;
        }
    }

}