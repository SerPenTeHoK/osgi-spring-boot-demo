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

import org.springframework.osgi.io.OsgiBundleResourceLoader;
import org.springframework.osgi.io.OsgiBundleResourcePatternResolver;
//import org.eclipse.core.runtime.FileLocator; 


/*
@EnableAutoConfiguration
@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
*/
//@Configuration
//@ComponentScan("classpath*:by.kolodyuk.osgi.springboot.controller")
//@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootBundleActivator implements BundleActivator {

    ConfigurableApplicationContext appContext;

    @Override
    public void start(BundleContext bundleContext) {
		System.out.println("2. Start started");
		/*try {
			java.net.URL url = new java.net.URL("/"); 
			String realPath = FileLocator.toFileURL(url).getPath(); 
			System.out.println("path: " + realPath);
		} catch (Throwable e){
			System.out.println("e: " + e.getMessage());
		}*/
		
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		OsgiBundleResourcePatternResolver rl = new OsgiBundleResourcePatternResolver(bundleContext.getBundle());
        appContext = new SpringApplication(rl, SpringBootBundleActivator.class).run();
		System.out.println("2. Start finished");
    }

    @Override
    public void stop(BundleContext bundleContext) {
        SpringApplication.exit(appContext, () -> 0);
    }
	
	public static void main(String[] args) {
        SpringApplication.run(SpringBootBundleActivator.class);
    }
}

