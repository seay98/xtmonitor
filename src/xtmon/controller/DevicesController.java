package xtmon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xtmon.service.DevicesService;

@Controller
@RequestMapping("/devices")
public class DevicesController {
	
	@Autowired
	private DevicesService devicesService;

	@RequestMapping({"status/{sysid}"})
	public String getFilesStatus(Map<String, Object>model, @PathVariable("sysid") String sysid) {
		model.put("sysid", sysid);
		return "devices";
	}

	@RequestMapping({"sysdevices/{sysid}"})
	public String getFilesToday(Map<String, Object>model, @PathVariable("sysid") int sysid) {
		model.put("sysdevices", this.devicesService.getSysDevices(sysid));
		return "data/sysdevices";
	}

}
