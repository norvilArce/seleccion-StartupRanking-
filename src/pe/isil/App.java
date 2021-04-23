package pe.isil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    static WebDriver driver;
    public static void main(String[] args) {
        String baseURL = "https://apprater.net/add/";
        //ruta del archivo chromedriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();    //abrir navegador
        driver.manage().window().maximize();//maximizar
        driver.get(baseURL);            //navegar a la pagina

        //lleno campos de formulario
        sendText("Your Name", "name", "user-submitted-name", "Norvil Arce");
        sendText("Email Address", "css", ".usp-email", "norvil.arce@gmail.com");
        sendText("Product Title", "name", "user-submitted-title", "La increible app de Norvil Arce");
        sendText("Product URL", "xpath", "//*[@id=\"usp_form\"]/div[4]/fieldset/input", "http://www.norvilarce.com");
        sendText("", "css", ".usp-content", "La mejor app que podrás encontrar");
    }

    public static void sendText(String label, String selectorType, String selector, String value) {
        WebElement element=null;

        switch (selectorType) {
            case "css":
                selector = (!label.equals("")) ? selector+">input" : selector+">textarea";
                element = driver.findElement(By.cssSelector(selector));
                break;
            case "name":
                element = driver.findElement(By.name(selector));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(selector));
                break;
        }

        //pintar valor en el formulario
        element.sendKeys(value);

    }
}
