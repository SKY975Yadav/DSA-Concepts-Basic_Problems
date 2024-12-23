//Sum of doubly linked list in O(n/2)

public class Problems {
    public static void main(String[] args) {
        Node head = new Node(10);
//        head = null;
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        Node tail = temp2;
        tail = OperationUsingTail.insertAtEnd(tail,40);
        tail = OperationUsingTail.insertAtEnd(tail,45);
        tail = OperationUsingTail.insertAtEnd(tail,55);
        Main.traverse(head);
        System.out.println(sumOfLinkedList(head,tail));
    }
    public static int sumOfLinkedList(Node head,Node tail){
        if (head==null) return -1;
        int sum = 0;
        if (head==tail) return head.data;
        Node start = head;
        Node last = tail;
        while (start!=last){
            sum += start.data+ last.data;
            start = start.next;
            last = last.prev;
            if (start.next==last || start.next== last.prev){
                if (start.next==last.prev){
                    sum += start.data+last.data;
                }
                if (start.next==last)
                    sum += start.data;
                System.out.println(start.data);
                System.out.println(last.data);
                System.out.println("Dsf");
                sum += start.next.data;
                break;
            }
        }
        return sum;
    }
}
