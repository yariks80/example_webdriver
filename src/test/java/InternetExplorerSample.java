import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by my on 24.05.2015.
 */
public class InternetExplorerSample {
    @Test
    public void simpleRun() {
        System.setProperty("webdriver.ie.driver", "Libdrivers\\IEDriverServer32.exe");
        InternetExplorerDriver driver = new InternetExplorerDriver();
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void runThroughProxy() throws MalformedURLException {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8888");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("proxy", proxy);

        InternetExplorerDriver driver = new InternetExplorerDriver(capabilities);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }

    @Test
    public void runCustomized() {
        InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
                .usingDriverExecutable(new File("C:/Tools/IEDriverServer.exe"))
                .build();
        //https://code.google.com/p/selenium/wiki/DesiredCapabilities
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        InternetExplorerDriver driver = new InternetExplorerDriver(service, capabilities);

        driver.get("http://selenium2.ru/");
        driver.quit();
    }
}
