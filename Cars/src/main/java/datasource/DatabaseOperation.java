package datasource;

import databases.ConnectToSqlDB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperation {
   static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

   public static void insertDataIntoDB(){
       List<String> list = getItemValue();
       connectToSqlDB.insertStringDataFromArrayListToSqlTable(list,"ItemList","items");
   }

//    // this is we created
   public static List<String> getItemValue(){
      List<String> itemsList = new ArrayList<String>();
       itemsList.add("Toyota RAV4");
       itemsList.add("BMW X6");
       itemsList.add("Acura MDX");
        itemsList.add("Toyota Matrix");
        itemsList.add("BMW X5");
        itemsList.add("BMW X1");
        return itemsList;
    }
public List<String> getItemsListFromDB() throws Exception, IOException, SQLException,ClassNotFoundException{
    List<String> list = new ArrayList<String>();
   list = connectToSqlDB.readDataBase("ItemList","items");
  return list;
}
   public static void main(String[] args)throws Exception,IOException, SQLException,ClassNotFoundException{
//        // insert data into mysql
       insertDataIntoDB();
      ConnectToSqlDB connectToSqlDB= new ConnectToSqlDB();
      List<String> list = connectToSqlDB.readDataBase("ItemList","items");
     for(String st : list){
           System.out.println(st);
 }
   }
}
