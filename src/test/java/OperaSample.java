import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Created by my on 24.05.2015.
 */
public class OperaSample {

    @Test
    public void simpleRun0() {
        System.setProperty("webdriver.opera.driver", "Libdrivers\\operadriver32.exe");
        WebDriver driver= new OperaDriver();
        driver.get("http://selenium2.ru/");
        driver.quit();
    }
    @Test
    public void simpleRun1() {
       // System.setProperty("webdriver.opera.driver", "Libdrivers\\operadriver32.exe");
        /*
        * Увы, несмотря на то, что браузер запускается -- драйвер не может им управлять, инициализация завершается с исключением...

Причина, вероятно, в том, что с некоторых пор в chromedriver добавлена функция контроля версий -- драйвер отказывается работать с любыми версиями браузера, кроме "официально поддерживаемых". В том числе под раздачу попали Opera, Yandex-браузер и прочие надстройки над Chromium -- драйвер отвергает их как несовместимые.

К счастью, разработчики Opera выпустили альтернативную версию этой вспомогательной утилиты, которая называется, как несложно догадаться, operadriver.*/
        ChromeOptions options = new ChromeOptions();
        options.setBinary("c:\\Program Files (x86)\\Opera\\29.0.1795.60\\opera.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }


}

