package util

import geb.junit4.GebReportingTest
import geb.report.ReportState
import geb.report.ScreenshotReporter
import io.qameta.allure.Attachment
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.AssumptionViolatedException
import org.junit.Rule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot


class BaseTest extends GebReportingTest{
    Logger logger = LogManager.getLogger(BaseTest.class)
    private ScreenshotReporter screenshotReporter = new ScreenshotReporter()

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        private static final String PREFIX = "++TEST++"

        @Override
        protected void starting(Description description) {
            def methodName = description.getMethodName()
            logger.info("{} {} STARTING...", PREFIX, methodName)
        }

        @Override
        protected void failed(Throwable e, Description description) {
            def methodName = description.getMethodName()
            logger.info("{} {} FAILED", PREFIX, methodName)
            takeScreenshot(methodName)
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            def methodName = description.getMethodName()
            logger.info("{} {} SKIPPED: {}", PREFIX, methodName, e.getMessage())
        }

        @Override
        protected void succeeded(Description description) {
            logger.info("{} {} COMPLETED", PREFIX, description.getMethodName())
        }
    }

    void reportScreenshot(String label) {
        ReportState state = new ReportState(browser, effectiveReportLabel(label), browser.getReportGroupDir())
        screenshotReporter.writeReport(state)
    }
    @Attachment(value = "Failure in: {0}", type = "image/png")
    private byte[] takeScreenshot(String methodName) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
