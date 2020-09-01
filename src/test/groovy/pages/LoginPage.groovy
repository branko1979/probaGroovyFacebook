package pages

import geb.Page
import io.qameta.allure.Step
import org.openqa.selenium.By

class LoginPage extends Page{
    static atCheckWaiting = true

    static at = {
        emailFld.isDisplayed()
    }
    static content = {

        emailFld { $(By.xpath("//input[@id='email']")) }
        passwordFld { $(By.xpath("//input[@id='pass']")) }
        loginBtn { $(By.xpath("//input[@value='Log In'] | //button[@name='login']")) }
    }

    @Step("Set email: {email} and password:{")
    def set_email_and_password( String email, String password) {
        //emailFld = email
        //passwordFld=password
        emailFld << email
        passwordFld << password
        loginBtn.click()
    }
}
