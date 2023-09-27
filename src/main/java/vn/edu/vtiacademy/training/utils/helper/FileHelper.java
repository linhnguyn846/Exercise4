package vn.edu.vtiacademy.training.utils.helper;

import java.io.File;

import org.slf4j.Logger;

public class FileHelper {
    private static final String TEST_DATA_FOLDER = "testdata";
    private static final String RESOURCE_FOLDER = "resources";

    private static final String JSON_EXTENSION = ".json";
    private static final String EXCEL_EXTENSION = ".xlsx";

    private static final String SOURCE_FOLDER = "src";

    private static final String MAIN_FOLDER = "main";

    private static final String USER_DIR = "user.dir";

    private static final Logger logger = LogHelper.getLogger();

    public static String getDataJSONFilePath(String dataJsonName) {
        logger.info(System.getProperty(USER_DIR) + File.separator + SOURCE_FOLDER + File.separator + MAIN_FOLDER
                + File.separator + RESOURCE_FOLDER + File.separator + TEST_DATA_FOLDER + File.separator
                + dataJsonName + JSON_EXTENSION);
        return System.getProperty(USER_DIR) + File.separator + SOURCE_FOLDER + File.separator + MAIN_FOLDER
                + File.separator + RESOURCE_FOLDER + File.separator + TEST_DATA_FOLDER + File.separator
                + dataJsonName + JSON_EXTENSION;
    }

    public static String getExcelDataFilePath(String excelFilename) {
        logger.info(System.getProperty(USER_DIR) + File.separator + SOURCE_FOLDER + File.separator + MAIN_FOLDER
                + File.separator + RESOURCE_FOLDER + File.separator + TEST_DATA_FOLDER + File.separator
                + excelFilename + EXCEL_EXTENSION);
        String correctFilePath = System.getProperty(USER_DIR) + File.separator + SOURCE_FOLDER + File.separator + MAIN_FOLDER
                + File.separator + RESOURCE_FOLDER + File.separator + TEST_DATA_FOLDER + File.separator
                + excelFilename + EXCEL_EXTENSION;
        return correctFilePath;
    }


    public static String getDataJSONFilePathOneSeparator(String fileName) {
        logger.info(System.getProperty(USER_DIR) + File.separator + SOURCE_FOLDER + File.separator + fileName);

        return System.getProperty(USER_DIR) + File.separator + SOURCE_FOLDER + File.separator + fileName;
    }
}
