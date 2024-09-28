package weeklyQuize.weeklyQuiz3;

public class StudentDAO {
    private String name;
    private int age;
    private String address;

    public StudentDAO(String name, int age,  String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
