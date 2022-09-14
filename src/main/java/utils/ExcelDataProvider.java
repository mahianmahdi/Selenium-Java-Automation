package utils;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;
import java.io.File;
import java.lang.reflect.Method;

/**
 * @Author Abu Bakkar Shohag
 */

public class ExcelDataProvider {
    public static Object[][] multiSheetExcelRead(Method method) throws Exception {
        File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
        String SheetName = method.getName();
        return ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
    }

    @DataProvider(name = "excelSheetNameAsMethodName")
    public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception {
        File file = new File("src/test/resources/Test Data/Excel Files/" + method.getName() + ".xlsx");
        return ExcelUtils.getTableArray(file.getAbsolutePath());
    }
}
