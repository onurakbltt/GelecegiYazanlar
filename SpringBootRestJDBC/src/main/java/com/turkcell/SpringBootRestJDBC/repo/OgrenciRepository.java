package com.turkcell.SpringBootRestJDBC.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.turkcell.SpringBootRestJDBC.model.Ogrenci;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class OgrenciRepository {

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Ogrenci> getAll() {
		List<Ogrenci> liste;
		String sql = "SELECT * FROM \"obsh\".\"ogrenci\"";
		RowMapper<Ogrenci> row_mapper = new RowMapper<Ogrenci>() {

			@Override
			public Ogrenci mapRow(ResultSet result, int rowNum) throws SQLException {
				return new Ogrenci(result.getLong(1), result.getString("name"), result.getLong("ogrnumber"),
						result.getLong("year"));
			}
		};
		liste = jdbcTemplate.query(sql, row_mapper);
		return liste;
	}

	public Ogrenci getById(Long id) {
		String sql = "SELECT * FROM \"obsh\".\"ogrenci\" WHERE \"id\" = :ID";
		RowMapper<Ogrenci> row_mapper = new RowMapper<Ogrenci>() {

			@Override
			public Ogrenci mapRow(ResultSet result, int rowNum) throws SQLException {
				return new Ogrenci(result.getLong(1), result.getString("name"), result.getLong("ogrnumber"),
						result.getLong("year"));
			}
		};
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, row_mapper);
	}

	public boolean save(Ogrenci ogrenci) {
		String sql = "INSERT INTO \"obsh\".\"ogrenci\"(\name\",\"ogrnumber\",\"year\") VALUES (:NAME, :OGRNUMBER, :YEAR)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("NAME", ogrenci.getNAME());
		paramMap.put("OGRNUMBER", ogrenci.getOGRNUMBER());
		paramMap.put("YEAR", ogrenci.getYEAR());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
}
