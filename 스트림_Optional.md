스트림 Optional
======
----
 자바에서 가장 많이 발생하는 예외는 NullPointException이다. NPE는 런타임
 에러라서 코드를 실행시키기 전까지 확인하기가 어려운 에러인데 이런 문제를 해결하려고 등장한 것이 <b>Optional</b> 이다.

> 즉 Optional은 Null을 포함한 모든 Object를 담을 수 있다.

### Optional을 생성하는 방법
```java
public static <T> Optional <T> of(T value)
public static <T> Optional <T> empty()
public static <T> Optional <T> ofNullable(T value)
```
- of(T value)

