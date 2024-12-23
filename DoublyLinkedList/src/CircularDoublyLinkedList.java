public class CircularDoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
//        head.next=head;
//        head.prev=head;
////        head = null;
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        head.prev = temp2;
        temp2.next=head;
//        traverse(head);
        System.out.println(isCircular(head));
//        head = insertAtBeg(head,5);
//        head = insertAtEnd(head,60);
//        traverse(head);
    }
    public static void traverse(Node head){
        if (head == null) return;
        Node cur = head;
        do {
            System.out.print(cur.data+" ");
            cur =cur.next;
        }while (cur!=head);
        System.out.println();
    }
    public static boolean compareCLL(Node head1, Node head2) {
        // Your code here
        if (head1 == null || head2 == null){
            return false;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        do{
            if(cur1.data != cur2.data){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }while(cur1 != head1 || cur2!= head1);
        return true;
    }
    public static boolean isCircular(Node head)
    {
        // your code here
        if(head == null || head.next==null) return false;
        if (head.next==head && head.prev==head){
            return true;
        }
        Node cur = head;
        Node prev = head;
        do{
            if(cur.next==null || prev.prev==null){
                return false;
            }
            cur = cur.next;
            prev = cur.prev;
        }while(cur.next!=head || prev.prev != head);
        return true;
    }
    private static Node insertAtBeg(Node head,int x){
        Node newNode = new Node(x);
        if (head==null){
            newNode.next=newNode;
            newNode.prev = newNode;
            return newNode;
        }
        Node tail = head.prev;
        newNode.next=head;
        head.prev=newNode;
        tail.next=newNode;
        newNode.prev=tail;
        return newNode;
    }
    private static Node insertAtEnd(Node head,int x){
        Node newNode = new Node(x);
        if (head==null){
            newNode.next=newNode;
            newNode.prev = newNode;
            return newNode;
        }
        Node tail = head.prev;
        head.prev = newNode;
        tail.next =newNode;
        newNode.next=head;
        newNode.prev=tail;
        return head;
    }
}
