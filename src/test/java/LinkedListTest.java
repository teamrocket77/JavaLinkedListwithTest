import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


public class LinkedListTest {

    @Test
    @DisplayName("Get first one object")
    void TestinggetFirst() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(0, "s");
        assertTrue(mylist.size == 1);
        assertTrue(mylist.getFirst().equals("s"));

    }

    @Test()
    @DisplayName("Get first no objects")
    void TestinggetFirst2() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            MyLinkedList<String> mylist = new MyLinkedList<>();
            assertTrue(mylist.size == 0);
            mylist.getFirst();
        });

        Assertions.assertEquals("There are no nodes in the list", exception.getMessage());

    }

    @Test
    @DisplayName("Get last one object")
    void TestinggetLastone() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(0, "s");
        assertTrue(mylist.getLast().equals("s"));
        assertTrue(mylist.size ==  1);

    }
    @Test
    @DisplayName("Get first no objects")
    void TestinggetLastExcep() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            MyLinkedList<String> mylist = new MyLinkedList<>();
            assertTrue(mylist.size == 0);
            mylist.getFirst();
        });

        Assertions.assertEquals("There are no nodes in the list", exception.getMessage());


    }
    @Test
    @DisplayName("Get first two objects")
    void TestinggetLast() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(0, "s");
        mylist.add(1, "2");
        assertTrue(mylist.getFirst().equals("s"));

    }
    @Test
    @DisplayName("Adding Last only")
    void TestingaddLastOneObjFirst() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addLast("t");

        assertTrue(mylist.getLast().equals("t"));
    }
    @Test
    @DisplayName("Adding First then adding Last")
    void TestingaddLastOneObjLast() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addFirst("s");
        mylist.addLast("t");

        assertTrue(mylist.getLast().equals("t"));
    }

    @Test
    @DisplayName("Adding Last with two objects")
    void TestingaddLastTwoObjs() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addLast("s");
        mylist.addLast("t");

        assertTrue(mylist.getLast().equals("t"));
    }

    @Test
    @DisplayName("Remove Last after add First")
    void TestingremoveLastFirst() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addFirst("s");
        mylist.removeLast();
        System.out.println(mylist.size == 0);
    }

    @Test
    @DisplayName("Remove Last after add Last")
    void TestingremoveLastLast() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addLast("s");
        mylist.removeLast();
        assertTrue(mylist.size == 0);
    }

    @Test
    @DisplayName("Remove Last empty list")
    void TestingremoveLastEmpty() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            MyLinkedList<String> mylist = new MyLinkedList<>();
            mylist.getFirst();
        });

        Assertions.assertEquals("There are no nodes in the list", exception.getMessage());
    }

    @Test
    @DisplayName("Index of Empty List")
    void TestingindexOf() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        assertTrue(mylist.indexOf("t") == -1);
    }


    @Test
    @DisplayName("Index of list with 1 items List")
    void TestingindexOfOne() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addFirst("t");
        assertTrue(mylist.indexOf("t") == 0);
    }


    @Test
    @DisplayName("Index of list with two items")
    void TestingindexOfN() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addFirst("s");
        mylist.addFirst("2");
        assertTrue(mylist.indexOf("s") == 1);
        assertTrue(mylist.indexOf("2") == 0);
    }


    @Test
    @DisplayName("Index of list with two items and Last function")
    void TestingindexOfNLast() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addLast("s");
        mylist.addLast("2");
        assertTrue(mylist.indexOf("s") == 0);
        assertTrue(mylist.indexOf("2") == 1);
    }

    @Test
    @DisplayName("Index of list with two items add last and first function")
    void TestingindexOfNFirstLast() {
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.addFirst("s");
        mylist.addLast("2");
        assertTrue(mylist.indexOf("s") == 0);
        assertTrue(mylist.indexOf("2") == 1);
    }




}
