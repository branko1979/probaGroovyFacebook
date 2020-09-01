import org.junit.Test
import pages.LoginPage
import util.BaseTest

class LoginTest extends BaseTest{
    @Test
    void test001_login_facebook(){
        //def "Open Facebook and login"() {
        //    when:
        to LoginPage
        set_email_and_password("testerkotesterovic001@gmail.com ","cpAdmin01")

        }


}
