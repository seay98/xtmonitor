package xtmon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xtmon.service.MySysService;

@Controller
@RequestMapping("/mysys")
public class MySysController {
	
	@Autowired
	private MySysService sysService;
	
	@RequestMapping({"syslist"})
	public String getAllSyss(Map<String, Object>model) {
		model.put("syss", this.sysService.getSysList());
		return "systems";
	}
	
	@RequestMapping({"sysstatus"})
	public String getSysStatus(Map<String, Object>model) {
		model.put("syss", this.sysService.getSysList());
		return "data/sysstatus";
	}
}
