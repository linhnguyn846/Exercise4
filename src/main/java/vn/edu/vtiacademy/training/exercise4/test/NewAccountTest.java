package vn.edu.vtiacademy.training.exercise4.test;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vn.edu.vtiacademy.training.exercise4.pages.NewAccount;
import vn.edu.vtiacademy.training.exercise4.test.BaseTest;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.testng.Assert.assertTrue;

public class NewAccountTest extends BaseTest {
    private final NewAccount objNewAccount;

    public NewAccountTest() {
        super();
        objNewAccount = new NewAccount(this.webUI);
        setDataFile(NewAccountTest.class.getSimpleName());
        setDataFileExcelPath("DataTest");
        setSheetName(NewAccountTest.class.getSimpleName());
        setDataFile(NewAccountTest.class.getSimpleName());
    }

    @Test(description = "TC001: Should be to show customer id text box when press TAB key ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at customer id text box if user input empty text")
    public void TC001_should_be_to_show_customer_id_error_message_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
        objNewAccount.navigateToNewAccountPage();
        objNewAccount.inputCustomerId(findTestData("NA1.value"));
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(objNewAccount.shouldPresentCustomerIdErrorMessageInHTMLDom(),
                "Should not present Customer Id error message element in HTML DOM");
        softAssertion.assertTrue(objNewAccount.shouldShowCustomerIdErrorMessageOnUI(),
                "Should not show Customer Id error message element on UI");
        softAssertion.assertAll();
    }

    @Test(description = "TC002: should be to show customer id error message when type character value in customer id textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at Customer id text box if user type character value in customer id textbox")
    public void TC002_should_be_to_show_Customer_Id_error_message_type_character_value(Method method) {
        logger.info("Test case: " + method.getName());
        SoftAssert softAssertion = new SoftAssert();
        objNewAccount.inputCustomerId(findTestData("NA2.value"));
        softAssertion.assertTrue(objNewAccount.shouldBeToShowCustomerIdErrorMessageWhenTypeCharacterValue(findTestData("NA2.error_message")));

    }

    @Test(description = "TC003: should be to show customer id error message when type special character value in customer id textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at customer id text box if user type special character value in customer id textbox")
    public void TC003_should_be_to_show_customer_id_error_message_type_special_character_value(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(NewAccountRepo.CUSTOMERID_TXT);
        objNewAccount.inputCustomerId(findTestData("NA3.value"));
        assertTrue(objNewAccount.shouldBeToShowCustomerIdErrorMessageWhenTypeSpecialCharacterValue(findTestData("NA3.error_message")));

    }

    @Test(description = "TC004: should be to show customer id error message when type  character value press tab key in customer id textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at customer id text box if user type  character value have space in customer id textbox")
    public void TC004_should_be_to_show_customer_id_error_message_type_character_value_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(NewAccountRepo.CUSTOMERID_TXT);
        objNewAccount.inputCustomerId(findTestData("NA4.value"));
        assertTrue(objNewAccount.shouldBeToShowCustomerIdErrorMessageWhenTypeBlankCharacterValue(findTestData("NA4.error_message")));

    }

    @Test(description = "TC005: should be to show customer id error message when type first character value press tab key in customer id textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at customer id text box if user type first character value press tab key in customer id textbox")
    public void TC005_should_be_to_show_customer_id_error_message_type_first_character_value_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(NewAccountRepo.CUSTOMERID_TXT);
        objNewAccount.inputCustomerId(findTestData("NA5.value"));
        assertTrue(objNewAccount.shouldBeToShowCustomerIdErrorMessageWhenTypeFirstCharacterSpace(findTestData("NA5.error_message")));

    }

    @Test(description = "TC006: Should be to show initial deposit text box when press TAB key ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at initial deposit text box if user input empty text")
    public void TC006_should_be_to_show_initial_deposit_error_message_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
        objNewAccount.inputInitialDeposit(findTestData("NA6.value"));
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(objNewAccount.shouldPresentInitialDepositErrorMessageInHTMLDom(),
                "Should not present initial deposit error message element in HTML DOM");
        softAssertion.assertTrue(objNewAccount.shouldShowInitialDepositErrorMessageOnUI(),
                "Should not show initial deposit  error message element on UI");
        softAssertion.assertAll();
    }

    @Test(description = "TC007: should be to show initial deposit error message when type character value in initial deposit textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at initial deposit text box if user type character value in initial deposit textbox")
    public void TC007_should_be_to_show_initial_deposit_error_message_type_character_value(Method method) {
        logger.info("Test case: " + method.getName());
        SoftAssert softAssertion = new SoftAssert();
        objNewAccount.inputInitialDeposit(findTestData("NA7.value"));
        softAssertion.assertTrue(objNewAccount.shouldBeToShowInitialDepositErrorMessageWhenTypeCharacterValue(findTestData("NA7.error_message")));

    }

    @Test(description = "TC008: should be to show initial deposit error message when type special character value in initial deposit textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at initial deposit text box if user type special character value in initial deposit textbox")
    public void TC008_should_be_to_show_initial_deposit_error_message_type_special_character_value(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(NewAccountRepo.DEPOSIT_TXT);
        objNewAccount.inputInitialDeposit(findTestData("NA8.value"));
        assertTrue(objNewAccount.shouldBeToShowInitialDepositErrorMessageWhenTypeSpecialCharacterValue(findTestData("NA8.error_message")));

    }

    @Test(description = "TC009: should be to show initial deposit error message when type  character value press tab key in initial deposit textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at initial deposit text box if user type  character value have space in initial deposit textbox")
    public void TC009_should_be_to_show_initial_deposit_error_message_type_character_value_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
//        webUI.clearText(NewAccountRepo.DEPOSIT_TXT);
        objNewAccount.inputInitialDeposit(findTestData("NA9.value"));
        assertTrue(objNewAccount.shouldBeToShowInitialDepositErrorMessageWhenTypeBlankCharacterValue(findTestData("NA9.error_message")));

    }

    @Test(description = "TC010: should be to show initial deposit error message when type first character value press tab key in Accountno textbox  ", groups = {
            "smoketest", "functiontest"})
    @Description("Verify error message at initial deposit text box if user type first character value press tab key in account number textbox")
    public void TC010_should_be_to_show_initial_deposit_error_message_type_first_character_value_press_tab_key(Method method) {
        logger.info("Test case: " + method.getName());
        SoftAssert softAssertion = new SoftAssert();
//        webUI.clearText(NewAccountRepo.DEPOSIT_TXT);
        objNewAccount.inputInitialDeposit(findTestData("NA10.value"));
        softAssertion.assertTrue(objNewAccount.shouldBeToShowInitialDepositErrorMessageWhenTypeFirstCharacterSpace(findTestData("NA10.error_message")));

    }
}
