package by.kolodyuk.osgi.springboot;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.osgi.io.OsgiBundleResourcePatternResolver;


@SpringBootApplication
public class SpringBootBundleActivator implements BundleActivator {

    ConfigurableApplicationContext appContext;

    @Override
    public void start(BundleContext bundleContext) {
        // Set context classloader
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        // trick to enable scan: get osgi resource pattern resolver
        OsgiBundleResourcePatternResolver resourceResolver = new OsgiBundleResourcePatternResolver(bundleContext.getBundle());
        // and prvide it to spring application
        appContext = new SpringApplication(resourceResolver, SpringBootBundleActivator.class).run();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        SpringApplication.exit(appContext, () -> 0);
    }
	
	public static void main(String[] args) {
        SpringApplication.run(SpringBootBundleActivator.class);
    }
}

