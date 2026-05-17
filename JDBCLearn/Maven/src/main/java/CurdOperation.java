import java.sql.*;          //import

public class CurdOperation {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");   //throws an exception

        String url="jdbc:postgresql://localhost:5432/Demo";
        String uname="postgres";
        String pass="satyam721";
        String query = "INSERT INTO users (id, name, email) VALUES (11, 'Satyam', 'satyam@gmail.com')";

        Connection con = DriverManager.getConnection(url, uname, pass);   //throws an exception
        Statement st = con.createStatement();

        //Create / Update / Delete
        Boolean status = st.execute(query);  //returns true if it is result set, if number of column effected then returns false
        System.out.println(status);  //true if resultset, false if number of column effected



        con.close();
        System.out.println( "Connection closed");




    }
}
