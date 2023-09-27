package vn.edu.vtiacademy.training.exercise4.object_repo;

public class EditAccountRepo {
    public static final String TXT_ACCOUNTNO = "//input[@name='accountno']";
    public static final String LBL_ACCOUNTNO_ERROR_MESSAGE = "//label[@id='message2']";
    public static final String LBL_ACCOUNTNO_ERROR_MESSAGE_TEXT = "//label[text()='Account Number must not be blank']";
    public static final String LBL_ACCOUNTNO_ERROR_MESSAGE_SPECIAL = "//label[text()='Special characters are not allowed']";
    public static final String BTN_SUBMIT = "//input[@name='AccSubmit']";
    public static final String BTN_RESET = "//input[@name='res']";
    public static final String TXT_USER_ID = "//input[@name='uid']";

    public static final String TXT_USER_PASSWORD = "//input[@name='password']";

    public static final String BTN_LOGIN = "//input[@name='btnLogin']";
    public static String LBL_MANAGER_ID = "//tr[@class='heading3']/td[contains(normalize-space(),'Manger Id')]";
    public static String EDITACCOUNT_URL = "https://demo.guru99.com/v4/manager/editAccount.php";
}
