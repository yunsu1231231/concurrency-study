1. 
```
main 스레드
   │
   ├─ thread.start() 호출
   │     └─ 새로운 스레드 생성 (Thread-0)
   │
   ├─ 바로 다음 줄 실행
   │     └─ 메인 스레드 출력 실행
   │
   └─ 그 후 Thread-0 실행

```
2. CPU는 한 번에 하나의 스레드만 실행
```declarative
시간 0ms: main 실행
시간 1ms: main 실행
시간 2ms: main 실행
시간 3ms: Thread-0 실행

```
3. CPU 스케줄러 (Scheduler)
```declarative
1. 새로운 스레드 생성
2. Runnable 상태로 변경
3. CPU 스케줄러에게 등록
4. CPU 받으면 run() 실행

실행 시점은 OS가 결정
```

4. sout 내부는 synchronized 
```declarative
한 스레드만 println 실행 가능. 다른 스레드는 기다린다. (Thread - safe)
```
