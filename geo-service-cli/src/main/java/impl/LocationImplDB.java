package impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.LocationDAO;

public class LocationImplDB implements LocationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Float> getTravelHistory(int Id, LocalDateTime start, LocalDateTime end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(int id, float latitude, float longitude, LocalDateTime time) {
		jdbcTemplate.update("insert into location (id_entity, latitude, longitude, time ) values (?,?,?,?)", id,
				latitude, longitude, time);

	}

}
