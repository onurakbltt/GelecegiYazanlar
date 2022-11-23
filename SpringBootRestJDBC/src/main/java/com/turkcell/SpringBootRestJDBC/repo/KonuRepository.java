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

import com.turkcell.SpringBootRestJDBC.model.Konu;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class KonuRepository {

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Konu> getAll() {
		List<Konu> liste;
		String sql = "SELECT * FROM \"obsh\".\"konu\"";
		RowMapper<Konu> row_mapper = new RowMapper<Konu>() {

			@Override
			public Konu mapRow(ResultSet result, int rowNum) throws SQLException {
				return new Konu(result.getLong(1), result.getString("name"));
			}
		};
		liste = jdbcTemplate.query(sql, row_mapper);
		return liste;
	}

	public Konu getById(Long id) {
		String sql = "SELECT * FROM \"obsh\".\"konu\" WHERE \"id\" = :ID";
		RowMapper<Konu> row_mapper = new RowMapper<Konu>() {

			@Override
			public Konu mapRow(ResultSet result, int rowNum) throws SQLException {
				return new Konu(result.getLong(1), result.getString("name"));
			}
		};
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, row_mapper);
	}

	public boolean save(Konu konu) {
		String sql = "INSERT INTO \"obsh\".\"konu\"(\name\") VALUES (:NAME)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("NAME", konu.getNAME());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
}
