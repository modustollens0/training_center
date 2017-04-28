package impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.EntityDAO;
import models.Location;

public class EntityImplDB implements EntityDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Location currentCoordinatesById(int id) {
		return null;
	}

	@Override
	public List<Location> getAll() {

		return null;
	}

	@Override
	public void put(int id, String name) {
		
		jdbcTemplate.update("insert into entity (id, name) values (?,?)", id, name);

	}
}
