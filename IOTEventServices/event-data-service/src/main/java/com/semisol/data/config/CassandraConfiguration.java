package com.semisol.data.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(CassandraConfiguration.class);

	@Autowired
	private Environment environment;

	@Override
	protected String getKeyspaceName() {
		return environment.getProperty("iot.event.cassandra.keyspace");
	}

	@Override
	@Bean
	public CassandraClusterFactoryBean cluster() {
		final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(environment.getProperty("iot.event.cassandra.host"));
		cluster.setPort(Integer.parseInt(environment.getProperty("iot.event.cassandra.port")));
		cluster.setUsername(environment.getProperty("iot.event.cassandra.username"));
		cluster.setPassword(environment.getProperty("iot.event.cassandra.password"));
		LOG.info("Cluster created with contact points [" + environment.getProperty("iot.event.cassandra.host") + "] "
				+ "& port [" + Integer.parseInt(environment.getProperty("iot.event.cassandra.port")) + "].");
		return cluster;
	}

	@Override
	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}
}
