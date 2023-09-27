package vn.edu.vtiacademy.training.exercise4.pages;

import org.slf4j.Logger;
import vn.edu.vtiacademy.training.exercise4.component.AdvertisementPopup;
import vn.edu.vtiacademy.training.exercise4.component.LeftMenu;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class BasePage {
    //has a: Page has a advertisement popup, left menu => Manager or New Customer has components: advertisement popup, left menu
    public AdvertisementPopup objAdvertisementPopup;
    public LeftMenu objLeftMenu;
    protected Logger logger = LogHelper.getLogger();
    protected WebUI webUI;

    public BasePage(WebUI webUI) {
        this.webUI = webUI;
        objAdvertisementPopup = new AdvertisementPopup(this.webUI);
        objLeftMenu = new LeftMenu(this.webUI);
    }
}
