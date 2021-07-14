package xtmon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xtmon.service.FilesService;

@Controller
@RequestMapping("/files")
public class FilesController {
	
	@Autowired
	private FilesService filesService;

	@RequestMapping({"status"})
	public String getFilesStatus(Map<String, Object>model) {
		
		return "files";
	}
	
	@RequestMapping({"filestoday"})
	public String getFilesToday(Map<String, Object>model) {
		model.put("filestoday", this.filesService.getFilesToday());
		return "data/allfilesstatus";
	}
	
	@RequestMapping({"filesgrid"})
	public String getFilesGrid(Map<String, Object>model) {
		model.put("filestoday", this.filesService.getFilesGrid());
		return "data/allfilesgrid";
	}

	@RequestMapping({"filesallcount"})
	public String getAllFilesCount(Map<String, Object>model) {
		model.put("files", this.filesService.getAllCount());
		return "data/filesallcount";
	}
}
