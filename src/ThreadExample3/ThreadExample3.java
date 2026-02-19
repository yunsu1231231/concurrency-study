package ThreadExample3;

// MyThread 새로운 스레드
class MyThread extends Thread {

    // run() = 스레드가 실행할 코드
    @Override
    public void run(){
        System.out.println("Thread 실행: " + getName());
    }
}
public class ThreadExample3 {
    public static void main(String[] args) {

        MyThread t = new MyThread(); // 1. 객체 생성

        t.start(); // 2. 스레드 생성 및 run() 실행
    }
}
