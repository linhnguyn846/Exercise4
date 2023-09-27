package vn.edu.vtiacademy.training.exercise4.test;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Description;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vn.edu.vtiacademy.training.exercise4.pages.Login;
import vn.edu.vtiacademy.training.exercise4.pages.Manager;
import vn.edu.vtiacademy.training.exercise4.pages.BasePage;

public class LoginTest extends BaseTest {
    private final Login objLogin;
    private Manager objManager;

    public LoginTest() {
        super();
        objLogin = new Login(this.webUI);
        setDataFile(LoginTest.class.getSimpleName());
    }

    @DataProvider(name = "TC003")
    public static Object[] getTC003Data() {
        return new Object[]{
                "User-ID must not be blank"
        };
    }

    @DataProvider(name = "TC004")
    public static Object[] getTC004Data() {
        return new Object[]{
                "Password must not be blank"
        };
    }

    @DataProvider(name = "TC005")
    public static Object[] getTC005Data() {
        return new Object[][]{
                {"mngr512485", "AhEmumy", "Manger Id: "}
        };
    }

    @Test(description = "TC001: Should not show error message at user id text box", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at user id text box if user input empty text")
    public void TC001_should_not_show_error_message_at_user_id_text_box(Method method) {
        logger.info("Test case: " + method.getName());
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(objLogin.shouldNotPresentUserIdErrorMessageInHTMLDom(),
                "Should not present User Id error message element in HTML DOM");
        softAssertion.assertTrue(objLogin.shouldNotShowUserIdErrorMessage(),
                "Should not show User Id error message element on UI");
        softAssertion.assertAll();
    }

    @Test(description = "TC002: Should not show error message at password text box", groups = {
            "functiontest"})
    @Description("Verify error message at password text box if user input empty text")
    public void TC002_should_not_show_error_message_at_password_text_box(Method method) {
        logger.info("Test case: " + method.getName());
//    webUI.verifyElementNotVisible(LBL_PASSWORD_ERROR_MESSAGE);
        assertTrue(objLogin.shouldNotShowUserPasswordErrorMessageOnUI(),
                "Should not show User Password error message element on UI");
    }

    @Test(description = "TC003: Should show error message at user id text box after press Tab key", groups = {
            "smoketest", "functiontest"})
    public void TC003_should_show_error_message_at_user_id_text_box_after_press_Tab_key(Method method) {
        logger.info("Test case: " + method.getName());
        objLogin.inputUserId("");
        assertTrue(objLogin.shouldBeToShowUserIdErrorMessageAs(findTestData("TC003.error_message")),
                MessageFormat.format("Should be to show User Id error message as ''{0}''",
                        findTestData("TC003.error_message")));
    }

    //expectedMessage = Object[0] = "Password must not be blank"
    @Test(description = "TC004: Should show error message at user password text box after press Tab key", groups = {
            "smoketest", "functiontest"})
    public void TC004_should_show_error_message_at_user_password_text_box_after_press_Tab_key(Method method) {
        logger.info("Test case: " + method.getName());
        objLogin.inputUserPassword("");

        assertTrue(objLogin.shouldBeToShowUserPasswordErrorMessageAs(findTestData("TC004.error_message")),
                MessageFormat.format("Should be to show User Id error message as ''{0}''",
                        findTestData("TC004.error_message")));

    }

    @Test(description = "TC005: Login Successfully", groups = {
            "smoketest", "functiontest"})
    public void TC005_login_successfully(Method method) throws InterruptedException {
        logger.info("Test case: " + method.getName());
//    objLogin.inputUserId(userId);
//    objLogin.inputUserPassword(userPassword);
//    objManager = objLogin.clickLoginButton();

        objManager = objLogin.loginGuru99BankWith(findTestData("TC005.user_id"), findTestData("TC005.user_password"));

        assertTrue(objManager.shouldBeToShowManagerIdAs(findTestData("TC005.expected_message") + findTestData("TC005.user_id")),
                MessageFormat.format("Should be to show Manager Id as ''{0}{1}''",
                        findTestData("TC005.expected_message"), findTestData("TC005.user_id")));
    }
}
