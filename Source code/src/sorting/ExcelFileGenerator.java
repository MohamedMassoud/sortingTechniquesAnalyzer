/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Math.pow;
import java.util.HashMap;
import javax.swing.JLabel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sorting.GUI.MainGUI;

/**
 *
 * @author Crap
 */
public class ExcelFileGenerator {
    private final String[] sorts = {"Bubble Sort", "Insertion Sort", "Heap Sort", "Merge Sort", "Quick Sort"};
    private HashMap<String, HashMap<Integer, Double>> info;
    private JLabel loadingLabel;
    
    public ExcelFileGenerator(HashMap<String, HashMap<Integer, Double>> info, JLabel loadingLabel){
        this.loadingLabel = loadingLabel;
        this.info = info;
    }
    
    public void createExcelFile() throws FileNotFoundException, IOException, InvalidFormatException{
       /*File file = new File("test.xlsx");
       file.createNewFile();*/
       XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sorting Techniques");
        Row row = sheet.createRow(0);
        /*Cell lengthCell = row.createCell(0);
        lengthCell.setCellValue("Input Size");*/
       for(int i=0;i<info.keySet().size();i++){
           
           Cell cell = row.createCell(i+1);
           cell.setCellValue(sorts[i]);
       }
      
        int x = 0;
       for(int j=0;j<MainGUI.getSamples();j+=MainGUI.getSamples()/MainGUI.getPlots()){
           Row row3 = sheet.createRow(x+1);
           Cell inputCell = row3.createCell(0);
           inputCell.setCellValue(j+MainGUI.getSamples()/MainGUI.getPlots());
           for(int i=0;i<info.keySet().size();i++){
               Cell cell = row3.createCell(i+1);   
               cell.setCellValue(info.get(sorts[i]).get(j));
           }
           x++;
       }
        try {
            FileOutputStream outputStream = new FileOutputStream("Sorting Techniques.xlsx");
            workbook.write(outputStream);
            workbook.close();
            loadingLabel.setText("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       
    }
}
