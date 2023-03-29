import Utils.DatabaseUtil;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DBDepartmenstsTable {
    @BeforeTest //instead of using create.connection every beginning of my method , i will use BeforeTest
    public void setUpConnection(){
        DatabaseUtil.createConnection();
    }

    @AfterTest
//instead of closing the connection after any test case just put your uti method here. and because Aftermethod runs everytime at last
    public void closeDoorOfConnection(){
        DatabaseUtil.closeConncection();
    }
    @Test(description ="Given connected database and departments table when we check  the column number Then it must be equal to given data")

    public void columnNumber(){

        //Given

        ResultSet resultSet= DatabaseUtil.runQuary("SLECT*FROM departments");

        int expectedNumberOfColumnCount= 4;// this is coming from ui, front-end

        //When
        ResultSetMetaData resultSetMetaData= null;
        int actualNumberOfColumnCount=0; //i just wanted to initialzei it here

        try{
            resultSetMetaData= resultSet.getMetaData();
            actualNumberOfColumnCount=resultSetMetaData.getColumnCount();

        }catch (SQLException throwables){
            System.out.println("This is error from meta data , system could not get the data");

        }
        //Then
        Assert.assertEquals(actualNumberOfColumnCount, expectedNumberOfColumnCount, "Total Column of countires table is incorrect ");

        //now close your connection
        //i will use aftertest for optimizing my framework



    }


    @Test(description="Given connected database and departments table when we check the first column name Then it must be equal to given data ")
    public void columnName(){

        //Given

        ResultSet resultSet= DatabaseUtil.runQuary("SELECT *FROM departments");
        String expectedFirstColumnName= "DEPARTMENT_ID"; //this is info might coming from ui(@FindBy(element etc)

        //when

        ResultSetMetaData resultSetMetaData= null; //we put it here bc it gives us error in the try and catch block
        String actualFirstColumnName= "";

        try{
            resultSetMetaData= resultSet.getMetaData();
            actualFirstColumnName= resultSetMetaData.getColumnName(1);


        }catch(SQLException throwables){
            System.out.println("System could not get  Meta data");
        }


        //Then.. now we will verify the scenario

        Assert.assertEquals(actualFirstColumnName, expectedFirstColumnName,"First Column Name IN Department is Incorrect!");
        //then close the connection , DO NOT FORGET!





    }

}
