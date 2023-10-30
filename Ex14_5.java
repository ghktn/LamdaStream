import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 2, 120),
                new Student("박자바", 1, 150),
                new Student("최자바", 1, 180),
                new Student("나자바", 2, 200),
                new Student("김자바", 3, 230),
                new Student("정자바", 2, 229)
        );

        // 스트림을 이용한 정렬
        studentStream.sorted(Comparator.comparing(Student::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

    }
}


class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }

}