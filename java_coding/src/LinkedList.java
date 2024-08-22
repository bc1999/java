

public class LinkedList {
    public LinkedList(int value){
        Node newNode = new Node(value); // new runs the constructor
        head = newNode;
        tail = newNode;
        length = 1;

    }

    ///////////////////////////////
    private Node head;
    private Node tail;
    private int length;
    class Node { // inner/nested class
        int value; // value is like a variable and int is the datatype
        Node next; // next is like a variable and Node is the datatype

        Node(int value){
            this.value = value;
        }

    }
    ///////////////////////////////

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: "+tail.value);
    }

    public void getLength(){
        System.out.println("Length: "+ length);
    }


    public void append(int value){ // push
        Node newNode = new Node(value);

        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){ // pop()

        /////
        // When there is no item in the LinkedList
       if(length ==0) return null; // or if head == null or tail == null
        /////
        // When there is more than 1 item (i.e. 2 items) in the LinkedList
        Node temp = head;
        Node pre = head;

        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;

        length--;
        /////
        // when there is 1 item in the LinkedList
        if(length==0){
            head = null;
            tail = null; // tail is no longer pre, however, head is still head because
            // this is the removal of the tail, so it does not affect the head
        }
        /////

        return temp;

    }


    public void prepend(int value) { // unshift
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() { // shift
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            // head = null; // head.next is already null, since only contain 1 item
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);

        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;

    }

    public boolean insert(int index, int value){
        if(index<0||index>length) return false;

        if(index==0){
            prepend(value);
            return true;
        }
        if(index==length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    public Node remove(int index){

        if(index <0|| index >= length) return null; // use index >= length,
        // instead of index > length, because we return a null instead of false

        if (index == 0) return removeFirst();

        if(index == length-1) return removeLast();

        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;
        for(int i =0;i<length;i++){
            after = temp.next;
            temp.next=before;
            before = temp;
            temp = after;
        }

    }


}






