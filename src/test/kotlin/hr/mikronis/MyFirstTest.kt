package hr.mikronis


import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test




class MyFirstTest {

    private var driver: WebDriver? = null

    @BeforeTest
    fun createDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/kotlin/hr/mikronis/drivers/chromedriver.exe")
        driver = ChromeDriver()
        driver.apply { this!!.manage().window().maximize()
            }

    }
    @AfterTest
    fun tearDownDriver(){
        driver!!.quit()
    }


    @Test
    fun testOpenWebPageAndHeaderDisplayed(){
        val url = "https://www.mikronis.hr/"
        driver!!.get(url)
        Assert.assertEquals(driver!!.currentUrl, url, "Web page url did not match expected value.")
        val headerElementSelector = "#header"
        val headerElement:WebElement = driver!!.findElement(By.cssSelector(headerElementSelector))
        Assert.assertTrue(headerElement.isDisplayed, "There is no header element")
    }

    @Test
    fun testSearchBoxFindsItem(){
        val item = "Acer"
        val url = "https://www.mikronis.hr/"
        driver!!.get(url)
        val searchBoxElementSelector = "#searchinp"
        val searchBoxElement:WebElement = driver!!.findElement(By.cssSelector(searchBoxElementSelector))

        val searchButtonElementSelector = "#searchbtn"
        val searchButtonElement: WebElement = driver!!.findElement(By.cssSelector(searchButtonElementSelector))

        searchBoxElement.sendKeys(item)
        searchButtonElement.click()
        Assert.assertTrue(driver!!.currentUrl.endsWith(item), "Url doesn't end with item name")
    }

    @Test
    fun testChangeCategories(){
        val url = "https://www.mikronis.hr/"
        driver!!.get(url)
        val GamingElementSelector = "#page_top > div.home-categories > div.container.clearfix > a:nth-child(1) > span.cat-title"
        val GamingElement:WebElement = driver!!.findElement(By.cssSelector(GamingElementSelector))
        GamingElement.click()
        driver!!.get(url)
        val SmartPhoneElementSelector = "#page_top > div.home-categories > div.container.clearfix > a:nth-child(2) > span.cat-title"
        val SmartPhoneElement:WebElement = driver!!.findElement(By.cssSelector(SmartPhoneElementSelector))

        WebDriverWait(driver, 2).until { ExpectedConditions.elementToBeClickable(SmartPhoneElement) }
        SmartPhoneElement.click()
    }

    @Test
    fun testSubscribeOnOffers(){
        val url = "https://www.mikronis.hr/"
        val email = "borasmarko07@gmail.com"
        val name = "Marko"
        driver!!.get(url)
        val emailBoxElementSelector = "#user_email"
        val emailBoxElement:WebElement = driver!!.findElement(By.cssSelector(emailBoxElementSelector))
        val nameBoxElementSelector = "#user_name"
        val nameBoxElement:WebElement = driver!!.findElement(By.cssSelector(nameBoxElementSelector))
        val sendButtonElementSelector = "#page_top > div.section.newsletter-signup > div > div > div.newsletter-signup-content > form > ul > li.nl-button > input"
        val sendButtonElement: WebElement = driver!!.findElement(By.cssSelector(sendButtonElementSelector))

        emailBoxElement.sendKeys(email)
        nameBoxElement.sendKeys(name)
        sendButtonElement.click()

    }

    @Test
    fun testLogin(){
        val url = "https://www.mikronis.hr/"
        val email = "borasmarko07@gmail.com"
        val password = "123456"
        driver!!.get(url)
        val loginElementHomePageSelector = "#header > div.container.clearfix > ul > li:nth-child(5) > a"
        val loginElementHP:WebElement = driver!!.findElement(By.cssSelector(loginElementHomePageSelector))
        loginElementHP.click()

        val emailBoxElementSelector = "#email"
        val emailBoxElement:WebElement = driver!!.findElement(By.cssSelector(emailBoxElementSelector))
        WebDriverWait(driver, 2).until { ExpectedConditions.elementToBeClickable(emailBoxElement) }
        emailBoxElement.sendKeys(email)
        val passwordBoxElementSelector = "#password"
        val passwordBoxElement:WebElement = driver!!.findElement(By.cssSelector(passwordBoxElementSelector))
        WebDriverWait(driver, 2).until { ExpectedConditions.elementToBeClickable(passwordBoxElement) }
        passwordBoxElement.sendKeys(password)
        val loginElementLSelector = "#loginform > div.btn-holder > button"
        val loginElementl:WebElement = driver!!.findElement(By.cssSelector(loginElementLSelector))
        loginElementl.click()
    }


}