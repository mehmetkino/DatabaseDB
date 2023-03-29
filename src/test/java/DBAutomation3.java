import java.sql.*;
import Utils.DatabaseUtil;

public class DBAutomation3 {
    public static void main(String[] args) throws SQLException {

        DatabaseUtil.createConnection();
        ResultSet resultSet= DatabaseUtil.runQuary("SELECT*FROM employees");
        resultSet.next();

        System.out.println(resultSet.getString(1));// this will give us information about first row


        //Meta Data-- interface that gives us an extensive information about table

        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();


        //Column count 11
        System.out.println(resultSetMetaData.getColumnCount());

        System.out.println(resultSetMetaData.getColumnName(2)); //name of 2nd column name is first_name


    }
}
