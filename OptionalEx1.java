import java.util.Optional;
import java.util.OptionalInt;

public class OptionalEx1 {
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("ABCDE");
        System.out.println("optionalString = " + optionalString); // 출력 : Optional[ABCDE]
        System.out.println("optionalString.get() = " + optionalString.get()); // 출력 : ABCDE

        Optional<Integer> optionalInteger = optionalString.map(String::length);
        System.out.println("optionalInteger = " + optionalInteger.get());


        int result1 = Optional.of("123")
                .filter(x -> !x.isEmpty())
                .map(Integer::parseInt).get();

        System.out.println("result1 = " + result1);

        int result2 = Optional.of("")
                .filter(x -> !x.isEmpty())
                .map(Integer::parseInt).orElse(-100); // orElse는 만약에 Optional의 값이 null이라면 orElse에 있는 값을 대신 대입

        System.out.println("result2 = " + result2);

        Optional.of("456")
                .map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3 = %d %n", x)); // Optional의 값이 Null이면 False를 반환한다.
        // 즉, Optional의 요소가 null인지 아닌지를 체크한다.

        OptionalInt optionalInt1 = OptionalInt.of(0); // Optional의 요소가 0인 Optional 생성
        optionalInt1.ifPresent(value -> System.out.println("optionalInt1 = " + value));

        OptionalInt optionalInt2 = OptionalInt.empty(); // Optional의 요소가 없는 Optional 생성
        optionalInt2.ifPresent(value -> System.out.println("optionalInt2 = " + value));

        System.out.println(optionalInt1.getAsInt());   // 0
//		System.out.println(optInt2.getAsInt());   // NoSuchElementException
        System.out.println("optInt1 =" + optionalInt1);
        System.out.println("optInt2=" + optionalInt2);
        System.out.println("optInt1.equals(optInt2)?" + optionalInt1.equals(optionalInt2));

        Optional<String> opt = Optional.ofNullable(null); // null을 저장
        Optional<String> opt2 = Optional.empty();          // 빈 객체를 생성
        System.out.println("opt =" + opt);
        System.out.println("opt2=" + opt2);
        System.out.println("opt.equals(opt2)?" + opt.equals(opt2)); // true

        int result3 = optStrToInt(Optional.of("123"), 0);
        int result4 = optStrToInt(Optional.of(""), 0);

        System.out.println("result3=" + result3);
        System.out.println("result3=" + result4);
    }

    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}

