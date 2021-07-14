package xtmon.persistence;

import java.util.List;

import xtmon.domain.Device;

public interface DevicesDao {

	public List<Device> getSysDevices(int sysid);
}
