package com.iot.event.cassandra.connection.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.policies.DefaultRetryPolicy;

@Configuration
@PropertySources({ 
	@PropertySource(value = { "classpath:cassandra.common.utils.properties" }),
	@PropertySource(value = {"file:${event.configuration.home}/environment.properties"}, ignoreResourceNotFound = true) }
)
public class CassandraAppConfig {
	
	private static Logger log = LoggerFactory.getLogger(CassandraAppConfig.class);
	
	@Value("${iot.event.cassandra.host}")
	private String cassandraHost;
	
	@Value("${iot.event.cassandra.port}")
	private Integer cassandraPort;
	
	@Value("${iot.event.cassandra.username}")
	private String cassandraUsername;
	
	@Value("${iot.event.cassandra.password}")
	private String cassandraPassword;
	
	private ConsistencyLevel consistencyLevel = ConsistencyLevel.ONE;
	
	private DefaultRetryPolicy defaultRetryPolicy = DefaultRetryPolicy.INSTANCE;
	
	@Bean(name="cluster")
	public Cluster buildClusterBean(){
		log.info("Connecting to host {} and port {}", cassandraHost, cassandraPort);
		Cluster cluster = Cluster.builder().addContactPoints(cassandraHost)
				.withPort(cassandraPort)
				.withCredentials(cassandraUsername, cassandraPassword)
				.withQueryOptions(new QueryOptions().setConsistencyLevel(consistencyLevel))
				.withRetryPolicy(defaultRetryPolicy)
				.build();
		return cluster;
	}
	
	@Bean(name="session")
	public Session buildSession(@Qualifier("cluster")Cluster cluster, @Value("${iot.event.cassandra.keyspace}") String keyspace){
		Session session = cluster.connect(keyspace);
		return session;
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
