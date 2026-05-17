import java.sql.*;          //import

/*PrepareStatement can understand  '?' inside a query
    it is more secure than Statement as it can handle sqlInjection
    and it also improves performance
 */


public class PrepareStm {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url="jdbc:postgresql://localhost:5432/Demo";
        String uname="postgres";
        String pass="satyam721";
        String sql = "INSERT INTO users VALUES (?,?,?)";

        String name="Sagar";
        int id =12;
        String email="sagar@example.com";

        Connection con = DriverManager.getConnection(url, uname, pass);

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);
        st.setString(2,name);
        st.setString(3,email);

        st.execute();




        con.close();
        System.out.println( "Connection closed");




    }
}
