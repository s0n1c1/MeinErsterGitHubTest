package org.meinosgibeispiel.provider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Created by MeinLaptop on 16.05.2016.
 */
public class Activator implements BundleActivator {
    public void start(BundleContext bundleContext) throws Exception
    {
        System.out.println("HelloWorldProvider is being started...");
        System.out.println("Registering HelloWorldService...");
        bundleContext.registerService(HelloWorldService.class.getName(),
                new HelloWorldProvider(), null);
    }

    public void stop(BundleContext bundleContext) throws Exception
    {
        System.out.println("HelloWorldProvider is being stopped...");
    }
}
