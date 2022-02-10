package utility;

import java.util.Hashtable;

public class environmentUrls {
    Hashtable<String, String> google_urls = new Hashtable<String, String>();

    public environmentUrls(){

    }

    public void initialize_google_environment_urls(){
        google_urls.put("DEV", "https://www.dev.google.com");
        google_urls.put("TEST", "https://www.test.google.com");
        google_urls.put("UAT", "https://www.uat.google.com");
        google_urls.put("PERF", "https://www.perf.google.com");
        google_urls.put("PROD", "https://www.google.com");
    }

    public Hashtable<String, String> get_google_environment_variables(){
        initialize_google_environment_urls();
        return google_urls;
    }
}
