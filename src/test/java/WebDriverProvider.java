import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverProvider {

    public static WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

}