// Class:             Data Structures Section 03
// Term:              Spring: 2022
// Name:
// Program Number:    Assignment Number 2
// IDE:               Eclipse
// DATE:              02 05,2022
// JRE:				  15.0.1

public class MyLinkedList <T> {
    Node head;
    Node tail;
    int size;

    public class Node{
        T data;
        Node link;
        Node(){
        }
        Node(T element){
            data = element;
            link = null;
        }
    }

    MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public T getFirst() throws RuntimeException{
        /*
         * Input: 		None
         * Process:		if head is null:
         * 					throw RuneTimeExecption
         *
         *  			OTHERWISE: return head
         * Output: 		Possible T
         */
        if (head== null) {
            throw new RuntimeException("There are no nodes in the list");
        }
        return head.data;
        // return the first element
        // if you don't have any element, throw RuntimeException with a message
        // Write code here
    }
    public T getLast() throws RuntimeException{
        //done
        if (tail == null) {
            /*
             * Input: None
             * P: 	check to see if the tail node exists
             * 			if it doesn't throw an error
             * 		return the tail
             *
             * Output: T [from class]
             */
            throw new RuntimeException("There are no nodes in the list");
        }
        return tail.data;
    }
    public void addLast(T newElement){
        /*
         * Input: 	None
         * Process:
         * 			Check to see if head or tail exists
         * 				If it doesn't then make the head using prebuilt methods
         * 				return
         *
         * 			If head exists then there should be a tail
         * 			make a new tail.link
         * 			re-assign tail pointer
         *
         * Output: 	None
         */
        if(head == null) {
            addFirst(newElement);
            tail = head;
            return ;
        }
        tail.link = new Node(newElement);
        tail = tail.link;
        // add a new Node to be the last element.
        // Write code here
    }
    public void removeLast() throws RuntimeException{
        /*
         * Input:	None
         * Process:	check to see if head then tail are null
         * 			if null:
         * 				throw a new runtime exception
         *
         * 			if the tail and head are the same:
         * 				unset both because there is only one node in the list
         *
         * 			[if we are here then there must be more than 1 in the list]
         * 			[Now we have to traverse to the end of the list carrying a pointer to the current and previous node]
         *
         * 			Make Node Iterator
         * 			while NodeIterator.hasNext()
         *
         * 				currentNode = NodeIterator.next
         * 				ListIterator.next() // delicious consumption of the node iterator
         * 				if currentNode.link == tail:
         * 					remove link
         * 					reassign tail
         * 					reduce size
         * 					return
         *
         * Output: None
         *
         */
        Node currentNode;

        if (size == 0) {
            throw new RuntimeException("There are no nodes in the list");
        }
        else if (size == 1) {
            tail = null;
            head = null;
            size--;
        }


        currentNode = null;


        Iterator NodeIterator = new Iterator();
        while(NodeIterator.hasNext()) {

            currentNode = NodeIterator.next;
            NodeIterator.next();
            if(currentNode.link == tail) {
                currentNode.link = null;
                tail = currentNode;
                size--;
                return;
            }
        }



        // Case 1: if the list is empty --> throw any Exception with a message
        // Case 2: if you have only one elements
        // Case 3: in general case
        // Caution: you must care about the [tail] after removal
        // Write code here

    }

    public int indexOf(T targetElement){

        /*
         * Input:		A Target Element of Type T <inherited fromClass>
         * Process:		CREATE Counter int
         * 				CREATE Iterator
         * 				WHILE  Iterator.hasNext:
         * 					if Iterator.next.data == Targetelement:
         * 						return Counter
         * 					Iterator.next() // consumer iterator
         * 				Counter++
         *
         *
         * Output:		<specified integer>
         */
        int currentNodeCount = 0;
        if (head == null) {
            System.out.println("There are no nodes in the list");
            return -1;
        }
        Iterator NodeIterator = new Iterator();
        while(NodeIterator.hasNext()) {
            if( NodeIterator.next.data == targetElement) {return currentNodeCount;}
            NodeIterator.next();
            currentNodeCount++;
        }

        return -1;
        // search the targetElement in the list, return the index of given targetElement if it exists.
        // if the list doesn't have targetElement, return -1
        // Caution: index starts with 0  (the first element's index is 0)
        // Caution: to return index, you must check the index of node while you searching
        // Write code here
    }
    public Iterator iterator(){
        return new Iterator();
    }

    // Complete the Iterator class
    class Iterator {
        Node next; // to point [next node] object

        Iterator(){
            // next must be the first node of the list
            next = head;
        }

        public T next(){
            // return the data_field of [next node]
            T data_field = next.data;
            next = next.link;
            return data_field;
        }
        public boolean hasNext(){
            // return true when the [next node] exists
            // return false when we don't have the [next node]
            if (next != null) {
                return true;
            }
            return false;
        }

    }

    public void removeFirst() throws RuntimeException {
        if(head == null) {
            throw new RuntimeException("in removeFirst(): no elements in the list");
        }
        else if(head == tail) { // if(size==1)
            head = tail = null;
            size --;
        }
        else {
            head = head.link;
            size--;
        }

    }
    public void remove(int index) {
        if(index == 0) {
            removeFirst();
        }
        else if(head == tail) {
            head = tail = null;
            size--;
        }
        else {
            Node cur = head;
            while (--index > 0) {
                cur = cur.link;
            }
            Node targetNode = cur.link;
            cur.link = targetNode.link;
            size--;
            if(cur.link == null)
                tail = cur;
        }
    }

    public void addFirst(T newElement){
        Node newNode = new Node(newElement);
        newNode.link = head;
        head = newNode;
        if(size==0) {
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T newElement) {
        if(index == 0)
            addFirst(newElement);
        else {
            Node temp1 = head;
            while (--index > 0) {
                temp1 = temp1.link;
            }
            Node newNode = new Node(newElement);
            newNode.link = temp1.link;
            temp1.link = newNode;

            if (newNode.link == null) {
                tail = newNode;
            }
            size++;
        }
    }

    public String toString() {
        String str = "[";
        Node temp = head;

        while(temp != null) {
            str = str + temp.data;
            if(temp != tail) {
                str = str + ", ";
            }
            temp = temp.link;
        }
        return str = str + "]";
    }

}
