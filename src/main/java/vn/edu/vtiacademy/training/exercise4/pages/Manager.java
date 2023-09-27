package vn.edu.vtiacademy.training.exercise4.pages;

import io.qameta.allure.Step;
import vn.edu.vtiacademy.training.exercise4.object_repo.ManagerRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class Manager extends BasePage {
    public Manager(WebUI webUI) {
        super(webUI);
    }

    @Step("Should be to show Manager Id as '{0}'")
    public boolean shouldBeToShowManagerIdAs(String managerId) {
        webUI.takeScreenShot();
        return webUI.verifyElementText(ManagerRepo.LBL_MANAGER_ID, managerId);
    }
}
