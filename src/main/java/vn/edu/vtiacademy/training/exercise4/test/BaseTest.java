package vn.edu.vtiacademy.training.exercise4.test;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.testng.annotations.*;
import vn.edu.vtiacademy.training.exercise4.pages.Login;
import vn.edu.vtiacademy.training.exercise4.pages.Manager;
import vn.edu.vtiacademy.training.exercise4.test.LoginTest;
import vn.edu.vtiacademy.training.utils.helper.FileHelper;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;

import vn.edu.vtiacademy.training.utils.keywords.Excel;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class BaseTest {
    private static final String ALLURE_RESULTS_FOLDER = System.getProperty("user.dir") + File.separator + "target" + File.separator + "allure-results";
    protected static Logger logger = LogHelper.getLogger();
    private static final String DEMO_GURU99_URL = "https://demo.guru99.com/v4/";
    protected final WebUI webUI;
    protected Login objLogin;
    protected Manager objManager;
    private HashMap<String, String> dataFile;
    private String dataFilePath;
    private String sheetName;


//    private HSSFWorkbook workbook;
//    private HSSFSheet sheet;

    public BaseTest() {
        webUI = new WebUI();
    }

    private static Class<?> getCallerClass(final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        try {
            return getCallerClassFromStackTrace(index + 1);
        } catch (final ClassNotFoundException e) {
            logger.error("Could not find class in ReflectionUtil.getCallerClass({}), index<" + index + ">"
                    + ", exception< " + e + ">");
        }
        return null;
    }

    private static Class<?> getCallerClassFromStackTrace(final int index)
            throws ClassNotFoundException {

        final StackTraceElement[] elements = new Throwable().getStackTrace();
        int i = 0;
        for (final StackTraceElement element : elements) {
            if (isValidMethod(element)) {
                if (i == index) {
                    return Class.forName(element.getClassName());
                }
                ++i;
            }
        }
        throw new IndexOutOfBoundsException(Integer.toString(index));
    }

    private static boolean isValidMethod(final StackTraceElement element) {
        if (element.isNativeMethod()) {
            return false;
        }
        final String cn = element.getClassName();
        if (cn.startsWith("sun.reflect.")) {
            return false;
        }
        final String mn = element.getMethodName();
        if (cn.startsWith("java.lang.reflect.") && (mn.equals("invoke") || mn.equals("newInstance"))) {
            return false;
        }
        return !cn.equals("java.lang.Class") || !mn.equals("newInstance");
    }

    private static void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        dir.delete();
    }

    public void setDataFileExcelPath(String dataFileName) {
        this.dataFilePath = FileHelper.getExcelDataFilePath(dataFileName);
    }

    public String getDataExcelFile() {
        return this.dataFilePath;
    }

    public String getSheetName() {
        return this.sheetName;
    }


    //  @Parameters({"browser"})
    // @BeforeSuite(alwaysRun = true)
    //  public void beforeSuite(String browser) {
//        // Xóa thư mục allure-results trước khi chạy test
//        String allureResultsDirPath = ALLURE_RESULTS_FOLDER;
//        File allureResultsDir = new File(allureResultsDirPath);
//        if (allureResultsDir.exists() && allureResultsDir.isDirectory()) {
//            deleteDirectory(allureResultsDir);
//        }
//        webUI.openBrowser("Firefox",DEMO_GURU99_URL);


//    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    @BeforeClass
    public void beforeClass() {
        logger.info("=====================Before Class: " + LoginTest.class.getName());

    }

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browser) throws InterruptedException {
        String allureResultsDirPath = ALLURE_RESULTS_FOLDER;
        File allureResultsDir = new File(allureResultsDirPath);
        if (allureResultsDir.exists() && allureResultsDir.isDirectory()) {
            deleteDirectory(allureResultsDir);
        }
        objLogin = goToLoginPage(browser);
        objManager = objLogin.loginGuru99BankWith("mngr529283", "jYbydyg");


        // Xóa thư mục allure-results trước khi chạy test

    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("==================Before Method: " + method.getName());
    }

    @AfterMethod
    public void afterMethod(Method method) {
        logger.info("==================After Method: " + method.getName());
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        webUI.closeBrowser();
    }

    @AfterClass
    public void afterClass() {
        logger.info("=====================After Class: " + LoginTest.class.getName());

    }


    public String getDataFile() {
        String strClassName = getCallerClass(3).getSimpleName();
        return this.dataFile.get(strClassName);
    }

    public String setDataFile(String dataFileName) {
        if (this.dataFile == null) {
            this.dataFile = new HashMap<>();
        }
        String strClassName = getCallerClass(2).getSimpleName();

        dataFileName = FileHelper.getDataJSONFilePath(dataFileName);
        return this.dataFile.put(strClassName, dataFileName);
    }

    public String findTestData(String name) {
        String dataFile = this.getDataFile();
//    logger.info("Data file: " + dataFile);
        try {
            File jsonRepoFile = new File(dataFile);
            return JsonPath.read(jsonRepoFile, "$." + name).toString();
        } catch (Exception e) {
            logger.error(
                    MessageFormat.format("Cannot find test data with name ''{0}''. Root cause: {1}", name,
                            e.getMessage()));
        }
        return null;
    }

    public HashMap<String, String> findTestDataByTestCaseID(String testcaseId) {
        String dataFile = this.getDataExcelFile();
        String sheetName = this.getSheetName();
        logger.info("Data file: " + dataFile);
        try {
            return Excel.readExcelSheetByTestCaseID(dataFile, sheetName, testcaseId);
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot find data with name ''{0}''. Root cause: {1}",
                    sheetName, e.getMessage()));
        }
        return null;
    }


    public Login goToLoginPage(String browser) {
        webUI.openBrowser(browser, DEMO_GURU99_URL);
        webUI.maximizeWindow();
        return new Login(this.webUI);
    }
}
