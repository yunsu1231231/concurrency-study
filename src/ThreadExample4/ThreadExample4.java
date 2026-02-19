package ThreadExample4;

// Race Condition
public class ThreadExample4 {
    static int count = 0; // 모든 스레드가 공유하는 전역변수

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                count++;
            }
        });

        t1.start(); // start()는 비동기. main은 새로운 스레드에게 작업을 맡기고 자기 할 일을 계속 수행
        t2.start();

        // main 스레드가 t1, t2 끝날 때까지 기다림
        t1.join();
        t2.join();

        System.out.printf("결과: " + count);
    }
}
