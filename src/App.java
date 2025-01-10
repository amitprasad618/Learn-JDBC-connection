import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Steps to configure JDBC connection with JAVA 
        // 1. import Package
        // 2. load and register
        // 3. create connection
        // 4. excute statement
        // 5. process and result
        // 6. close

        // if you want to connect mysql just change below url instead of postgresql to mysql
        String url = "jdbc:postgresql://127.0.0.1:5432/Students";
        String uname = "postgres";
        String password = "1234";

        // create connection
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        System.out.println("Connection Established!!");

        // create statement
        Statement st = con.createStatement();
        String sql_query1 = "SELECT name FROM public.students_data WHERE sid = 2";
        String sql_query2 = "SELECT * FROM public.students_data ORDER BY sid ASC";

        // execute statement
        ResultSet result = st.executeQuery(sql_query2);
        // result.next();
        // String name = result.getString("name");
        // System.out.println("Name of Student is: "+name);


        // Print column headers
        System.out.printf("%-5s %-7s %-7s %-10s%n", "SID", "CLASS", "MARKS", "NAME");
        System.out.println("-------------------------------");

        // Iterate through the ResultSet and print each row
        while (result.next()) {
            int sid = result.getInt("sid");
            int studentClass = result.getInt("class");
            int marks = result.getInt("marks");
            String name = result.getString("name");

            System.out.printf("%-5d %-7d %-7d %-10s%n", sid, studentClass, marks, name);
        }



        con.close();
        System.out.println("Connection closed!!");
    }
}
