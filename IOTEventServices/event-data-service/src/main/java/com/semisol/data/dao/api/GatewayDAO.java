package com.semisol.data.dao.api;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;

import com.semisol.data.domain.Gateway;

@Configuration
public interface GatewayDAO {

	boolean addGatewayInfo(Gateway gateway);

	boolean updateGatewayInfo(Gateway gateway);

	boolean deleteGatewayInfo(Gateway gateway);

	List<Gateway> getAllGateways();

	Gateway findByGatewayById(UUID gatewayId);

}
