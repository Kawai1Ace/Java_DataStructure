package data_structure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("p(peek)");
            key = sc.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    System.out.print("Enter a number ");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.println("result: " + result);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int result = arrayQueue.peek();
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

//使用数组模拟队列
class ArrayQueue{
    private int MaxSize;
    private int front;
    private int rear;
    private int[] arr;

    //Constructor
    public ArrayQueue(){}
    public ArrayQueue(int arrMaxSize){
        this.MaxSize = arrMaxSize;
        this.arr = new int[arrMaxSize];
        this.front = -1;
        this.rear = -1;
    }
    public boolean isFull(){
        return rear == MaxSize - 1;
    }
    public boolean isEmpty(){
        return rear == front;
    }
    public void addQueue(int n){
        if(isFull()){
            System.out.println("The queue is full , can not push");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){ //pop
        if(isEmpty()){
            //抛出异常处理
            throw new RuntimeException("Empty queue");
        }
        front++;
        return arr[front];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return;
        }
        for(int i = front + 1 ; i <= rear ; ++i){
            System.out.printf("arr[%d] = %d \n" , i , arr[i]);
        }
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Empty");
        }
        return arr[front + 1];
    }
}
