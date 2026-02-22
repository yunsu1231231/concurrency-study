package ThreadExample5;

// synchronized 해결
public class ThreadExample5 {
    static int count = 0; // 임계 영역: 공유 자원 접근 코드

    // 1. increase()에 락이 걸림 (공유 자원에 락을 걸어 순차처리)
    // 2. 한 번에 한 스레드만 실행 가능
    public synchronized static void increase(){
        count++; // 실제로 3단계 1. count 값을 읽고 2. + 1을 한 후 3. 다시 저장한다.
        // Race Condition: 두 스레드가 동시에 읽으면 5,5 읽 / 저장 6 6 => 값 하나가 날라갈 수 있다.
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                increase();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
