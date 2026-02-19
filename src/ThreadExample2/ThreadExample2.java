package ThreadExample2;

// 1. 동일한 작업을 (MyTask)을 두 개의 스레드가 동시에 수행하는 멀티스레드 예제
public class ThreadExample2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask()); // t1 → MyTask 실행하는 스레드
        Thread t2 = new Thread(new MyTask()); // t2 → MyTask 실행하는 스레드

        t1.start(); // Thread-0 실행 시작
        t2.start(); // Thread-1 실행 시작
    }

    /**
     * 스레드가 실행할 작업 정의
     * Runnable = 작업 정의 인터페이스
     */
    static class MyTask implements Runnable {

        @Override
        public void run(){
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + " 실행 " + i);
            }

            try{
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }
}
