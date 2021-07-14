package xtmon.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xtmon.domain.AllFiles;
import xtmon.persistence.FilesDao;

@Service
public class FilesService {
	
	@Autowired
	private FilesDao filesDao;
	
	public List<AllFiles> getFilesOfToday() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		Calendar start = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
		//System.out.println(df.format(start.getTime()));
		Calendar end = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)+1);
		
		List<AllFiles> list = this.filesDao.getAllSyss();
		for (AllFiles af : list) {
			af.setCount(this.filesDao.getCountBySysTime(af.getSysname(), df.format(start.getTime()), df.format(end.getTime())));
		}
		//System.out.println(list.size());
		return list;
	}
	
	public String getAllCount() {
		StringBuffer sb = new StringBuffer(768);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar now = Calendar.getInstance();
		Calendar start = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
		Calendar lstart = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
		lstart.add(Calendar.DAY_OF_YEAR, -7);
		
		sb.append("0,0,0");
		for (int i=0; i<24; i++) {
			Calendar end = new GregorianCalendar(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DAY_OF_MONTH), start.get(Calendar.HOUR_OF_DAY)+i, start.get(Calendar.MINUTE));
			int cnt = this.filesDao.getCountByTime(df.format(start.getTime()), df.format(end.getTime()));
			
			Calendar lend = new GregorianCalendar(lstart.get(Calendar.YEAR), lstart.get(Calendar.MONTH), lstart.get(Calendar.DAY_OF_MONTH), lstart.get(Calendar.HOUR_OF_DAY)+i, lstart.get(Calendar.MINUTE));
			//System.out.println(df.format(lend.getTime()));
			int lcnt = this.filesDao.getCountByTime(df.format(lstart.getTime()), df.format(lend.getTime()));
			
			sb.append("\n" + (i+1) + "," + cnt + "," + lcnt);
		}
		
		return sb.toString();
	}
	
	public List<AllFiles> getFilesToday() {
		List<AllFiles> list = this.filesDao.getFilesToday();
		return list;
	}
	
	public List<AllFiles> getFilesGrid() {
		List<AllFiles> list = this.filesDao.getFilesToday();
		for (AllFiles af : list) {
			long span = ((new Date()).getTime() - af.getLtime().getTime())/(1000*60);
			af.setSpan(span);
		}
		return list;
	}

}
