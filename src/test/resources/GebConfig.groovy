import geb.report.CompositeReporter
import geb.report.PageSourceReporter
import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import geb.report.ScreenshotReporter
import org.openqa.selenium.Dimension
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType

atCheckWaiting = true
autoClearCookies = true
//baseUrl = "https://192.168.50.100/"
baseUrl = "https://www.facebook.com/"
reportsDir = new File("target/geb-reports")
reportOnTestFailureOnly = true
reporter = new CompositeReporter(new PageSourceReporter(), new ScreenshotReporter())

reportingListener = new ReportingListener() {
    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
        reportFiles.each {
            println "[[ATTACHMENT|$it.absolutePath]]"  //used for reporting in jenkins
        }
    }
}

String os = System.properties["os.name"].toLowerCase()
String arch = System.properties["os.arch"].toLowerCase()
boolean is64bit = false
if (System.getProperty("os.name").contains("Windows")) {
    is64bit = (System.getenv("ProgramFiles(x86)") != null)
} else {
    is64bit = (System.getProperty("os.arch").indexOf("64") != -1)
}
String DRIVERS_FOLDER = System.getProperty("driversFolder")
//DRIVERS_FOLDER = System.getProperty("driversFolder")

if (!DRIVERS_FOLDER) {
    //DRIVERS_FOLDER = "drivers/"
    DRIVERS_FOLDER = "drivers"
}

System.setProperty("driversFolder",DRIVERS_FOLDER)

//WebDriverManager.chromedriver().setup()
//driver = { new ChromeDriver() }


// zakomentarisan je ceo deo za sve sisteme i browser-e
/*
environments {
    "chrome" {
        driver = {
            if (os.contains("windows")) {
                System.setProperty("webdriver.chrome.driver", DRIVERS_FOLDER + "/chromedriver-windows-32bit.exe")
                //System.setProperty("webdriver.chrome.driver","drivers//chromedriver-windows-32bit.exe")
            } else if (os.contains("linux")) {
                System.setProperty("webdriver.chrome.driver", DRIVERS_FOLDER + "/chromedriver-linux-64bit")
                //System.setProperty("webdriver.chrome.driver","drivers//chromedriver-linux-64bit")
            } else if (os.contains("mac")) {
                System.setProperty("webdriver.chrome.driver", DRIVERS_FOLDER + "/chromedriver-mac-64bit")
                //System.setProperty("webdriver.chrome.driver","drivers//chromedriver-mac-64bit")
            }

            */
/*ChromeOptions options = new ChromeOptions()
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)

            // prevent "timed out receiving message from renderer"
            options.addArguments("--disable-gpu")

            if (Boolean.valueOf(System.getProperty("headless"))) {
                options.addArguments("--headless")
            }
            ChromeDriverService driverService = ChromeDriverService.createDefaultService()
            new ChromeDriver(driverService, options)*//*


            ChromeOptions options = new ChromeOptions()
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)

            // prevent "timed out receiving message from renderer"
            options.addArguments("--disable-gpu")

            if (Boolean.valueOf(System.getProperty("headless"))) {
                options.addArguments("--headless")
            }

            ChromeDriverService driverService = ChromeDriverService.createDefaultService()
            def drv = new ChromeDriver(driverService, options)
            makeAndExecuteChromeDriverRequest(driverService, drv)

            drv.manage().window().setSize(new Dimension(1200, 1600))

            return drv



            //new ChromeDriver()
        }
    }
   "firefox" {
        driver = {
            if (os.contains("windows")) {
                System.setProperty("webdriver.gecko.driver", DRIVERS_FOLDER + "/geckodriver-windows-32bit.exe")
                */
/*if(is64bit){
                    System.setProperty("webdriver.gecko.driver", "drivers//geckodriver-windows-64bit.exe")
                } else{
                    System.setProperty("webdriver.gecko.driver", "drivers//geckodriver-windows-32bit.exe")
                }*//*

           */
/* } else if (arch.contains("arm")) {
                //System.setProperty("webdriver.gecko.driver", DRIVERS_FOLDER + "/geckodriver-arm7hf")
                System.setProperty("webdriver.gecko.driver","drivers//geckodriver-arm7hf")*//*

            }
            else if (os.contains("linux")) {
                //System.setProperty("webdriver.gecko.driver", DRIVERS_FOLDER + "/geckodriver-linux-64bit")
                System.setProperty("webdriver.gecko.driver","drivers//geckodriver-linux-64bit")
            } else if (os.contains("mac")) {
                //System.setProperty("webdriver.gecko.driver", DRIVERS_FOLDER + "/geckodriver-mac-64bit")
                System.setProperty("webdriver.gecko.driver","drivers//geckodriver-mac-64bit")
            }
            FirefoxOptions options = new FirefoxOptions();

            if (Boolean.valueOf(System.getProperty("headless"))) {
                options.setHeadless(true);
            }
            new FirefoxDriver()
            //new FirefoxDriver(options)

        }
        WebDriverManager.firefoxdriver().setup()
        //driver = { new FirefoxDriver() }
    }

}
*/

driver = {
    System.setProperty('webdriver.chrome.driver', 'drivers//chromedriver-windows-32bit.exe')
    new ChromeDriver()
}
waiting {
    timeout = 10
    retryInterval = 0.5
}

