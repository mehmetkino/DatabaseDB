import java.sql.*;
import Utils.DatabaseUtil;


public class DBAutomation2 {
    public static void main(String[] args) throws SQLException {

        DatabaseUtil.createConnection();
        ResultSet resultSet= DatabaseUtil.runQuary("SELECT*FROM countries");


        //check if the cursor is after last row
        System.out.println(resultSet.isAfterLast());


        //check is the cursor is before first row
        System.out.println(resultSet.isBeforeFirst());

        //if you wanna move the cursor to the next row use:
        resultSet.next(); //==>now it will show us first row of counties table
        resultSet.next();
        resultSet.next();


        //if you wanna pull a pesific row information use absolute keyword
        resultSet.absolute(6);


    }
}
