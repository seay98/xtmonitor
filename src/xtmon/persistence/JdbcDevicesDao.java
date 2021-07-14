package xtmon.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xtmon.domain.Device;

@Repository
public class JdbcDevicesDao implements DevicesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Device> getSysDevices(int sysid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM view_devicedetail WHERE belongto=? ORDER BY devicename";
		
		List<Device> list = new ArrayList<Device>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql, new Object[]{sysid});
		for (Map<String, Object> row : rows) {
			Device d = new Device();
			d.setId((int)row.get("iddevices"));
			d.setName((String)row.get("devicename"));
			d.setIp((String)row.get("ipaddr"));
			d.setIdent((String)row.get("ident"));
			d.setLocation((String)row.get("location"));
			d.setSwitcher((String)row.get("switcher"));
			d.setType((String)row.get("devicetype"));
			d.setLmtime((Date)row.get("lmtime"));
			d.setSavetime((Date)row.get("savetime"));
			d.setState((int)row.get("state"));
			d.setStatusid((int)row.get("statusid"));
			d.setSysname((String)row.get("sysname"));
			String status = (String)row.get("status");
			if (status != null) {
				status = status.replaceAll("<", "[");
				status = status.replaceAll(">", "]");
				status = status.replaceAll("\"", "");
				status = status.replaceAll("\\\\", "/");
				status = status.replaceAll(":", "-");
				status = status.replaceAll("\r", "");
			}
			//System.out.println(status);
			d.setStatus(status);
			String alarm = (String)row.get("alarminfo");
			if (alarm != null) {
				alarm = alarm.replaceAll("<", "[");
				alarm = alarm.replaceAll(">", "]");
				alarm = alarm.replaceAll("\"", "");
				alarm = alarm.replaceAll("\\\\", "/");
				alarm = alarm.replaceAll(":", "-");
				alarm = alarm.replaceAll("\r", "");
			}
			d.setAlarm(alarm);
			list.add(d);
		}
		return list;
	}

}
