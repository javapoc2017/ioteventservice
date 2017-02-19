package com.semisol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.event.subscriber.AppEventPublisher;
import com.semisol.data.dao.api.IotEventsDAO;
import com.semisol.data.domain.IotEvents;
import com.semisol.iot.dto.IotEventsDTO;
import com.semisol.service.api.SwitchService;

@Service
public class SwitchServiceImpl implements SwitchService {
	
	@Autowired
	private IotEventsDAO iotEventsDAO;
	
	@Autowired
	private AppEventPublisher appEventPublisher;

	@Override
	public boolean updateSwitch(IotEventsDTO iotEventsDTO) {
		
		 try {
			 // appEventPublisher.publishAppEvent(eventMessage);
			  iotEventsDAO.saveEventsInfo(convertDTOtoDAO(iotEventsDTO));
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return false;
	}
	
	private IotEvents convertDTOtoDAO(IotEventsDTO iotEventsDTO){
		IotEvents iotEvents =new IotEvents();
		iotEvents.setAttributes(iotEventsDTO.getAttributes());
		iotEvents.setDevId(iotEventsDTO.getDevId());
		iotEvents.setLoginId(iotEventsDTO.getLoginId());
		iotEvents.setType(iotEventsDTO.getType());
		return iotEvents;
	}

}
