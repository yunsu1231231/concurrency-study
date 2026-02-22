package SemaphoreExample1;

import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
    // 항상 동시에 2개만 실행된다.
    static Semaphore semaphore = new Semaphore(2); // 동시에 2개 스레드만 임계구역 진입 가능

    public static void main(String[] args) {
        // 스레드 5개 생성
        for(int i = 0; i < 5; i++){
            int num = i;

            new Thread(() -> {
                try {
                    semaphore.acquire(); // 허가 획득
                    // permit 하나 가져오기, permit 남아있으면 즉시 통과, 없으면 대기 (block)

                    System.out.println("Thread " + num + " 실행중");
                    Thread.sleep(2000);
                    System.out.println("Thread " + num + " 종료");
                } catch (Exception e) {

                } finally {
                    semaphore.release(); // 허가 반납, 대기 중인 스레드 중 하나가 실행 가능해짐
                }
            }).start();
        }
    }

}

// ㅁ