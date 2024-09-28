package weeklyQuize.weeklyQuiz2;

public abstract class Contact {
    String name;
    String phoneNumber;

    Contact(){};

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Object getName() {
        return name;
    }

    //출력메서드


    @Override
    public String toString() {
        return  "이름: "+name +", 전화번호: "+ phoneNumber;
    }
}
