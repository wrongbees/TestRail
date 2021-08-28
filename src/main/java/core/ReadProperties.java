package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static ReadProperties currentReadProperty;
    protected Properties properties;


    private ReadProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ReadProperties getInstance(){
        if (currentReadProperty == null){return new ReadProperties();}
        return currentReadProperty;
    }


    public String getURL() { return properties.getProperty("url");}
    public String getDownloadDir() { return properties.getProperty("download.dir");}
    public String getBrowser() { return properties.getProperty("browser");}
    public String getUsername() { return properties.getProperty("username");}
    public String getPassword() { return properties.getProperty("password");}
    public int getTimeout() { return Integer.parseInt(properties.getProperty("timeout"));}
    public boolean getHeadless() {return Boolean.parseBoolean(properties.getProperty("headless"));}
}
