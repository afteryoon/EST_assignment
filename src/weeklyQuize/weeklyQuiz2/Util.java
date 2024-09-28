package weeklyQuize.weeklyQuiz2;

import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputName() {
        System.out.print("이름을 입력하세요: ");
        return scanner.nextLine().trim();
    }

    public static String inputPhone() {
        while (true) {
            System.out.print("전화번호를 입력하세요 (-제외한 숫자 11자리): ");
            String phone = scanner.nextLine().trim();
            if (isValidPhoneNumber(phone)) {
                return formatPhoneNumber(phone);
            }
            System.out.println("올바른 형식이 아닙니다. 11자리의 숫자를 입력하세요.");
        }
    }

    private static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{11}");
    }

    public static String formatPhoneNumber(String phone) {
        return phone.replaceFirst("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
    }
}