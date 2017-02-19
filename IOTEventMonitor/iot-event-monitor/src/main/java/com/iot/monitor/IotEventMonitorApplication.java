package com.iot.monitor;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "com.semisol.data,com.iot.event.subscriber,com.semisol.rest,com.semisol.service")
public class IotEventMonitorApplication extends SpringBootServletInitializer implements
		EmbeddedServletContainerCustomizer, ApplicationListener<ApplicationEnvironmentPreparedEvent>, Ordered {

	public static void main(String[] args) {
		SpringApplication.run(IotEventMonitorApplication.class, args);
	}

	@Override
	public int getOrder() {
		return ConfigFileApplicationListener.DEFAULT_ORDER - 2;
	}

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment env = event.getEnvironment();
		 registerExternalPropertySource(env,"classpath:cassandra-data-service.properties");
		 registerExternalPropertySource(env,"classpath:event.subscriber.properties");
		 //registerExternalPropertySource(env,"file:///d:/IOT/environment.properties");
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setRegisterDefaultServlet(true);
	}

	private void registerExternalPropertySource(ConfigurableEnvironment env, String externalPropertyPath) {
		try {
			String location = env.resolvePlaceholders(externalPropertyPath);
			ResourcePropertySource propertySource = new ResourcePropertySource(location);
			env.getPropertySources().addAfter("systemProperties", propertySource);
		} catch (IOException e) {
			logger.warn(externalPropertyPath + " not found", e);
		}
	}
}
