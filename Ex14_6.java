import java.io.File;
import java.util.stream.Stream;

public class Ex14_6 {
    public static void main(String[] args) {
        File[] files = {new File("Ex1.java"),
                        new File("Ex2.exe"),
                        new File("안녕.txt"),
                        new File("김수용.jpeg")};

        Stream<File> fileStream = Stream.of(files); // 파일 배열로 파일 스트림을 생성

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> fileNameStream = fileStream.map(File::getName);
        // fileNameStream에 모든 요소를 꺼내며 출력하기
        fileNameStream.forEach(System.out::println);

        fileStream = Stream.of(files); // 스트림을 소모했으니 다시 생성

        fileStream.map(File::getName) // 다시 생성한 fileStream을 fileNameStream으로 요소 변환
                .filter(s -> s.indexOf('.') != -1) // 확장자가 없는 것은 제외
                .peek(s -> System.out.printf("fileName = %s%n", s))
                .map(s -> s.substring(s.indexOf('.') + 1)) // 확장자만 추출
                .map(String::toUpperCase) // 요소 모두 대문자로 변환
                .distinct() // 중복 제거
                .forEach(System.out::println); // 출력

        System.out.println();
    }
}
