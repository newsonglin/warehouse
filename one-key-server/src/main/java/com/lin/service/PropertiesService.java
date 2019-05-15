package com.lin.service;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This file was created by Songlin Li on 2015/11/18.
 * It is used for
 */
public class PropertiesService {
    private static Logger log = Logger.getLogger(PropertiesService.class);

    private static PropertiesService ourInstance = new PropertiesService();

    private static Properties properties = new Properties();
    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");

    static{
        try {
            properties.load(PropertiesService.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

    public static PropertiesService getInstance() {
        return ourInstance;
    }

    private PropertiesService() {
    }


    public static String get(String key) {
        String value = properties.getProperty(key);
        Matcher matcher = PATTERN.matcher(value);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String matcherKey = matcher.group(1);
            String matchervalue = properties.getProperty(matcherKey);
            if (matchervalue != null) {
                matcher.appendReplacement(buffer, matchervalue);
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
