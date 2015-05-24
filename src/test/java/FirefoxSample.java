import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by my on 24.05.2015.
 */
public class FirefoxSample {
    @Test
    public void simpleRunInLocalBrowser()  {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://selenium2.ru/");
        driver.quit();
    }


    @Test
    public void testRemotelyOnLocalHost()  {
        WebDriver driver = new RemoteWebDriver(DesiredCapabilities.firefox( ));
        driver.get("http://selenium2.ru/");
        driver.quit();
    }

    @Test
    public void testRemotelyOnRemoteHost() throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(
                new URL("http://192.168.0.2:4444/wd/hab"),
                DesiredCapabilities.firefox());
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void testRemotelyOnRemoteHostinCloud() throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(
                new URL("http://sviatkin:27ddfd5c-83ea-45a6-87a8-4fc610aafc30@ondemand.saucelabs.com:80/wd/hub"),
                DesiredCapabilities.firefox());
        driver.get("http://selenium2.ru/");
        driver.quit();
    }

    //public FirefoxDriver(FirefoxBinary binary, FirefoxProfile profile, Capabilities capabilities)
    //FirefoxBinary- свойства bin
    //FirefoxProfile -профиль
    // Capabilities - доп.свойства плагина
    // запуск Aurora-firefox.exe с нестандартного расположения
    @Test
    public void runFromNonstandardLocation() {
        FirefoxBinary binary = new FirefoxBinary(
                new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe"));

        FirefoxProfile profile = new FirefoxProfile();

        FirefoxDriver driver = new FirefoxDriver(binary, profile);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void runWithLongerTimeout() {
        FirefoxBinary binary = new FirefoxBinary();
        binary.setTimeout(90000); // default is 45000

        FirefoxProfile profile = new FirefoxProfile();

        FirefoxDriver driver = new FirefoxDriver(binary, profile);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void runWithCustomProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en-us, en");

        profile.setPreference("browser.download.dir", "C:/TEMP");
        profile.setPreference("browser.download.folderList", 2);

        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setAcceptUntrustedCertificates(true);

        FirefoxDriver driver = new FirefoxDriver(profile);
        driver.get("http://ci.seleniumhq.org:8080/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void runWithExtensions() throws IOException {
        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(new File("C:/Users/my/Downloads/firebug-1.11.4-fx.xpi"));
        profile.setPreference("extensions.firebug.currentVersion", "9.9.9");
        profile.setPreference("extensions.firebug.allPagesActivation", "on");
        profile.setPreference("extensions.firebug.defaultPanelName", "net");
        profile.setPreference("extensions.firebug.net.enableSites", true);

        FirefoxDriver driver = new FirefoxDriver(profile);
        driver.get("http://selenium2.ru/");
        //driver.quit();
    }
    @Test
    public void runWithExistingProfile() {
        FirefoxProfile profile = new FirefoxProfile(
                new File("C:/Users/alexei/AppData/Roaming/Mozilla/Firefox/Profiles/lzmkqeur.selenium"));

        FirefoxDriver driver = new FirefoxDriver(profile);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }

}
