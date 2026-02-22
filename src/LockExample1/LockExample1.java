package LockExample1;

import java.util.concurrent.locks.ReentrantLock;

// synchronized (모니터 락) 대신 "명시적 락"을 사용하는 방식
public class LockExample1 {

    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static void increase() {
        lock.lock(); // 1. lock.lock() 휙득 시도, 2. 이미 다른 스레드가 가지고 있으면 대기 3. 락 휙득 후 count++ 실행 4. finally에서 반드시 unlock()

        try {
            count++; // count 영역을 한 스레드만 실행하게 동작: 뮤텍스 동작
        } finally {
            lock.unlock(); // 예외가 생겼을 때 Deadlock 방지
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                increase();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("결과: " + count);
    }
}
