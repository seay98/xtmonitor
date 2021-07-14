package xtmon.persistence;

import java.util.List;

import xtmon.domain.AllFiles;

public interface FilesDao {
	
	public List<AllFiles> getAllSyss();
	
	public int getCountBySysTime(String sysname, String start, String end);

	public int getCountByTime(String start, String end);
	
	public List<AllFiles> getFilesToday();

}
