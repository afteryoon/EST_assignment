package weeklyQuiz2;

import java.util.Scanner;

public class UserSearchAction {
    private static final int EXIT_OPTION = 5;
    private static final Scanner sc = new Scanner(System.in);
    private static final AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        try {
            runMenu();
        } finally {
            sc.close();
        }
    }

    private static void runMenu() {
        int selectNum;
        do {
            printMainQuestion();
            selectNum = getUserInput();
            processMenuOption(selectNum);
        } while (selectNum != EXIT_OPTION);
    }

    private static void printMainQuestion() {
        System.out.print(
                "1. 비지니스 연락처 추가\n" +
                        "2. 개인 연락처 추가\n" +
                        "3. 연락처 출력\n" +
                        "4. 연락처 검색\n" +
                        "5. 종료\n" +
                        "메뉴를 선택해주세요 :"
        );
    }

    private static int getUserInput() {
        while (true) {
            try {
                int input = sc.nextInt();
                if (input < 1 || input > EXIT_OPTION) {
                    throw new IllegalArgumentException("1~5의 숫자를 입력해주세요");
                }
                return input;
            } catch (Exception e) {
                if(e.getMessage() != null)
                    System.out.println(e.getMessage());
                else
                    System.out.println("숫자를 입력해주세요");
                sc.nextLine();
                runMenu();
            }
        }
    }

    private static void processMenuOption(int option) {
        switch (option) {
            case 1:
                BusinessContact businessContact = BusinessContact.createBusinessContact();
                addressBook.addContact(businessContact);
                break;
            case 2:
                PersonalContact personalContact = PersonalContact.createPersonalContact();
                addressBook.addContact(personalContact);
                break;
            case 3:
                addressBook.PrintContacts();
                break;
            case 4:
                addressBook.findContactByName();
                break;
        }
    }

}
