package Linked_List;

import java.util.Random;


public class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public void addNode(Node head , int d){
        Node newNode = new Node(d);
        if(head==null){
            head=newNode;
        }
        else{
            Node temp = head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public int size (Node head){
        Node temp = head;
        int size=0;
        while (temp!=null){
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static Node addAtHead(Node head , int d) { // must be static
        Node newNode = new Node(d);
        if (head == null) {
            return newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
            return head;
        }
    }
    public static Node addAtLast(Node head , int d){
        Node newNode  = new Node(d);
        if(head==null){
            head=newNode;
            return head;
        }
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next=newNode;
        return head;
    }

    public Node insertAtMiddle(Node head , int d , int idx){
        if(idx<=0 || idx >size(head)){
            System.out.println("Invalid");
            return null;
        }
        Node newNode = new Node(d);
        Node temp = head;
        int i=1;
        while (i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next=newNode;
        return head ;
    }
    public int sumOfList(Node head){
        Node temp = head;
        int sum = 0;
        while(temp!=null){
            sum+=temp.data;
            temp=temp.next;
        }
        return sum;
    }
    public int maxOfList(Node head){
        Node temp = head;
        int max = temp.data;
        while (temp!=null){
            if(max<temp.data){
                max=temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    public int minOfList(Node head){
        Node temp = head;
        int min = temp.data;
        while (temp!=null){
            if(min>temp.data){
                min=temp.data;
            }
            temp = temp.next;
        }
        return min;
    }
    public Node replaceAtIndex(Node head , int idx , int data){
        if(idx<=0 || idx>size(head)){
            System.out.println("List is Empty");
            return head;
        }
        Node temp = head;
        int i=1;
        while (i<idx){
            temp = temp.next;
            i++;

        }
        temp.data=data;
        return head;
    }

    public Node cloneList (Node head){
        Node newNode = new Node(-1);
        Node temp1 = newNode;
        Node temp = head;
        while (temp!=null){
            temp1.next = new Node(temp.data);
            temp = temp.next;
            temp1 = temp1.next;
        }
        System.out.print("Clone Created Successfully : "  );
        return newNode.next;
    }

    public  int [] linkToArray(Node head){
        int [] arr = new int[head.size(head)];
        Node temp = head;
        int i=0;
        while (temp!=null){
            arr[i]=temp.data;
            i++;
            temp=temp.next;
        }
        System.out.print("Array Created Successfully : ");
        return arr;
    }
    public Node arrayToLink(int [] arr){
        Node newNode = new Node(-1);
        Node temp1 = newNode;
        for(int i=0;i<arr.length;i++){
            temp1.next = new Node(arr[i]);
            temp1 = temp1.next;
        }
        System.out.print("Linked List Created Successfully : ");
        return newNode.next;
    }
    public boolean compareTwoList(Node l1 , Node l2){
        if(l1.size(l1)!=l2.size(l2)){
            return false;
        }
        else{
            Node temp1 = l1;
            Node temp2 = l2;
            while (temp2!=null){
                if(temp1.data!=temp2.data){
                    return false;
                }
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
            return true;
        }
    }
    public int searchByIndex(Node head , int idx ) {
        if (idx <= 0 || idx > size(head)) {
            return -999;
        } else {
            Node temp = head;
            int i = 1;
            while (i < idx) {
                temp = temp.next;
                i++;
            }
            System.out.print("Element at index  " + idx + " : ");
            return temp.data;
        }
    }
    public Node removeHead(Node head){
        if(head==null){
            System.out.println("Head is Null ");
            return head;
        }
        else{
            if(head.next==null){
                System.out.println("List has only one element which got removed");
                head=head.next;
            }
            head=head.next;
        }
        return head;
    }

    public Node removeLast(Node head){
        if(head==null){
            System.out.println("Head is Null ");
            return head;
        }
        Node temp = head;
        while (temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
    public Node removeAtIndex(Node head , int idx){
        if(head==null){
            System.out.println("Head is Null ");
            return head;
        }
        else{
            int i=1;
            Node temp = head;
            while (i<idx-1){
                temp=temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        return head;

    }

    public int searchByValue(Node head , int value){
        if(head==null){
            System.out.println("List is Null ");
            return -999;
        }
        Node temp = head;
        int idx =  0;
        while (temp!=null){
            idx++;
            if(temp.data==value){
                System.out.print(value + " found at Index : "  );
                return idx;
            }
            temp = temp.next;
        }
        return -999;
    }
    public Node subList(Node head , int start , int end){
        if(head==null||start<=0 || start>size(head) || end<=0 || end>size(head)){
            System.out.println("Invalid");
            return null;
        }
        Node newNode = new Node(-1);
        Node temp1 = newNode;
        Node temp = head;
        int i=1;
        while (i<=start-1){
            temp=temp.next;
            i++;
        }
        while (i<=end){
            temp1.next = new Node(temp.data);
            temp=temp.next;
            temp1=temp1.next;
            i++;
        }
        return newNode.next;
    }

    public void splitList(Node head) {

        if (head == null) {
            System.out.println("List is Null ");
        }
        Node temp = head;
        Node evenList = new Node(-2);
        Node evenTemp = evenList;
        Node oddList = new Node(-1);
        Node oddTemp = oddList;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                evenTemp.next = new Node(temp.data);
                evenTemp = evenTemp.next;
            } else {
                oddTemp.next = new Node(temp.data);
                oddTemp = oddTemp.next;
            }
            temp = temp.next;
        }
        System.out.println("Linked List Splitted Successfully ");
        evenList.print(evenList.next);
        oddList.print(oddList.next);
        System.out.println("Sum Of Even List : "+ sumOfList(evenList.next));
        System.out.println("Sum Of Odd List : " + sumOfList(oddList.next));
    }
    public  Node generateRandom(Node head) {
        Node newNode = new Node(-1);
        Node current = newNode;
        Node temp = head;

        Random random = new Random();

        while (temp != null) {
            int randomNumber = random.nextInt(100);
            current.next = new Node(randomNumber);
            current = current.next;
            temp = temp.next;
        }
        return newNode.next;
    }
    public int average(Node head){
        int size = size(head);
        int sum  = sumOfList(head);
        return sum/size;

    }
    public Node insertAtIncreasingOrder(Node head , int target){
        Node newNode = new Node(target);
        if (head == null || head.data >= target) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        while (temp.next!=null&&temp.next.data<target){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
    public Node deleteIncreasingOrder(Node head, int target) {
        if (head == null) {
            System.out.println("Head is null");
            return head;
        }
        if (head.data == target) {

            System.out.println("Target found in the head node, which is being deleted");
            return head.next;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println(("Target not found in the list"));
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public Node deleteMiddle(Node head){ // if odd deleting middle if even deleting second middle
        int size = size(head)/2;
        Node temp =head;
        int i=1;
        while (i<size){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;

    }

    public Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current!=null){
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return head;

    }
    public String toString(Node head){
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp!=null){
            stringBuilder.append(temp.data);
            temp=temp.next;
        }
        return stringBuilder.toString();
    }
    public Node deleteSecondLast(Node head){
        if(head==null||head.next==null){
            System.out.println("Head is null now");
            return null;
        }
        if(head.next.next==null){
            return head.next;
        }
        Node temp = head;
        while (temp.next.next.next!=null){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
    public Node insertAtSecondLast(Node head , int target){
        Node newNode = new Node(target);
        if(head==null){
            head=newNode;
            return head;
        }

        if(head.next==null){
            head.next=newNode;
            return head;
        }
        Node temp = head;
        while (temp.next.next!=null){
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }



    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.addNode(n1,20);
        n1.addNode(n1,30);
        n1.addNode(n1,40);
        n1.addNode(n1,50);
        n1.print(n1);
        n1.insertAtSecondLast(n1,44);
        n1.print(n1);
       /*n1 = n1.deleteSecondLast(n1);
        n1.print(n1);*/
        /*n1.print(n1);
        System.out.println(n1.toString(n1));*/
        /*n1= n1.reverseList(n1);
        n1.print(n1);*/
        /*n1.deleteMiddle(n1);
        n1.print(n1);*/
        /*n1=n1.deleteIncreasingOrder(n1,10);
        n1.print(n1);*/

        /*n1=n1.insertAtIncreasingOrder(n1,1);
        n1.print(n1);
        System.out.println("Avg : " + n1.average(n1));
        n1=n1.generateRandom(n1);
        n1.print(n1);*/
       /* n1 = n1.addAtHead(n1,0);
        n1.print(n1);
        System.out.println("Size of List :  " + n1.size(n1));
        Node n2  = null;
        Node temp = addAtHead(n2,-10);
        temp = addAtHead(temp,-20);
        temp.print(temp);*/
        /*n1 = n1.addAtLast(n1,-60);
        n1.print(n1);*/
        /*n1=n1.insertAtMiddle(n1,15,5);
        n1.print(n1);*/
        // System.out.println("Sum of List : " + n1.sumOfList(n1));
        //  System.out.println("Max of a Linked List : " + n1.maxOfList(n1));
        //  System.out.println("Min of a Linked List : " + n1.minOfList(n1));
        /*n1 = n1.replaceAtIndex(n1,5,16);
        n1.print(n1);*/
        /*Node n2 = n1.cloneList(n1);
        n2.print(n2);*/
        /*int [] arr = n1.linkToArray(n1);
        System.out.println(Arrays.toString(arr));*/
       /*int [] arr = {1,2,3,4,5,6,7,8,9,10};
       Node n2  = n1.arrayToLink(arr);
        n2.print(n2);
        boolean status = n1.compareTwoList(n1,n2);
        System.out.println("Is Both List are Equal : " + status);*/
        // System.out.println(n1.searchByIndex(n1,5));
       /*n1 = n1.removeHead(n1);
       n1 = n1.removeHead(n1);
       n1.print(n1);*/
        /*n1.removeLast(n1);
        n1.removeLast(n1);
        n1.print(n1);*/
        /*n1 = n1.removeAtIndex(n1,5);
        n1.print(n1);
        n1 = n1.removeAtIndex(n1,3);
        n1.print(n1);*/
        // System.out.println(n1.searchByValue(n1,5));
       /*Node sub = n1.subList(n1,2,4);
       sub.print(sub);
      */
        /*n1.addNode(n1,51);
        n1.addNode(n1,67);
        n1.addNode(n1,98);
        n1.addNode(n1,99);
        n1.addNode(n1,-1);
        n1.splitList(n1);*/


    }




}// end of node class




