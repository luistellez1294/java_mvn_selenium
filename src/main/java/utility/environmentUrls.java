package utility;

import java.util.Hashtable;

public class environmentUrls {
    Hashtable<String, String> google_urls = new Hashtable<String, String>();

    public environmentUrls(){

    }

    public void initialize_environment_urls(){
        google_urls.put("DEV", "http://www.dev.automationpractice.com/index.php");
        google_urls.put("TEST", "http://www.test.automationpractice.com/index.php");
        google_urls.put("UAT", "http://www.uat.automationpractice.com/index.php");
        google_urls.put("PERF", "http://www.perf.automationpractice.com/index.php");
        google_urls.put("PROD", "http://automationpractice.com/index.php");
    }

    public Hashtable<String, String> get_environment_variables(){
        initialize_environment_urls();
        return google_urls;
    }
}
