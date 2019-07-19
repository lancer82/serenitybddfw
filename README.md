#Environment-specific configuration in Serenity BDD
When we write acceptance tests, we often need to run them against different environments. Managing the URLs for each environment by hand can be cumbersome, especially when there are not just web pages, but also REST end points, databases etc to think about. Fortunately, Serenity BDD provides a lot of flexibility in configuring environment-specific options. In this article, we see how it is done.
Configuring page URLs for different environments
Whether you are using Screenplay or classic Serenity Page Objects, the simplest way to open a browser on a given page is to use the @DefaultUrl annotation, shown below:
`@DefaultUrl(""http://myapp.myorg.com"/somepage")`
public void MyAppHomePage extends PageObject {}
You can modify this url at runtime by providing a different base URL in the webdriver.base.url system property. 
For example, if you set `webdriver.base.url` to `"http://staging.myapp.myorg.com"`, the page object in the previous example will open on the URL of “”http://staging.myapp.myorg.com”/somepage”.
Configuring the base url for different environments
You can also configure the `webdriver.base.url` property for different environements in the serenity.conf configuration file. (This feature is available in Serenity 2.0.30 or higher).
```
environments {
    default {
        webdriver.base.url = "http://localhost:8080/myapp"
    }
    dev {
        webdriver.base.url = "http://dev.myapp.myorg.com"
    }
    staging {
        webdriver.base.url = "http://staging.myapp.myorg.com"
    }
    prod {
        webdriver.base.url = "http://myapp.myorg.com"
    }
}
```
If an environments section is present in your serenity.conf file, you can use the environment system property to use the properties for a given environment. For example, mvn verify -Denvironment=staging would cause the staging urls to be used. The default environment will be used if no other value is provided.
Configuring different page URLs for different environments
You may need some pages to use different base URLs even within the same environment. For example, you may need to open a page on a different site or domain.
```conf
environments {
    default {
        webdriver.base.url = "http://localhost:8080/myapp"
        accounts.service.url = "http://localhost:8081"
    }
    dev {
        webdriver.base.url = "http://dev.myapp.myorg.com"
        accounts.service.url = "http://dev.accounts.myorg.com"
    }
    staging {
        webdriver.base.url = "http://staging.myapp.myorg.com"
        accounts.service.url = "http://staging.accounts.myorg.com"
    }
    prod {
        webdriver.base.url = "http://myapp.myorg.com"
        accounts.service.url = "http://accounts.myorg.com"
    }
}
```
You can also add an all section, for URLs that will apply to any environment. These can use properties from the default environment section (or elsewhere in the config file), using the # symbol (the $ symbol, normally used, may conflict with the normal TypeSafe Config variable substitution). An example is shown herre:
```
environments {
    ...
    all {
        home.page = "#{webdriver.base.url}/myapp"
        config.page = "#{webdriver.base.url}/myapp"
        accounts.page = "#{accounts.service.url}/myapp"
    }
}
```
You can then reference a URL in a page object using the “page:” notation:
@DefaultUrl("page:home.page")
public void MyAppHomePage extends PageObject {}
Or, if you are using Screenplay, you can refer to the pages directly by name:
```
actor.attemptsTo(
    Open.thePageNamed("home.page")
)
```
Configuring different parameters for different environments
You can even leverage this feature for your own application code. Suppose your serenity.conf file contains the following configuration:
```
environments {
    default {
        my.webservice.endpoint = "http://localhost:8081"
    }
    dev {
        my.webservice.endpoint = "http://dev.myapp.myorg.com:8081"
    }
    staging {
        my.webservice.endpoint = "http://mywebservice.myapp.myorg.com"
    }
}
```
You can access the corresponding webservice endpoint as follows:
```
String webserviceEndpoint =  EnvironmentSpecificConfiguration.from(environmentVariables)
                                                             .getProperty("my.webservice.endpoint")
```