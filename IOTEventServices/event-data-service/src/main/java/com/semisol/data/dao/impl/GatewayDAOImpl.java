package com.semisol.data.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.semisol.data.dao.api.GatewayDAO;
import com.semisol.data.domain.Gateway;
import com.semisol.data.repository.GatewayRepository;

@Configuration
public class GatewayDAOImpl implements GatewayDAO {

	@Autowired
	private GatewayRepository gatewayRepository;

	@Override
	public boolean addGatewayInfo(Gateway gateway) {
		try {
			gatewayRepository.save(gateway);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}

	@Override
	public boolean updateGatewayInfo(Gateway gateway) {
		try {
			//gatewayRepository.update(gateway);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	/*
	TODO : need to check before delete
	*/
	@Override
	public boolean deleteGatewayInfo(Gateway gateway) {
		try {
			gatewayRepository.delete(gateway);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Gateway> getAllGateways() {
		return (List<Gateway>) gatewayRepository.findAll();
	}

	@Override
	public Gateway findByGatewayById(UUID gId) {
		return gatewayRepository.findByGId(gId);
	}

}
