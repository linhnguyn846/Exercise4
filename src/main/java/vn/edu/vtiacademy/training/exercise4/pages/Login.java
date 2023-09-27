package vn.edu.vtiacademy.training.exercise4.pages;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import vn.edu.vtiacademy.training.exercise4.object_repo.ManagerRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
import vn.edu.vtiacademy.training.exercise4.object_repo.LoginRepo;

import java.util.List;

public class Login extends BasePage {
    public Login(WebUI webUI) {
        super(webUI);
    }

    @Step("Input user id: {0}")
    public void inputUserId(String userId) {
        if (userId.isBlank()) {
            webUI.sendKeys(LoginRepo.TXT_USER_ID, Keys.chord(Keys.TAB));
        } else {
            webUI.sendKeys(LoginRepo.TXT_USER_ID, userId);
        }
        webUI.takeScreenShotAndHighLightElement(LoginRepo.TXT_USER_ID);
    }

    @Step("Input user password: {0}")
    public void inputUserPassword(String userPassword) {
        if (userPassword.isBlank()) {
            webUI.sendKeys(LoginRepo.TXT_USER_PASSWORD, Keys.chord(Keys.TAB));
        } else {
            webUI.sendKeys(LoginRepo.TXT_USER_PASSWORD, userPassword);
        }
        webUI.takeScreenShotAndHighLightElement(LoginRepo.TXT_USER_PASSWORD);
    }

    @Step("Should not present user id error messsage in HTML DOM")
    public boolean shouldNotPresentUserIdErrorMessageInHTMLDom() {
        webUI.takeScreenShotAndHighLightElement(LoginRepo.LBL_USER_ID_ERROR_MESSAGE);
        return webUI.verifyElementNotPresent(LoginRepo.LBL_USER_ID_ERROR_MESSAGE);
    }

    @Step("Should not show user id error message")
    public boolean shouldNotShowUserIdErrorMessage() {
        webUI.takeScreenShotAndHighLightElement(LoginRepo.LBL_USER_ID_ERROR_MESSAGE);
        return webUI.verifyElementNotVisible(LoginRepo.LBL_USER_ID_ERROR_MESSAGE);
    }

    @Step("Should be to show user id error message as '{0}'")
    public boolean shouldBeToShowUserIdErrorMessageAs(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(LoginRepo.LBL_USER_ID_ERROR_MESSAGE);
        //      webUI.takeScreenShotAndHighLightElement(LoginRepo.LBL_USER_ID_ERROR_MESSAGE);
        return webUI.verifyElementText(LoginRepo.LBL_USER_ID_ERROR_MESSAGE, errorMessage);
    }

    @Step
    public boolean shouldNotShowUserPasswordErrorMessageOnUI() {

        webUI.takeScreenShotAndHighLightElement(LoginRepo.LBL_PASSWORD_ERROR_MESSAGE);

        return webUI.verifyElementNotVisible(LoginRepo.LBL_PASSWORD_ERROR_MESSAGE);
    }

    @Step
    public boolean shouldNotShowUserPasswordErrorMessage() {

        webUI.takeScreenShotAndHighLightElement(LoginRepo.LBL_PASSWORD_ERROR_MESSAGE);
        return webUI.verifyElementNotVisible(LoginRepo.LBL_PASSWORD_ERROR_MESSAGE);
    }

    @Step
    public boolean shouldBeToShowUserPasswordErrorMessageAs(String errorMessage) {
        webUI.takeScreenShot();
        return webUI.verifyElementText(LoginRepo.LBL_PASSWORD_ERROR_MESSAGE, errorMessage);
    }

    @Step("Click Login button")
    public void clickLoginButton() {

        webUI.takeScreenShotAndHighLightElement(LoginRepo.BTN_LOGIN);
        webUI.clickJS(LoginRepo.BTN_LOGIN);
        webUI.delayInSecond(3);
        webUI.takeScreenShot();
    }

    @Step("Login Guru 99 Bank with user id '{0}' and password '{1}'")
    public Manager loginGuru99BankWith(String userId, String userPassword) throws InterruptedException {
        inputUserId(userId);
        inputUserPassword(userPassword);
        clickLoginButton();
        Thread.sleep(3000);
        webUI.takeScreenShotAndHighLightElement(ManagerRepo.LBL_MANAGER_ID);
        return new Manager(this.webUI);
    }


}
