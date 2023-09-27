package vn.edu.vtiacademy.training.exercise4.pages;

import io.qameta.allure.Step;

import org.openqa.selenium.Keys;
import vn.edu.vtiacademy.training.exercise4.object_repo.NewAccountRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class NewAccount extends BasePage {
    public NewAccount(WebUI webUI) {
        super(webUI);
    }


    @Step("Navigate to New Account Page")
    public void navigateToNewAccountPage() {
        webUI.navigateToUrl(NewAccountRepo.NEWACCOUNT_URL);
    }

    @Step("Input customer id: {0}")
    public void inputCustomerId(String customerId) {
        if (customerId.isBlank()) {
            webUI.sendKeys(NewAccountRepo.CUSTOMERID_TXT, Keys.chord(Keys.TAB));
        } else {
            webUI.sendKeys(NewAccountRepo.CUSTOMERID_TXT, customerId);
        }
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSTOMERID_TXT);
    }

    @Step("Input initial deposit: {0}")
    public void inputInitialDeposit(String initialDeposit) {
        if (initialDeposit.isBlank()) {
            webUI.sendKeys(NewAccountRepo.DEPOSIT_TXT, Keys.chord(Keys.TAB));
        } else {
            webUI.sendKeys(NewAccountRepo.DEPOSIT_TXT, initialDeposit);
        }
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_TXT);
    }

    @Step("Should  present customer id error messsage in HTML DOM")
    public boolean shouldPresentCustomerIdErrorMessageInHTMLDom() {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
        return webUI.verifyElementPresent(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
    }

    @Step
    public boolean shouldShowCustomerIdErrorMessageOnUI() {

        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);

        return webUI.verifyElementVisible(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
    }

    @Step("Should show customer id error message when type character value")
    public boolean shouldBeToShowCustomerIdErrorMessageWhenTypeCharacterValue(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should show customer id error message when type special character value")
    public boolean shouldBeToShowCustomerIdErrorMessageWhenTypeSpecialCharacterValue(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should show customer id error message when have bank space")
    public boolean shouldBeToShowCustomerIdErrorMessageWhenTypeBlankCharacterValue(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should show customer id error message when type first character and tab key")
    public boolean shouldBeToShowCustomerIdErrorMessageWhenTypeFirstCharacterSpace(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.CUSID_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should  present initial deposit error messsage in HTML DOM")
    public boolean shouldPresentInitialDepositErrorMessageInHTMLDom() {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
        return webUI.verifyElementPresent(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
    }

    @Step
    public boolean shouldShowInitialDepositErrorMessageOnUI() {

        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);

        return webUI.verifyElementVisible(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
    }

    @Step("Should show initial deposit error message when type character value")
    public boolean shouldBeToShowInitialDepositErrorMessageWhenTypeCharacterValue(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should show initial deposit error message when type special character value")
    public boolean shouldBeToShowInitialDepositErrorMessageWhenTypeSpecialCharacterValue(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should show initial deposit error message when have bank space")
    public boolean shouldBeToShowInitialDepositErrorMessageWhenTypeBlankCharacterValue(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL, errorMessage);
    }

    @Step("Should show initial deposit error message when type first character and tab key")
    public boolean shouldBeToShowInitialDepositErrorMessageWhenTypeFirstCharacterSpace(String errorMessage) {
        webUI.takeScreenShotAndHighLightElement(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL);
        return webUI.verifyElementText(NewAccountRepo.DEPOSIT_ERROR_MESSAGE_LBL, errorMessage);
    }

}
