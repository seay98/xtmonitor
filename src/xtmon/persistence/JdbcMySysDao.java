package xtmon.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xtmon.domain.MySys;

@Repository
public class JdbcMySysDao implements MySysDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MySys> getAllSystems() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM systems ORDER BY sgroup;";
		
		List<MySys> list = new ArrayList<MySys>();
		List<Map<String,Object>> rows = this.jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			MySys sys = new MySys();
			sys.setId((int)row.get("idsystems"));
			sys.setName((String)row.get("sysname"));
			sys.setAlias((String)row.get("sysalias"));
			sys.setState((int)row.get("state"));
			sys.setStatetime((Date)row.get("statetime"));
			list.add(sys);
		}
		
		return list;
	}

}
