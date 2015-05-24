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
        * ���, �������� �� ��, ��� ������� ����������� -- ������� �� ����� �� ���������, ������������� ����������� � �����������...

�������, ��������, � ���, ��� � ��������� ��� � chromedriver ��������� ������� �������� ������ -- ������� ������������ �������� � ������ �������� ��������, ����� "���������� ��������������". � ��� ����� ��� ������� ������ Opera, Yandex-������� � ������ ���������� ��� Chromium -- ������� ��������� �� ��� �������������.

� �������, ������������ Opera ��������� �������������� ������ ���� ��������������� �������, ������� ����������, ��� �������� ����������, operadriver.*/
        ChromeOptions options = new ChromeOptions();
        options.setBinary("c:\\Program Files (x86)\\Opera\\29.0.1795.60\\opera.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("http://selenium2.ru/");
        driver.quit();
    }


}

