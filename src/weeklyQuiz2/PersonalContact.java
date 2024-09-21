package weeklyQuiz2;

import java.util.Scanner;

import static weeklyQuiz2.Util.inputName;
import static weeklyQuiz2.Util.inputPhone;

public class PersonalContact extends Contact {
    private String relationship;
    private static final Scanner scanner = new Scanner(System.in);

    public PersonalContact(String name, String phoneNumber, String relationship) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    // 팩토리 메서드
    public static PersonalContact createPersonalContact() {
        String name = inputName();
        String phoneNumber = inputPhone();
        String relationship = promptForRelationship();

        return new PersonalContact(name, phoneNumber, relationship);
    }

    private static String promptForRelationship(){
        System.out.print("관계를 입력하세요: ");
        return scanner.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + ", 회사명 : " + relationship;
    }
}