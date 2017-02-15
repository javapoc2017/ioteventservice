package com.semisol.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySources({ 
	@PropertySource(value = { "classpath:cassandra-data-service.properties" }),
	@PropertySource(value = {"file:${event.configuration.home}/environment.properties"}, ignoreResourceNotFound = true) }
)
@EnableCassandraRepositories(basePackages = { "com.semisol.data" })
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    private static final Logger LOG =  LoggerFactory.getLogger(CassandraConfiguration.class);

    @Value("${iot.event.cassandra.host}")
	private String cassandraHost;
	
	@Value("${iot.event.cassandra.port}")
	private Integer cassandraPort;
	
	@Value("${iot.event.cassandra.username}")
	private String cassandraUsername;
	
	@Value("${iot.event.cassandra.password}")
	private String cassandraPassword;
	
	@Value("${iot.event.cassandra.keyspace}")
	private String cassandraKeyspace;


    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(cassandraHost);
        cluster.setPort(cassandraPort);
        cluster.setUsername(cassandraUsername);
        cluster.setPassword(cassandraPassword);
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {
        return cassandraKeyspace;
    }

    @Bean
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
	
	public String getCassandraHost() {
		return cassandraHost;
	}
 	public void setCassandraHost(String cassandraHost) {
		this.cassandraHost = cassandraHost;
	}
 	public Integer getCassandraPort() {
		return cassandraPort;
	}
 	public void setCassandraPort(Integer cassandraPort) {
		this.cassandraPort = cassandraPort;
	}
 	public String getCassandraUsername() {
		return cassandraUsername;
	}
 	public void setCassandraUsername(String cassandraUsername) {
		this.cassandraUsername = cassandraUsername;
	}
 	public String getCassandraPassword() {
		return cassandraPassword;
	}
 	public void setCassandraPassword(String cassandraPassword) {
		this.cassandraPassword = cassandraPassword;
	}
}
