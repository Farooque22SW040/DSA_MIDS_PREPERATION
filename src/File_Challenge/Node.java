package File_Challenge;

import java.io.FileReader;
import java.io.IOException;

public class Node {
    char data;
    Node next;
    public Node(char data) {
        this.data = data;
    }
    public void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
    }
    public Node addNode (Node head , char data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return head;
        }
        Node temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    public Node joinTwoList(Node odd , Node even){
        Node temp1 = odd;
        Node temp2 = even;
        Node newNode = new Node(' ');
        Node temp = newNode;
        int i=1;
        while (temp1!=null&&temp2!=null){
            if(i%2==0){
                temp.next = new Node(temp2.data);
                temp2=temp2.next;
            }
            else{
                temp.next = new Node(temp1.data);
                temp1=temp1.next;
            }
            i++;
            temp=temp.next;
        }
        if(temp1==null){
            temp.next=temp2;
        }
        else{
            temp.next=temp1;
        }
        System.out.println("Number of Characters in Merged List : " + i);
        return newNode.next;
    }
    public void splitIntoList(String filename) throws IOException {
        Node evenNode = null;
        Node oddNode  = null;
        FileReader fileReader = new FileReader(filename);
        int charCode;
        int i=1;
        int evenSize=0;
        int oddSize=0;
        while((charCode=fileReader.read())!=-1){
            char data = (char) charCode;
            if(i%2==0){
                evenNode = addNode(evenNode,data) ;
                evenSize++;
            }
            else{
                oddNode = addNode(oddNode,data);
                oddSize++;
            }
            i++;
        }
        System.out.println();
        System.out.println("Printing Even Index  List  ");
        System.out.println();
        print(evenNode);
        System.out.println();
        System.out.println("Number of Even Characters : " + evenSize);
        System.out.println("Printing Odd Index  List  ");
        System.out.println();
        print(oddNode);
        System.out.println();
        System.out.println("Number of Odd Characters : " + oddSize);
        Node mergeNode = joinTwoList(oddNode,evenNode);
        System.out.println();
        System.out.println("Printing Join List of Even and Odd List ");
        System.out.println();
        print(mergeNode);
    }

    public static void main(String[] args) throws IOException {
        Node n1 = new Node(' ');
        n1.splitIntoList("C:\\Users\\Farooque\\IdeaProjects\\DSA_MIDS_PREPERATION\\src\\File_Challenge\\File");
    }



}