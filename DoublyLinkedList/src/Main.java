//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}
public class Main {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        traverse(head);
//        if (cur.next.next==null){
//            cur.next.prev=null;
//            cur.next=null;
//        }
//        Node tem = cur.next;
//        System.out.println(cur.data);
//        System.out.println(tem.data);
//        cur.next= tem.next;
//        tem.next.prev = cur;
//        return head;
    }
    public static void traverse(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();

    }
}