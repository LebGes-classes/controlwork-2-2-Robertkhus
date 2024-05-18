import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XLSXWriter {
    private ArrayList<TVChanel> tvChanels;

    public XLSXWriter (ArrayList<TVChanel> tvChanels) {
        this.tvChanels = tvChanels;
    }

    public void writeXLSX (String filePath) {

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {

            Workbook workbook = new XSSFWorkbook(fileInputStream);

            try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
                for (int i = 0; i < tvChanels.size(); i++) {
                    Sheet sheet = workbook.createSheet(tvChanels.get(i).getChanel());
                    write(sheet, tvChanels.get(i));
                }
                workbook.write(fileOutputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write (Sheet sheet, TVChanel tvChanel) {
        int rowNum = 0;

        Row header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Программа");
        header.createCell(1).setCellValue("Часы");
        header.createCell(2).setCellValue("Минуты");

        for (int i = 0; i < tvChanel.getName().size(); i++) {

            Row newRow = sheet.createRow(rowNum++);

            newRow.createCell(0)
                    .setCellValue(tvChanel.getName().get(i));
            newRow.createCell(1)
                    .setCellValue(tvChanel.getBroadcastsTime().get(i).getHour());
            newRow.createCell(2)
                    .setCellValue(tvChanel.getBroadcastsTime().get(i).getMinute());

        }
    }
}
