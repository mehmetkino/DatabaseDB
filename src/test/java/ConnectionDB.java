import java.sql.*;

public class ConnectionDB {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@ec2-54-159--174-62.compute-1.amazon.aws.com:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection connection = null;


        //1. step create connection

        connection = DriverManager.getConnection(url,username,password);


        //2. step create statement/ create your bridge

        Statement statement= connection.createStatement();

        // 3. step create resultset quary to store your result

        ResultSet resultSet= statement.executeQuery("SELECT * FROM cauntries");


        //resultset.next(); // moves to the next row


        System.out.println("First column value"+resultSet.getString("country_id"));
        System.out.println("Second Column Value" +resultSet.getString("country_name"));
        System.out.println("Third Column Value"  +resultSet.getString("region_id"));



    }
}
