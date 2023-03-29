
package Utils;
import java.sql.*;


public class DatabaseUtil {

    private static Connection connection;
    private static Statement statement ;
    private static ResultSet resultSet;

   public static void createConnection(){

       /* 3 components that we need for connecting to database(url of host name, username and password)
       1-url
       2-username
       3-password

        */

       String url ="jdbc:oracle:thin:@ec2-54-159--174-62.compute-1.amazon.aws.com:1521:XE";
       String username= "hr";
       String password= "hr";

       Connection connection;


       //we need a try and catch method in case if it throws any exception

       try{
           connection = DriverManager.getConnection(url,username,password);
           System.out.println("Connection is created successfully ");
       }catch (SQLException throwables){
           System.out.println("Connection is failed");
       }

   }

   public static ResultSet runQuary(String quary){

       try {
           statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

           resultSet = statement.executeQuery(quary);

       }catch (SQLException throwables){
           System.out.println();
       }

       return resultSet;


   }
   public static void closeConncection(){

       try{
           resultSet.close();
           statement.close();
           connection.close();
           System.out.println("Conncetion door is open");

       }catch(SQLException throwables){

           System.out.println("Connection door is closed");


       }
   }

}
