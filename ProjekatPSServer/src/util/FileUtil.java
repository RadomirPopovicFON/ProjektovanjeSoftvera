/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Radomir
 */
public class FileUtil {
    
    private Properties properties;
    private static FileUtil instance;

    private FileUtil() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("podesavanja.properties"));
    }
    
    public static FileUtil getInstance() throws IOException {
        if (instance == null) {
            instance = new FileUtil();
        }
        return instance;
    }
    
    public String get(String key) {
        return properties.getProperty(key, "");
    }
}
