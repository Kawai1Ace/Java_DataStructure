package data_structure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(4); //实际容量 -1
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("g(get / pop)");
            System.out.println("p(peek)");
            key = sc.next().charAt(0);
            switch (key){
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.print("Enter a number ");
                    int value = sc.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = circleArray.getQueue();
                        System.out.println("result: " + result);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int result = circleArray.headQueue();
                        System.out.println("result: " + result);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
    }
}
class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) { // real size is arrMaxSize - 1
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear  + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Full queue");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        return arr[front];
    }
}
