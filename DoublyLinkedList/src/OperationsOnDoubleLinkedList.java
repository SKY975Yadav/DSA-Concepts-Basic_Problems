public class OperationsOnDoubleLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
//        head = null;
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        head.next =temp1;
        temp1.prev = head;
        temp1.next =temp2;
        temp2.prev = temp1;
        head = insertAtBeg(head,5);
        head = insertAtEnd(head,60);
        Main.traverse(head);
//        head = deleteAtBeg(head);
//        head = deleteAtEnd(head);
//        head = insertAtK(head,2,2);
//        head = deleteAtK(head,0);
//        head = insertAtK(head,6,8);
//        head = reverseList(head);
        Main.traverse(head);
    }
    public static Node insertAtBeg(Node head,int x){
        Node temp = new Node(x);
        if (head == null) return temp;
        head.prev = temp;
        temp.next=head;
        return temp;
    }
    public static Node insertAtEnd(Node head,int x){
        Node temp = new Node(x);
        if (head == null) return temp;
        Node cur = head;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = temp;
        temp.prev = cur;
        return head;
    }
    private static Node deleteAtBeg(Node head){
        if (head==null || head.next==null) return null;
        Node cur = head.next;
        head.next=null;
        cur.prev = null;
        return cur;
    }
    private static Node deleteAtEnd(Node head){
        if (head == null || head.next==null) return null;
        Node cur = head;
        while (cur.next.next!=null){
            cur=cur.next;
        }
        cur.next.prev=null;
        cur.next=null;
        return head;
    }
    void addNode(Node head, int pos, int data)
    {
        // Your code here
        Node newNode = new Node(data);
        Node cur = head;
        for(int i=0;i<pos && cur!=null;i++){
            cur = cur.next;
        }
        if(cur==null){
            return;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        newNode.prev = cur;
    }
    private static Node insertAtK(Node head,int k,int x){
        if (k==0) return head;
        Node temp = new Node(x);
        if(k==1){
            temp.next=head;
            head.prev = temp;
            return temp;
        }
        Node cur = head;
        for (int i = 0; i <k-2 && cur.next!=null; i++) {//cur == null for 74 line
            cur = cur.next;
        }
        if (cur.next==null){//cur == null for 74 line
            return head;
        }

        temp.next=cur.next;
        cur.next=temp;
        //if you want to add in the next pos after all list com ex we have [1,2,3] if k=4 we can it yo [1,2,3,4] if you want to this just unlock below code and 65,68 line code
//        if (temp.next==null){
//            temp.prev = cur;
//            return head;
//        }
        temp.next.prev=temp;
        temp.prev = cur;
        return head;
    }
    public static Node sortedInsert(Node head, int x)
    {
        // add your code here
        Node newNode = new Node(x);
        if(head == null){
            return newNode;
        }
        if(newNode.data<head.data){
            newNode.next = head;
            head.prev = newNode;
        }
        if(head.next==null){
            if(head.data>x){
                newNode.next = head;
                head.prev = newNode;
                return newNode;
            }
            else{
                head.next=newNode;
                newNode.prev = head;
                return head;
            }
        }
        Node cur = head;
        while(cur.next!=null && cur.data<=x){
            cur = cur.next;
        }
        if(cur.next==null && cur.data<=x){

            cur.next=newNode;
            newNode.prev = cur;
            return head;

        }
        newNode.prev=cur.prev;
        newNode.next = cur;
        cur.prev = newNode;
        newNode.prev.next = newNode;
        return head;
    }
    private static Node deleteAtK(Node head,int k){
        if (k==0)return  head;
        if (head==null || (head.next==null && k==1)) return null;
        if (head.next==null) return head;
        if (k==1){
            Node temp = head.next;
            temp.prev = null;
            head.next=null;
            return temp;
        }
        Node cur = head;
        for (int i=0;i<k-2 && cur.next!=null;i++){
            cur = cur.next;
        }
        if (cur.next==null){
            return head;
        }
        if (cur.next.next==null){
            cur.next.prev=null;
            cur.next=null;
            return head;
        }
        Node tem = cur.next;
        cur.next= tem.next;
        tem.next.prev = cur;
        return head;
    }
}
