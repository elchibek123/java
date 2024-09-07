import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

    public static void main(String[] args) {

//        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());
//
//        queue.offer(3.0);
//        queue.offer(2.5);
//        queue.offer(4.0);
//        queue.offer(1.5);
//        queue.offer(2.0);

        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer("F");
        queue.offer("A");
        queue.offer("C");
        queue.offer("D");
        queue.offer("B");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}