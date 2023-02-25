
import java.util.Queue;

public class MyStack {
    public static void main(String[] args) {

    }
}
class Mystack {
    Queue<Integer> queue;
    public Mystack() {
        queue = new Queue<Integer>();
    }

    public void push(int x) {
        int n  = queue.size();
        queue.offer(x);
        for(int i = 0; i < n; i++){
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}