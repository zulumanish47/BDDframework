package browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by p902093d on 23/07/2017.
 */

public final class BrowserFactory
{
    private static ThreadLocal<WebDriver> _driver = new ThreadLocal<>();
    private BrowserFactory () {}; // note

    enum BROWSER {
        CHROME("0"),
        MOZILLA("1"),
        EXPLORER("2"),
        SAFARI("3");

        final private String gVal;

        BROWSER(String numVal) {
            this.gVal = numVal;
        }

        public String value() {
            return gVal;
        }
    }

    public static WebDriver getDriver() {
    return _driver.get();
    }

    public static void setDriver(WebDriver driver) {
        _driver.set(driver);
    }


    public static WebDriver getBrowser(String browser, boolean fullscreen) throws Exception
    {

        BrowserInterface browser_;
        Boolean local = true; // TODO : include remote flag in spreadsheet

        browser = browser.toUpperCase();

        if (browser.contains("REMOTE"))
        {
            local = false;
            browser = browser.replace("REMOTE", "");
        }

        switch (BROWSER.valueOf(browser))
        {
            case CHROME:
                browser_ = new BrowserChrome();
                break;

            case MOZILLA:
                browser_ = new BrowserMozilla();
                break;

            case EXPLORER:
                browser_ = new BrowserInternetExplorer();
                break;

            case SAFARI:
                browser_ = new BrowserSafari();
                break;

            default:
                throw new Exception("BROWSER not Found " + browser);

        }
        setDriver(browser_.setupBrowser(local, fullscreen));

        return getDriver();
    }



    public static void quit(){
        _driver.get().quit();
    }
}
