import java.util.concurrent.ArrayBlockingQueue;

public class BoundQueue {
	public static void main(String[] args) {
		ArrayBlockingQueue <Integer> boundedQueue = new ArrayBlockingQueue<>(2);
		System.out.println("The elements are: ");
		boundedQueue.add(10);
		boundedQueue.add(20);
		boundedQueue.add(30);
		System.out.print(bondedQueue);
	}
}
