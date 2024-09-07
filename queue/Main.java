import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();

        System.out.println(queue.isEmpty());

        queue.offer("firstItem");
        queue.offer("secondItem");
        queue.offer("thirdItem");
        queue.offer("fifthItem");

        System.out.println(queue.size());

        queue.poll();
        queue.poll();

        System.out.println(queue.contains("secondItem"));

        System.out.println(queue.peek());
        System.out.println(queue);
    }
}