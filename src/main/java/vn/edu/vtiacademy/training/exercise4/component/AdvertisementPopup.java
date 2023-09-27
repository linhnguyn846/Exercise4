package vn.edu.vtiacademy.training.exercise4.component;

import io.qameta.allure.Step;
import vn.edu.vtiacademy.training.exercise4.object_repo.AdvertisementPopupRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class AdvertisementPopup extends BaseComponent {
    public AdvertisementPopup(WebUI webUI) {
        super(webUI);
    }

    @Step("Click close button on Advertisement popup")
    public void closePopUp() {
        if (webUI.waitForElementVisible(AdvertisementPopupRepo.FRA_GOOGLE_ADS)) {
            webUI.switchToIframe(AdvertisementPopupRepo.FRA_GOOGLE_ADS);
        }
        if (webUI.waitForElementVisible(AdvertisementPopupRepo.BTN_CLOSE)) {
            webUI.clickElement(AdvertisementPopupRepo.BTN_CLOSE);
        } else {
            webUI.waitForElementVisible(AdvertisementPopupRepo.FRA_GOOGLE_ADS);
            webUI.clickElement(AdvertisementPopupRepo.BTN_CLOSE);
        }
        webUI.switchToDefaultContext();
    }
}
