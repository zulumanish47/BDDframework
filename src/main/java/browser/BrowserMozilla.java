package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by p902093d on 22/07/2017.
 */
public class BrowserMozilla implements BrowserInterface
{
    public WebDriver setupBrowser(boolean local, boolean fullscreen) throws Exception
    {
        WebDriver driver_=null;

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Users\\manish meera\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        options.setLogLevel(FirefoxDriverLogLevel.fromLevel(Level.OFF));


//        options.setPlatformName("Windows 10");
//        options.setBrowserVersion("92");
//        Map<String, Object> cloudOptions = new HashMap<>();
//        cloudOptions.put("build", myTestBuild);
//        cloudOptions.put("name", myTestName);
//        browserOptions.setCapability("cloud:options", cloudOptions);
     //   WebDriver driver = new RemoteWebDriver(new URL(cloudUrl), browserOptions)

        if (local)
        {
            try
            {
                driver_ = new FirefoxDriver(options);

                if (fullscreen)
                    driver_.manage().window().maximize();
            }
            catch (Exception e)
            {
                e.printStackTrace();
                throw e;
            }
        }
        else
        {

        }

        return driver_;
    }
}