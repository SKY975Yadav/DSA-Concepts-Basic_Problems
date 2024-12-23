//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Node{
    int data;
    Node next;
    Node(int x){
        this.data =x;
        this.next = null;
    }
}
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        Node head = new Node(10);
//        Node temp1 = new Node(20);
//        Node temp2 = new Node(30);
//        Node temp3 = new Node(40);
//        Node temp4 = new Node(50);
//        head.next=temp1;
//        temp1.next=temp2;
//        temp2.next=temp3;
//        temp3.next=temp4;
//        temp4.next =head;
//        traverse(head);
//        int []a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//        System.out.println(sumOfArray(a,0,a.length-1,a.length/2-1,a.length/2));//a.length =5
        //19
    }

    //Special problem not related to linked list

    public static void traverse(Node head){
        if (head==null) return;
        Node cur = head;
        do {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }while (cur!=head);
        System.out.println();
    }
}