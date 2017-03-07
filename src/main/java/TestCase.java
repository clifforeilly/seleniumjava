/**
 * Created by co17 on 07/03/2017.
 */

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.List;

public class TestCase {


    public TestCase(String testCaseName, String browser)
    {
        try {
            String fileName = "G:\\ShareOne\\Cliff\\Dev\\seleniumjava\\testcases.csv";

            CSVReader csvinput = new CSVReader(new FileReader(fileName));
            List csvinputdata = csvinput.readAll();
            csvinput.close();

            MyWebDriver driver = new MyWebDriver(browser);

            for(Object ob : csvinputdata) {
                String[] row=(String[]) ob;

                if(row[0].equals(testCaseName)){
                    for (String s : row) {
                        System.out.println(s);
                    }
                    driver.doAction(row[2], row[3], row[4], row[5], row[6]);
                }
            }

            driver.myClose();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
