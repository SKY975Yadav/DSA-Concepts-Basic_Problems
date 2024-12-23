
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//Simple linked List
class Node{
    int data;
    public Node next;
    Node(int t){
        this.data= t;
        next = null;
    }
}
public class Main {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node temp1 = new Node(6);
        Node temp2 = new Node(8);
        head.next=temp1;
        temp1.next= temp2;
        System.out.println(temp1.next);
        System.out.println(temp2);
    }
}