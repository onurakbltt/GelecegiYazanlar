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

import com.turkcell.SpringBootRestJDBC.model.DersOgrenci;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class DersOgrenciRepository {
	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<DersOgrenci> getAll() {
		List<DersOgrenci> liste;
		String sql = "SELECT * FROM \"obsh\".\"ders_ogrenci\"";
		RowMapper<DersOgrenci> row_mapper = new RowMapper<DersOgrenci>() {

			@Override
			public DersOgrenci mapRow(ResultSet result, int rowNum) throws SQLException {
				return new DersOgrenci(result.getLong(1), result.getInt("devamsizlik"), result.getLong("note"),
						result.getLong("ders_id"), result.getLong("ogrenci_id"));
			}
		};
		liste = jdbcTemplate.query(sql, row_mapper);
		return liste;
	}

	public DersOgrenci getById(Long id) {
		String sql = "SELECT * FROM \"obsh\".\"ders_ogrenci\" WHERE \"id\" = :ID";
		RowMapper<DersOgrenci> row_mapper = new RowMapper<DersOgrenci>() {

			@Override
			public DersOgrenci mapRow(ResultSet result, int rowNum) throws SQLException {
				return new DersOgrenci(result.getLong(1), result.getInt("devamsizlik"), result.getLong("note"),
						result.getLong("ders_id"), result.getLong("ogrenci_id"));
			}
		};
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, row_mapper);
	}

	public boolean save(DersOgrenci dersOgrenci) {
		String sql = "INSERT INTO \"obsh\".\"ders_ogrenci\"(\"devamsizlik\",\"note\",\"ders_id\",\"ogrenci_id\") VALUES (:DEVAMSIZLIK, :NOTE, :DERS_ID, :OGR_ID)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("DEVAMSIZLIK", dersOgrenci.getDEVAMSIZLIK());
		paramMap.put("NOTE", dersOgrenci.getNOTE());
		paramMap.put("DERS_ID", dersOgrenci.getDERS_ID());
		paramMap.put("OGR_ID", dersOgrenci.getOGR_ID());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}
}
