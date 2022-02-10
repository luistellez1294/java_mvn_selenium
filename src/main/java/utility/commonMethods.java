package utility;

import java.util.Hashtable;

public class commonMethods{
    public commonMethods(){

    }

    public String getFromDictionary(Hashtable<String, String> dictionary, String key){
        return dictionary.get(key);
    }
}
