package vn.edu.vtiacademy.training.exercise4.test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vn.edu.vtiacademy.training.exercise4.pages.EditAccount;

import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

public class EditAccountTest extends BaseTest {
    private final EditAccount objEditAccount;


    public EditAccountTest() {
        super();
        objEditAccount = new EditAccount(this.webUI);
        setDataFile(EditAccountTest.class.getSimpleName());
        setDataFileExcelPath("DataTest");
        setSheetName(EditAccountTest.class.getSimpleName());


    }


    @Test(description = "TC001: Should be to show account no text box when press TAB key ", groups = {
            "smoketest", "functiotest"})
    @Description("Verify error message at account number text box if user input empty text")
    public void TC001_should_be_to_show_Account_number_error_message_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
        objEditAccount.navigatoToURL();
//        objEditAccount=objManager.objLeftMenu.gotoEditAccount;
//        objEditAccount.objAdvertisementPopup.closePopUp();
        objEditAccount.inputAccountNo(findTestDataByTestCaseID("EA1").get("inputValue"));
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(objEditAccount.shouldPresentAccountNumberErrorMessageInHTMLDom(),
                "Should not present User Id error message element in HTML DOM");
        softAssertion.assertTrue(objEditAccount.shouldShowAccountNumberdErrorMessageOnUI(),
                "Should not show User Id error message element on UI");
        softAssertion.assertAll();
    }

    @Test(description = "TC002: should be to show account number error message when type character value in Accountno textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at account number text box if user type character value in account number textbox")
    public void TC002_should_be_to_show_Account_number_error_message_type_character_value(Method method) {
        logger.info("Test case: " + method.getName());
        SoftAssert softAssertion = new SoftAssert();
        objEditAccount.inputAccountNo(findTestDataByTestCaseID("EA2").get("inputValue"));
        softAssertion.assertTrue(objEditAccount.shouldBeToShowAccountNumberErrorMessageWhenTypeCharacterValue(findTestDataByTestCaseID("EA2").get("expectedMessage")));

    }

    @Test(description = "TC003: should be to show account number error message when type special character value in Accountno textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at account number text box if user type special character value in account number textbox")
    public void TC003_should_be_to_show_Account_number_error_message_type_special_character_value(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(EditAccountRepo.TXT_ACCOUNTNO);
        objEditAccount.inputAccountNo(findTestData("EA3.value"));
        assertTrue(objEditAccount.shouldBeToShowAccountNoErrorMessageWhenTypeSpecialChracter(findTestData("EA3.error_message")));

    }

    @Test(description = "TC005: should be to show account number error message when type  character value press tab key in Accountno textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at account number text box if user type  character value have space in account number textbox")
    public void TC005_should_be_to_show_Account_number_error_message_type_character_value_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(EditAccountRepo.TXT_ACCOUNTNO);
        objEditAccount.inputAccountNo(findTestData("EA5.value"));
        assertTrue(objEditAccount.shouldBeToShowAccountNumberErrorMessageWhenTypeCharacterValue(findTestData("EA5.error_message")));

    }

    @Test(description = "TC006: should be to show account number error message when type first character value press tab key in Accountno textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at account number text box if user type first character value press tab key in account number textbox")
    public void TC006_should_be_to_show_Account_number_error_message_type_first_character_value_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(EditAccountRepo.TXT_ACCOUNTNO);
        objEditAccount.inputAccountNo(findTestData("EA6.value"));
        assertTrue(objEditAccount.shouldBeToShowAccountNumberErrorMessageWhenTypeCharacterValue(findTestData("EA6.error_message")));

    }

}
