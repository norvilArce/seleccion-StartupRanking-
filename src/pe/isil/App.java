package pe.isil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        //ruta del archivo chromedriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        sendText("Your Name", "xpath", "user-submitted-name", "Lucas Ocampo");
    }

    public static void sendText(String label, String selectorType, String selector, String value) {
        WebDriver driver;
        String baseURL = "https://apprater.net/add/";

        driver = new ChromeDriver();    //abrir navegador
        driver.manage().window().maximize();//maximizar
        driver.get(baseURL);            //navegar a la pagina

        WebElement element = null;

        switch (selectorType) {
            case "css":

                break;
            case "name":

                break;
            case "xpath":

                break;
        }

        //pintar valor en el formulario
        element.sendKeys(value);

    }
}
