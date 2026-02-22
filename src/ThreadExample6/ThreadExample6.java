package ThreadExample6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 스레드를 직접 만들지 않고, 스레드 풀에 작업을 맡기는 코드
public class ThreadExample6 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 스레드 3개 생성 + 3개 재사용 + 최대 3개 작업 실행 가능

        for(int i = 0; i < 10; i++){
            int num = i; // 람다에서 사용하는 변수는 effectively final: 람다에서 사용하는 지역변수는 값이 한 번 정해지면 다시 변경되면 안된다.

            // 작업을 스레드 풀에 제출한다.
            /*
            submit() 동작
            1. 작업을 큐에 넣는다 // ExecutorService 내부에 큐가 존재.
            2. 놀고 있는 스레드가 가져간다.
            3. run()을 실행한다.
             */
            executor.submit(() -> {
                System.out.println(
                        Thread.currentThread().getName() + "작업: " + num);
            });
        }

        executor.shutdown();
    }
}
