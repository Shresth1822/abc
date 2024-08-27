//Using array
public class LinearQueue {
	static private int front, rear, maxSize;
	static private int queue[];

	LinearQueue(int c)
	{
		front = rear = 0;
		maxSize = c;
		queue = new int[maxSize];
	}

i98
	static void queueEnqueue(int data)
	{
		if (maxSize == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}
		else {
			queue[rear] = data;
			rear++;
		}
		return;
	}

    static void queueDequeue() {
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
        } else {
            for (int i = front; i < rear - 1; i++) {
                queue[i] = queue[i + 1]; // last 2nd element
            }
            rear--;
        }
    }

	static void queueDisplay()
	{
		int i;
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		for (i = front; i < rear; i++) {
			System.out.printf("%d ", queue[i]);
		}
		return;
	}

    	public static void main(String[] args)
	{
	
		LinearQueue queue = new LinearQueue(4);

        System.out.print("\nInitially: ");
		queueDisplay();

		queueEnqueue(1);
		queueEnqueue(2);
		queueEnqueue(3);
		queueEnqueue(4);

        System.out.println("After adding: ");
		queueDisplay();

        
		queueDequeue();
		queueDequeue();
		
        System.out.println("\nAfter removing: ");
		queueDisplay();

	}
}