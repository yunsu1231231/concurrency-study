package CompleteableFutureExample1;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample1 {
    public static void main(String[] args) {
        System.out.println("논리 CPU 개수: " + Runtime.getRuntime().availableProcessors());

        /**
         * CompletableFuture<String> future =
         *         CompletableFuture.supplyAsync(...)
         * 1. supplyAsync 호출
         * 2. ForkJoinPool.commonPool() 사용
         * 3. 작업을 공용 풀에 제출
         * 4. Worker Thread가 실행 시작 (daemon worker thread 실행)
         *
         * 작업이 완료되면
         * CompletableFuture 내부에서:
         * 1. 상태: incomplete → complete("Hello")
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            return "Hello";
        });

        /**
         * 작업이 끝나면 결과를 받아서 출력
         * 1. future가 complete 되면:
         * 2. 등록된 콜백이 실행됨.
         *
         * future.thenAccept vs future.thenAcceptAsync
         * 전자는 처음 등록된 스레드와 콜백 실행 스레드 동일.
         * 후자는 다를 가능성이 높다.
         */
        future.thenAccept(result -> {
            System.out.println("결과: " + result);
        });

        System.out.println("메인 스레드 종료"); // 메인 스레드는 비동기니깐 기다리지 않고 바로 출력

        try {
            Thread.sleep(3000);
        } catch (Exception e) {}
    }
}
