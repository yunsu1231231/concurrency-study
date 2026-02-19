```declarative
main 스레드
   │
   ├─ t1 생성 (count 10000 증가)
   ├─ t2 생성 (count 10000 증가)
   │
   ├─ t1.start()
   ├─ t2.start()
   │
   ├─ t1.join() ← 기다림
   ├─ t2.join() ← 기다림
   │
   └─ 결과 출력

```