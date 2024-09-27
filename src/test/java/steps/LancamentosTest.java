package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class LancamentosTest {

	ChromeOptions option = new ChromeOptions();
	WebDriver driver;
	WebDriverWait wait;

	@Dado("que eu acesse o site")
	public void que_eu_acesse_o_site() {
		option.addArguments("--start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://www.mcdonalds.com.br/");
	}

	@Dado("clique no menu cardápio")
	public void clique_no_menu_cardápio() {
		By menuCardapio = By.xpath("(//a[@href='/cardapio'])[1]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuCardapio));
		driver.findElement(menuCardapio).click();

	}

	@Quando("eu clico no menu lançamentos")
	public void eu_clico_no_menu_lançamentos() {
		By menuLancamentos = By.xpath("//div[@id='categoriesMenu']//a[@href='/cardapio/lancamentos']");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuLancamentos));
		driver.findElement(menuLancamentos).click();

	}

	@Então("vejo os lançamentos")
	public void vejo_os_lançamentos() {
		By lancamentos = By.xpath("//div[@class='column is-narrow']//a");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lancamentos));

		// Encontra todos os elementos do menu
		List<WebElement> menus = driver.findElements(lancamentos);

		List<String> lancamentosEsperados = List.of("Casquinha Super Chocolate",
				"McFlurry Choco&Cream Kopenhagen Chocolate", "McFlurry Choco&Cream Kopenhagen Caramelo",
				"McFlurry Choco&Cream Kopenhagen Morango", "McShake Caramelo com Farofa Crocante de Amendoim");

		for (int i = 0; i < menus.size(); i++) {
			String menuText = menus.get(i).getText();
			System.out.println("Menu encontrado " + menuText);

			assertEquals(lancamentosEsperados.get(i), menuText);
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenShot, new File("./evidencias/screen.png"));
			} catch (IOException e) {

				e.printStackTrace();
			}

			driver.quit();
		}

	}

}
