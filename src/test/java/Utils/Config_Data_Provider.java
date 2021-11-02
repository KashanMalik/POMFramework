package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config_Data_Provider {

    Properties pro;

    /**************** To read value from the config file ****************************/
    public Config_Data_Provider(){
        File src= new File("./Functions/Configuration/config.properties");

        try {
            FileInputStream fis=new FileInputStream(src);
            pro=new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Unable to read data from config file"+e.getMessage());
        }
    }

    /**************** To get value of the browser and url from config file ****************************/
    public String getDataFromConfig(String keytosearch){
        return pro.getProperty(keytosearch);
    }
    public String getBrowser(){
        return pro.getProperty("Browser");
    }
    public String getUrl(){
        return pro.getProperty("Devurl");
    }
}
