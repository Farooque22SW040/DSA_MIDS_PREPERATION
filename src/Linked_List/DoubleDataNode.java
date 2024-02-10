package Linked_List;
import java.util.*;

public class DoubleDataNode {



    public static class Node {
        int data1;
        String data2;
        Node next;

        public Node(int data1, String data2) {
            this.data1 = data1;
            this.data2 = data2;
        }

        public Node(int data1, String data2, Node next) {
            this.data1 = data1;
            this.data2 = data2;
            this.next = next;
        }

        public void addNode(Node head, int d1, String d2) {
            Node newNode = new Node(d1, d2);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public int size(Node head) {
            Node temp = head;
            int size = 0;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }

        public void print(Node head) {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data1 + " "  + temp.data2 + "  ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static Node addAtHead(Node head, int d1, String d2) { // must be static
            Node newNode = new Node(d1, d2);
            if (head == null) {
                return newNode;
            } else {
                newNode.next = head;
                head = newNode;
                return head;
            }
        }

        public static Node addAtLast(Node head, int d1, String d2) {
            Node newNode = new Node(d1, d2);
            if (head == null) {
                head = newNode;
                return head;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return head;
        }

        public Node insertAtMiddle(Node head, int d1, String d2, int idx) {
            if (idx <= 0 || idx > size(head)) {
                System.out.println("Invalid");
                return null;
            }
            Node newNode = new Node(d1, d2);
            Node temp = head;
            int i = 1;
            while (i < idx - 1) {
                temp = temp.next;
                i++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            return head;
        }

        public int sumOfList(Node head) {
            Node temp = head;
            int sum = 0;
            while (temp != null) {
                sum += temp.data1;
                temp = temp.next;
            }
            return sum;
        }

        public int maxOfList(Node head) {
            Node temp = head;
            int max = temp.data1;
            while (temp != null) {
                if (max < temp.data1) {
                    max = temp.data1;
                }
                temp = temp.next;
            }
            return max;
        }

        public int minOfList(Node head) {
            Node temp = head;
            int min = temp.data1;
            while (temp != null) {
                if (min > temp.data1) {
                    min = temp.data1;
                }
                temp = temp.next;
            }
            return min;
        }

        public Node replaceAtIndex(Node head, int idx, int data1, String data2) {
            if (idx <= 0 || idx > size(head)) {
                System.out.println("List is Empty");
                return head;
            }
            Node temp = head;
            int i = 1;
            while (i < idx) {
                temp = temp.next;
                i++;

            }
            temp.data1 = data1;
            temp.data2 = data2;
            return head;
        }

        public Node cloneList(Node head) {
            Node newNode = new Node(-1, " ");
            Node temp1 = newNode;
            Node temp = head;
            while (temp != null) {
                temp1.next = new Node(temp.data1, temp.data2);
                temp = temp.next;
                temp1 = temp1.next;
            }
            System.out.print("Clone Created Successfully : ");
            return newNode.next;
        }


        public boolean compareTwoList(Node l1, Node l2) {
            if (l1.size(l1) != l2.size(l2)) {
                return false;
            } else {
                Node temp1 = l1;
                Node temp2 = l2;
                while (temp2 != null) {
                    if (temp1.data1 != temp2.data1 && !Objects.equals(temp1.data2, temp2.data2)) {
                        return false;
                    }
                    temp2 = temp2.next;
                    temp1 = temp1.next;
                }
                return true;
            }
        }

        public void searchByIndex(Node head, int idx) {
            if (idx <= 0 || idx > size(head)) {
                return;
            } else {
                Node temp = head;
                int i = 1;
                while (i < idx) {
                    temp = temp.next;
                    i++;
                }
                System.out.print("Element at index  " + idx + " : ");
                System.out.println(temp.data1 + " " + temp.data2);
            }
        }

        public Node removeHead(Node head) {
            if (head == null) {
                System.out.println("Head is Null ");
                return head;
            } else {
                if (head.next == null) {
                    System.out.println("List has only one element which got removed");
                    head = head.next;
                }
                head = head.next;
            }
            return head;
        }

        public Node removeLast(Node head) {
            if (head == null) {
                System.out.println("Head is Null ");
                return head;
            }
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            return head;
        }

        public Node removeAtIndex(Node head, int idx) {
            if (head == null) {
                System.out.println("Head is Null ");
                return head;
            } else {
                int i = 1;
                Node temp = head;
                while (i < idx - 1) {
                    temp = temp.next;
                    i++;
                }
                temp.next = temp.next.next;
            }
            return head;

        }

        public int searchByValue(Node head, int value1, String value2) {
            if (head == null) {
                System.out.println("List is Null ");
                return -999;
            }
            Node temp = head;
            int idx = 0;
            while (temp != null) {
                idx++;
                if (temp.data1 == value1 && temp.data2.equals(value2)) {
                    System.out.print(value1 + " , " + value2 + " found at Index : ");
                    return idx;
                }
                temp = temp.next;
            }
            return -999;
        }

        public Node subList(Node head, int start, int end) {
            if (head == null || start <= 0 || start > size(head) || end <= 0 || end > size(head)) {
                System.out.println("Invalid");
                return null;
            }
            Node newNode = new Node(-1, " ");
            Node temp1 = newNode;
            Node temp = head;
            int i = 1;
            while (i <= start - 1) {
                temp = temp.next;
                i++;
            }
            while (i <= end) {
                temp1.next = new Node(temp.data1, temp.data2);
                temp = temp.next;
                temp1 = temp1.next;
                i++;
            }
            return newNode.next;
        }

        public void splitList(Node head) {

            if (head == null) {
                System.out.println("List is Null ");
            }
            Node temp = head;
            Node evenList = new Node(-2, " ");
            Node evenTemp = evenList;
            Node oddList = new Node(-1, " ");
            Node oddTemp = oddList;

            while (temp != null) {
                if (temp.data1 % 2 == 0) {
                    evenTemp.next = new Node(temp.data1, temp.data2);
                    evenTemp = evenTemp.next;
                } else {
                    oddTemp.next = new Node(temp.data1, temp.data2);
                    oddTemp = oddTemp.next;
                }
                temp = temp.next;
            }
            System.out.println("Linked List Splitted Successfully ");
            evenList.print(evenList.next);
            oddList.print(oddList.next);
            System.out.println("Sum Of Even List : " + sumOfList(evenList.next));
            System.out.println("Sum Of Odd List : " + sumOfList(oddList.next));
        }


        public Node reverseList(Node head) {
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
            return head;

        }

        public String toString(Node head) {
            StringBuilder stringBuilder = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                stringBuilder.append(temp.data1 + " " + temp.data2);
                temp = temp.next;
            }
            return stringBuilder.toString();
        }

        public Node deleteSecondLast(Node head) {
            if (head == null || head.next == null) {
                System.out.println("Head is null now");
                return null;
            }
            if (head.next.next == null) {
                return head.next;
            }
            Node temp = head;
            while (temp.next.next.next != null) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }


    }

        public static void main(String[] args) {
            Node n1 = new Node(10, "A");
            n1.addNode(n1, 20, "B");
            n1.addNode(n1, 30, "C");
            n1.addNode(n1, 40, "D");
            n1.addNode(n1, 50, "E");
            n1.print(n1);

            n1 = Node.addAtLast(n1, 60, "F");
            n1.print(n1);

            n1 = n1.insertAtMiddle(n1, 55, "G", 6);
            n1.print(n1);

            System.out.println("Size of List: " + n1.size(n1));

            System.out.println("Sum of List: " + n1.sumOfList(n1));
            System.out.println("Max of a Linked List: " + n1.maxOfList(n1));
            System.out.println("Min of a Linked List: " + n1.minOfList(n1));

            n1 = n1.replaceAtIndex(n1, 3, 33, "CC");
            n1.print(n1);

            Node n2Clone = n1.cloneList(n1);
            n2Clone.print(n2Clone);

            System.out.println("Are Both Lists Equal: " + n1.compareTwoList(n1, n2Clone));

            System.out.println("Element at index 5: ");
            n1.searchByIndex(n1, 5);

            n1 = n1.removeHead(n1);
            n1.print(n1);

            n1 = n1.removeLast(n1);
            n1.print(n1);

            n1 = n1.removeAtIndex(n1, 4);
            n1.print(n1);

            System.out.println(n1.searchByValue(n1, 30, "C"));

            Node sub = n1.subList(n1, 2, 4);
            sub.print(sub);

            n1.addNode(n1, 51, "Z");
            n1.addNode(n1, 67, "Y");
            n1.addNode(n1, 98, "X");
            n1.addNode(n1, 99, "W");
            n1.print(n1);

            n1.splitList(n1);

            n1 = n1.reverseList(n1);
            n1.print(n1);

            System.out.println(n1.toString(n1));

            n1 = n1.deleteSecondLast(n1);
            n1.print(n1);
        }
    }






