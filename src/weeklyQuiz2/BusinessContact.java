package weeklyQuiz2;

import java.util.Scanner;

import static weeklyQuiz2.Util.*;

public class BusinessContact extends Contact {
    private String company;
    private static final Scanner scanner = new Scanner(System.in);

    public BusinessContact(String name, String phoneNumber, String company) {
        super(name, phoneNumber);
        this.company = company;
    }

    // 팩토리 메서드
    public static BusinessContact createBusinessContact() {
        String name = inputName();
        String phoneNumber = inputPhone();
        String company = promptForCompany();

        return new BusinessContact(name, phoneNumber, company);
    }

    private static String promptForCompany(){
        System.out.print("회사명을 입력하세요: ");
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + ", 회사명 : " + company;
    }
}