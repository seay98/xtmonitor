package xtmon.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import xtmon.domain.AllFiles;

@Repository
public class JdbcFilesDao implements FilesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AllFiles> getAllSyss() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM view_allsysname";
		
		List<AllFiles> list = new ArrayList<AllFiles>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			AllFiles af = new AllFiles();
			af.setSysname((String)row.get("belongto"));
			af.setSysalias((String)row.get("alias"));
			list.add(af);
		}
		
		return list;
	}
	
	public int getCountBySysTime(String sysname, String start, String end) {
		int cnt = 0;
		
		String sql = "SELECT count(*) FROM allfiles WHERE belongto=? AND lmtime BETWEEN ? AND ?";
		
		cnt = this.jdbcTemplate.queryForObject(sql, new Object[]{sysname, start, end}, Integer.class);
		
		return cnt;
	}

	@Override
	public List<AllFiles> getFilesToday() {
		// TODO Auto-generated method stub
		List<AllFiles> list = new ArrayList<AllFiles>();
		try {
			Connection conn = this.jdbcTemplate.getDataSource().getConnection();
			CallableStatement cStmt = conn.prepareCall("{call proc_filestoday()}");
			boolean hadResults = cStmt.execute();
			while (hadResults) {
				ResultSet rs = cStmt.getResultSet();
				
				while(rs.next()) {
					AllFiles af = new AllFiles();
					af.setSysname(rs.getString("belongto"));
					af.setSysalias(rs.getString("alias"));
					af.setCount(rs.getInt("count"));
					af.setLtime((Date)rs.getObject("lmtime"));
					list.add(af);
				}
				
				hadResults = cStmt.getMoreResults();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			
		}
		return list;
	}

	@Override
	public int getCountByTime(String start, String end) {
		// TODO Auto-generated method stub
		int cnt = 0;
		
		String sql = "SELECT count(*) FROM allfiles WHERE lmtime BETWEEN ? AND ?";
		
		cnt = this.jdbcTemplate.queryForObject(sql, new Object[]{start, end}, Integer.class);
		
		return cnt;
	}

}
