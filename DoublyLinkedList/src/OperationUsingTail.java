import javax.swing.*;

public class OperationUsingTail {
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
//        Main.traverse(head);
        tail = insertAtEnd(tail,40);
        tail = insertAtEnd(tail,45);
//        tail = insertAtEnd(tail,89);
        Main.traverse(head);
        search(head,tail,30);
//        reverseTraverse(tail);
//        tail = deleteAtEnd(tail);
//        Main.traverse(head);
//        System.out.println(head.data);
//        System.out.println(tail.data);
    }
    //At O(1) time
    public static Node insertAtEnd(Node tail,int x){
        Node temp = new Node(x);
        tail.next=temp;
        temp.prev = tail;
        return temp;
    }
    //The best solution for delete at end this is the best and easiest method to delete at end
    private static Node deleteAtEnd(Node tail){
        if (tail == null || tail.prev==null) return null;
        Node cur = tail.prev;
        tail.prev=null;
        cur.next=null;
        return cur;
    }
    public static void reverseTraverse(Node tail){
        Node cur = tail;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.prev;
        }
        System.out.println();
    }
    private static void search(Node head,Node tail,int x){
        if (head==null) return ;
        Node start = head;
        Node last= tail;
        int pos = 1;
        while (start!=last) {
            if (start.data == x || last.data == x) {
                if (start.data == x)
                    System.out.println(pos + " Position From the start");
                else System.out.println(pos + " Position From end");
                return;
            }
            start = start.next;
            last = last.prev;
            pos++;
            if (start.next==last.prev){
                if (start.next.data==x) {
                    pos++;
                    System.out.println(pos + " Position, Element found at the middle");
                    return;
                }
            }
        }
        System.out.println("Element not found");
    }
}
