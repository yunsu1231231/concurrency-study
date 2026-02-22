1. synchronized 단점 -> 해결한 것이 Lock
```declarative
1. 블로킹 상태 확인 불가
2. 타임아웃 설정 불가
3. 공정성(fairness) 설정 불가
4. 조건 변수 사용 어려움
```

2. synchronized와 차이
```declarative
public synchronized static void increase()
```
JVM이 자동으로 락 관리, 코드 간결, 락 객체를 직접 제어 못함

```declarative
lock.lock();
try {...} finally {lock.unlock();}
```

락을 직접 제어, 더 많은 기능 제공

3. 이론적 뮤텍스 구조
```declarative
전역 변수 lock

acquire(): // lock.lock()
    while(lock == 1) 기다림
    lock = 1

임계구역

release(): // lock.unlock()
    lock = 0
```
ReentrantLock: 자바 라이브러리 + CAS + 큐 기반