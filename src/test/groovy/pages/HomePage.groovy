package pages

import geb.Page
import io.qameta.allure.Step
import org.openqa.selenium.By

class HomePage extends Page{
    static atCheckWaiting = true
    static at = {
        testFld.isDisplayed()
    }
    static content = {

        testFld { $(By.xpath("//div[@dir='ltr' and text()='Test Page']")) }
        acountFld { $(By.xpath("//div[@id='userNavigationLabel']")) }
        logOutFld { $(By.xpath("//span[text()='Log Out']")) }
    }

  @Step("Logout from Facebook")
    def logout(){

  }
}
