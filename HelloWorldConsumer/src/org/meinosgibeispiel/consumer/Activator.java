package org.meinosgibeispiel.consumer;

import org.meinosgibeispiel.provider.HelloWorldService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by MeinLaptop on 16.05.2016.
 */
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("HelloWorldConsumer bundle is being started...");
        System.out.println("Getting reference of HelloWorld Service...");
        ServiceReference reference = bundleContext.getServiceReference(HelloWorldService.class.getName());
        HelloWorldService helloWorldService = ((HelloWorldService) bundleContext.getService(reference));
        helloWorldService.helloWorld();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("HelloWorldConsumer is being stopped...");
    }
}
