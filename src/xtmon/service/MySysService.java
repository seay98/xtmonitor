package xtmon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtmon.domain.MySys;
import xtmon.persistence.MySysDao;

@Service
public class MySysService {
	
	@Autowired
	private MySysDao sysDao;
	
	public List<MySys> getSysList() {
		List<MySys> list = this.sysDao.getAllSystems();
		return list;
	}

}
