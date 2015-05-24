import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by my on 24.05.2015.
 */
public class HtmlUnitSample {
    @Test
    public void simpleRun() {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost/");
        driver.quit();
    }

}
