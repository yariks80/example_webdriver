import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

/**
 * Created by my on 24.05.2015.
 */

public class PhantomJSSample {
    //http://phantomjs.org/download.html
    @Test
    public void simpleRun() throws InterruptedException {
        File file = new File("Libdrivers\\phantomjs.exe");
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
        PhantomJSDriver driver = new PhantomJSDriver();
        driver.get("http://www.google.com");
        Thread.sleep(2000);
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Page CurrentUrl is: "+CurrentUrl);
        driver.quit();
    }
}
