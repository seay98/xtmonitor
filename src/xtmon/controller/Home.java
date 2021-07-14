package xtmon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping({"/"})
	public String showHomePage() {
		return "redirect:mysys/syslist";
	}

	@RequestMapping({"/filestatus"})
	public String showFilesPage() {
		return "redirect:files/status";
	}

	@RequestMapping({"/devicestatus"})
	public String showDevicesPage() {
		return "redirect:devices/status";
	}
}
