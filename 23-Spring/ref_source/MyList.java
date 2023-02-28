import java.util.*;

class StudentRecord{
    public int studentID;
    public String name;
    public double gpa;
    public StudentRecord(int studentID, String name, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
    }
    public void printData() {
        System.out.println("student ID:" + studentID);
        System.out.println("name:" + name);
        System.out.println("gpa:" + gpa);
    }
}

class Node{
    StudentRecord data;
    Node next;
    public Node(StudentRecord data) {
        setData(data);
        setNext(null);
    }
    public void setData(StudentRecord data) {
        this.data = data;
    }
    public void setNext(Node next){
        this.next = next;
    }

    public void printNode() {
        data.printData();
    }
}

public class MyList{
    private Node head;

    public MyList() {
        setHead(new Node(null));
    }

    private void setHead(Node head) {
        this.head = head;
    }

    private Node getHead() {
        return head;
    }

    public void insert(Node node) {
        Node moveNode = head;
        while(moveNode.next != null) {
            moveNode = moveNode.next;
        }
        moveNode.next = node;
        node.next = null;
    }

    public void insert(Node node, int pos) {
        Node moveNode = head;
        for(int i = 0; i < pos; i++) {
            moveNode = moveNode.next;
        }
        node.next = moveNode.next;
        moveNode.next = node;
    }

    // write it yourself, pos 0 means delete the first node of list.
    public void delete(int pos) {
        // 
        
    }

    public void printList() {
        Node moveNode = head;

        while(moveNode.next != null) {
            moveNode = moveNode.next;
            moveNode.printNode();
        }

    }

    
    public static void main(String args[]) {
        MyList myList = new MyList();




        Node n1 = new Node(new StudentRecord(101221302, "Bob", 3.5));
        myList.insert(n1);

        Node n2 = new Node(new StudentRecord(101221303, "Mary", 3.7));
        myList.insert(n2);

        Node n3 = new Node(new StudentRecord(777, "Jack", 1.0));
        myList.insert(n3, 0);
        
        Node n4 = new Node(new StudentRecord(1788, "Tom", 10.0));
        myList.insert(n4, 2);

        myList.printList();

    }

}
