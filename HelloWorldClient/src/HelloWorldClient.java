import org.apache.felix.framework.Felix;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MeinLaptop on 16.05.2016.
 */
public class HelloWorldClient {
    public static void main(String[] args) throws BundleException {
        // Initialize Apache Felix Framework
        Map<String, String> configMap = new HashMap<String, String>();
        configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");
        Felix framework = new Felix(configMap);
        framework.init();

        // Install bundles
        BundleContext context = framework.getBundleContext();
        Bundle provider = context.installBundle("file:out/production/HelloWorldProvider.jar");
        Bundle consumer = context.installBundle("file:out/production/HelloWorldConsumer.jar");

        // Start and stop framework and bundles
        framework.start();
        provider.start();
        consumer.start();
        framework.stop();

        System.out.println("Testende :-)");
    }
}
