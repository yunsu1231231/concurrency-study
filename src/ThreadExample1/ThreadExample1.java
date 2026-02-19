package ThreadExample1;

public class ThreadExample1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("새로운 스레도 실행 중: " + Thread.currentThread().getName());
            }
        });
        thread.start(); // 새로운 thread가 run을 실행함
//        thread.run(); 이러면 main이 실행한 것

        System.out.println("메인 스레드 실행 중: " + Thread.currentThread().getName());
    }
}

// 1. main 스레드 1개 존재
// 2. 추가 thread 생성 -> 동시에 여러 작업 수행
// 3. Runnable = 스레드가 실행할 작업을 정의하는 인터페이스
//public interface Runnable {
//    void run();
//}
