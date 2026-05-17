import java.sql.*;          //import

public class JdbcConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        * 1) import package
        * 2) load and register
        * 3) create statement
        * 4) execute statement
        * 5) process and results
        * 6) close
        * */

        // 2)   (Optional Step)
        Class.forName("org.postgresql.Driver");   //throws an exception

        String url="jdbc:postgresql://localhost:5432/Demo";
        String uname="postgres";
        String pass="satyam721";
        String query = "select * from users";

        // 3
        Connection con = DriverManager.getConnection(url, uname, pass);   //throws an exception
        Statement st = con.createStatement();

        // 4
        ResultSet rs = st.executeQuery(query);

        // 5
        rs.next(); //the pointer by default has set before 1st row , use this to move pointer on 1st row
        String result = rs.getString("name");
        System.out.println(result);

        //6
        con.close();




    }
}
