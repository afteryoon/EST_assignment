package weeklyQuiz2;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook<T extends Contact> {
    private ArrayList<T> contacts;
    private Scanner scanner= new Scanner(System.in);

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    //business
    public void addContact(T contact) {
        contacts.add(contact);
    }

    public void PrintContacts() {
        contacts.forEach(System.out::println);
    }

    // Optional: Method to find a contact by name
    public void findContactByName() {
        System.out.print("이름을 입력하세요 :");
        String name = scanner.nextLine();

        boolean flag = false;
        for (T contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("연락처를 찾을 수 없습니다.");
        }
    }
}