package net.serenity.bdd.junit.cucumber.stepDef.web;

import org.junit.rules.ErrorCollector;
import java.util.Properties;

/**
 * Created by arun on 25/05/2017.
 */
public class GenericDeclarationClass {

    public static String ConfigPath = System.getProperty("user.dir")+"/config.properties";
    public final ErrorCollector collector = new ErrorCollector();
    public static Properties prop;

}
