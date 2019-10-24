package databases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class XlsxDataReader {
    XSSFWorkbook xssfWorkbook;
    XSSFSheet xssfSheet;

    public XlsxDataReader(String xlFilePath){
        try{
            File src = new File(xlFilePath);
            FileInputStream fis =new FileInputStream(src);
            xssfWorkbook = new XSSFWorkbook(fis);
            xssfSheet = xssfWorkbook.getSheetAt(0);
           // xssfWorkbook.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getData(int sheetnumber,int rownumber,int colnumber)	{
        xssfSheet = xssfWorkbook.getSheetAt(sheetnumber);
        String data = xssfSheet.getRow(rownumber).getCell(colnumber).getStringCellValue();
        return data;
    }
    public int getRowCount(String sheetName) {
        int index = xssfWorkbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            xssfSheet = xssfWorkbook.getSheetAt(index);
            int number = xssfSheet.getLastRowNum() + 1;
            return number;
        }
    }
}