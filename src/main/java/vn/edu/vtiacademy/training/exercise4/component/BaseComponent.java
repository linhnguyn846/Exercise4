package vn.edu.vtiacademy.training.exercise4.component;

import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class BaseComponent {
    protected Logger logger = LogHelper.getLogger();
    protected WebUI webUI;

    public BaseComponent(WebUI webUI) {
        this.webUI = webUI;
    }
}
