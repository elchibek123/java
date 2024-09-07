import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<String>();

//        LinkedList as a Stack
//        linkedList.push("F");
//        linkedList.push("A");
//        linkedList.push("C");
//        linkedList.push("D");
//        linkedList.push("B");
//
//        linkedList.pop();

//        LinkedList as a Queue
        linkedList.offer("F");
        linkedList.offer("A");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("B");

//        linkedList.poll();

        linkedList.add(3, "E");
        linkedList.remove(4);

        linkedList.addFirst("0");
        linkedList.addLast("G");
        linkedList.removeFirst();
        linkedList.removeLast();

        System.out.println(linkedList.indexOf("C"));
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList);
    }
}