package databases;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XlsDataReader {
    HSSFWorkbook xlsWorkbook;
    HSSFSheet xlsSheet;
    int rowNum;
    Cell cell = null;
    FileOutputStream fio = null;

    public XlsDataReader(String xlFilePath){
        try{
            File src = new File(xlFilePath);
            FileInputStream fis =new FileInputStream(src);
            xlsWorkbook = new HSSFWorkbook(fis);
            xlsSheet = xlsWorkbook.getSheetAt(0);
           // xlsWorkbook.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String getData(int sheetnumber,int rownumber,int colnumber)	{
        xlsSheet = xlsWorkbook.getSheetAt(sheetnumber);
        String data = xlsSheet.getRow(rownumber).getCell(colnumber).getStringCellValue();
        return data;
    }
    public int getRowCount(String sheetName) {
        int index = xlsWorkbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            xlsSheet = xlsWorkbook.getSheetAt(index);
            int number = xlsSheet.getLastRowNum() + 1;
            return number;
        }
    }
    public void writeBack(String value) throws IOException {
        xlsWorkbook = new HSSFWorkbook();
        xlsSheet = xlsWorkbook.createSheet();
        Row row = xlsSheet.createRow(rowNum);
        row.setHeightInPoints(10);

        fio = new FileOutputStream(new File("ExcelFile.xls"));
        xlsWorkbook.write(fio);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            row.createCell(i);
            cell.setCellValue(value);
        }
        fio.close();
       // xlsWorkbook.close();
    }
}