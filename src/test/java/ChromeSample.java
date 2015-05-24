import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by my on 24.05.2015.
 */
//http://chromedriver.storage.googleapis.com/index.html
public class ChromeSample {
    @Test
    public void simpleRun() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
//запуск яндекса браузера
    @Test
    public void runFromNonstandardLocation() {

        ChromeOptions options = new ChromeOptions();

        options.setBinary("C:\\Users\\my\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void runWithExtensions() {
        ChromeOptions options = new ChromeOptions();

        options.addExtensions(new File("C:/Users/alexei/Downloads/WebDriverIDE.crx"));

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void runThroughProxy() throws MalformedURLException {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8888");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("proxy", proxy);

        ChromeDriver driver = new ChromeDriver(capabilities);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
}
