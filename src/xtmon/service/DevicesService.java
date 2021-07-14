package xtmon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtmon.domain.Device;
import xtmon.persistence.DevicesDao;

@Service
public class DevicesService {
	
	@Autowired
	private DevicesDao devicesDao;
	
	public List<Device> getSysDevices(int sysid) {
		List<Device> list = this.devicesDao.getSysDevices(sysid);
		return list;
	}

}
