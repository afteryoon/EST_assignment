package daliy.d0923;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaExample_6 {
    private static Student[] students = {
            new Student("홍길동", 90, 96),
            new Student("저팔계", 95, 93)
    };


    /*  avg() 메소드 작성 */
    public static double avg(Function<Student, Integer> scoreFunction) {
        int sum = 0;
        for (Student student : students) {
            sum += scoreFunction.apply(student);
        }
        return (double) sum / students.length;
    }


    public static void main(String[] args) {
        double englishAvg = avg( s -> s.getEnglishScore() );
        System.out.println("영어 평균 점수: " + englishAvg);

        double mathAvg = avg( s -> s.getMathScore() );
        System.out.println("수학 평균 점수: " + mathAvg);

        System.out.println("-----------");
        Consumer<String> printer = message -> System.out.println("Message: " + message);
        printer.accept("Hello from Consumer!");  // 출력: Message: Hello from Consumer!
        List<String> messages = Arrays.asList("Hello", "Lambda", "Consumer");
        messages.forEach(printer);

    }


    public static class Student {
        private String name;
        private int englishScore;
        private int mathScore;

        public Student(String name, int englishScore, int mathScore) {
            this.name = name;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        public String getName() {
            return name;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }
    }
}