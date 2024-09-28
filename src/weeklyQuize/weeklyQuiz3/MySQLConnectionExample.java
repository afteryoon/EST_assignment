package weeklyQuize.weeklyQuiz3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLConnectionExample {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        //학생 테이블에 있는 전체 학생들 중, 30대 학생들만 출력하기 (name, age, addres)
        String query = "SELECT name,age,address " +
                "FROM students " +
                "WHERE age BETWEEN 30 AND 39";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            //System.out.println("Database connection established");
            List<StudentDAO> students = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                students.add(new StudentDAO(name, age, address));
            }

            System.out.println(students);
            //출력 구문
            // [Student{name='김정호', age=30, address='전라북도'}, Student{name='박지원', age=31, address='전라북도'}, Student{name='김홍도', age=32, address='경기도'}, Student{name='신윤복', age=33, address='서울특별시'}, Student{name='김광균', age=34, address='서울특별시'}, Student{name='한용운', age=35, address='경상남도'}, Student{name='박두진', age=36, address='경기도'}]

        } catch (SQLException e) {
            System.out.println("SQL Exception caught");
            e.printStackTrace();
        }
    }
}