package PreProcess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Model.TweeterModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetInformation {

    private List<TweeterModel> tweeterModels = new ArrayList<>();


    public List<TweeterModel> getTweeterModels() {
        return tweeterModels;
    }

    public void getFromExel() throws IOException {
        int n = 0, n2;
        File file = new File("src/main/resources/Zarif.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook book = new XSSFWorkbook(fis);
        XSSFSheet sheet = book.getSheetAt(0);
        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                TweeterModel tweeterModel = new TweeterModel();
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        tweeterModel.setText(cell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        tweeterModel.setTweeterId(Double.parseDouble(cell.getNumericCellValue() + "\t"));
                        break;
                }
                tweeterModel.setId(UUID.randomUUID());
                tweeterModels.add(tweeterModel);
            }
            n++;
        }
    }
}
