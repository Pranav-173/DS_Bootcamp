import java.util.Scanner;

public class StackExample {
	static int MAX_SIZE = 100;
	static int[] stack = new int[MAX_SIZE];
	static int top = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Stack Operations ---");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter value to push: ");
					int value = sc.nextInt();
					push(value);
					break;
				case 2:
					pop();
					break;
				case 3:
					display();
					break;
				case 4:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		} while (choice != 4);
		sc.close();
	}

	static boolean isFull() {
		return top == MAX_SIZE - 1;
	}

	static boolean isEmpty() {
		return top == -1;
	}

	static void push(int value) {
		if (isFull()) {
			System.out.println("Stack Overflow! Cannot push " + value);
			return;
		}
		stack[top++] = value;
		System.out.println(value + " pushed to stack");
	}

	static int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow! Cannot pop");
			return -1;
		}
		System.out.println(stack[top] + " popped from stack");
		return stack[top--];
	}

	static void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		System.out.print("Stack: ");
		for (int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}
}