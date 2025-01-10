import java.sql.*;
public class CRUD {

    // Steps to configure JDBC connection with JAVA 
    // 1. import Package
    // 2. load and register
    // 3. create connection
    // 4. excute statement
    // 5. process and result
    // 6. close

    String url = "jdbc:postgresql://127.0.0.1:5432/Students";
    String uname = "postgres";
    String password = "1234";

    String sql_query = "SELECT * FROM public.students_data ORDER BY sid ASC";
    String sql_query1 = "INSERT INTO public.students_data (sid, class, marks, name) VALUES (4, 9, 99, 'Jyoti')";
    
    void insert() throws Exception {
        // create connection
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        System.out.println("Connection Established!!");

        // create statement
        Statement st = con.createStatement();

        // Execute the INSERT statement
        int rowsInserted = st.executeUpdate(sql_query1);
        System.out.println(rowsInserted + " row(s) inserted.");

        con.close();
        System.out.println("Connection closed!!");
    }

    void showTable() throws Exception {
        // create connection
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, password);
        System.out.println("Connection Established!!");

        // create statement
        Statement st = con.createStatement();

        // execute statement
        ResultSet result = st.executeQuery(sql_query);

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
