class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinearQueueLL {
    private Node front, rear;

    public LinearQueueLL() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            System.out.println(data + " enqueued to the queue.");
            return;
        }

        rear.next = newNode;
        rear = newNode;
        System.out.println(data + " enqueued to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        int removedItem = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println(removedItem + " dequeued from the queue.");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;
        System.out.print("Queue elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
     LinearQueueLL queue = new LinearQueueLL();

        System.out.println("Is Empty: " + queue.isEmpty());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Is Empty: " + queue.isEmpty());

        queue.dequeue();
        queue.display();
    }
}
