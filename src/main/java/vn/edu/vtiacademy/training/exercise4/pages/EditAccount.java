package vn.edu.vtiacademy.training.exercise4.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import vn.edu.vtiacademy.training.exercise4.object_repo.EditAccountRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class EditAccount extends BasePage {
    public EditAccount(WebUI webUI) {
        super(webUI);
    }


    @Step("Navigate to url")
    public void navigatoToURL() {
        webUI.navigateToUrl(EditAccountRepo.EDITACCOUNT_URL);
    }

    @Step("Input account no: {0}")
    public void inputAccountNo(String accountNo) {
        if (accountNo.isBlank()) {
            webUI.sendKeys(EditAccountRepo.TXT_ACCOUNTNO, Keys.chord(Keys.TAB));
        } else {
            webUI.sendKeys(EditAccountRepo.TXT_ACCOUNTNO, accountNo);
        }
        webUI.takeScreenShotAndHighLightElement(EditAccountRepo.TXT_ACCOUNTNO);
    }

    @Step("Should not present account number error messsage in HTML DOM")
    public boolean shouldPresentAccountNumberErrorMessageInHTMLDom() {
        webUI.takeScreenShotAndHighLightElement(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);
        return webUI.verifyElementPresent(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);
    }

    @Step
    public boolean shouldShowAccountNumberdErrorMessageOnUI() {

        webUI.takeScreenShotAndHighLightElement(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);

        return webUI.verifyElementVisible(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);
    }

    @Step("Should be to show account no error message when account number is blank as '{0}'")
    public boolean shouldBeToShowAccountNumberErrorMessageAs(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);
        return webUI.verifyElementText(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE, errorMessage);
    }

    @Step("should be to show account number error message when type character value as '{0}'")
    public boolean shouldBeToShowAccountNumberErrorMessageWhenTypeCharacterValue(
            String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);
        return webUI.verifyElementText(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE, errorMessage);
    }

    @Step("should be to show account number error message when type special character as '{0}'")
    public boolean shouldBeToShowAccountNoErrorMessageWhenTypeSpecialChracter(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE);
        return webUI.verifyElementText(EditAccountRepo.LBL_ACCOUNTNO_ERROR_MESSAGE, errorMessage);
    }

}
