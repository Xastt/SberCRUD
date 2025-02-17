package xast.sbertasks.SberCRUD;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SberCrudApplicationTests {

	@Test
	public void test1() {
		System.setProperty("webdriver.edge.driver", "D:\\Downloads\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://localhost:7070/person");

		assertEquals("CRUD App", driver.getTitle());
	}

	@Test
	public void test2() {
		System.setProperty("webdriver.edge.driver", "D:\\Downloads\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://localhost:7070/person/new");

		WebElement surnameField = driver.findElement(By.id("surname"));
		WebElement nameField = driver.findElement(By.id("name"));
		WebElement ageField = driver.findElement(By.id("age"));

		System.out.println("Surname field: " + surnameField.getAttribute("value"));
		System.out.println("Name field: " + nameField.getAttribute("value"));
		System.out.println("Age field: " + ageField.getAttribute("value"));

		assertEquals("Ivanov", surnameField.getAttribute("value"));
		assertEquals("Ivan", nameField.getAttribute("value"));
	}

}
