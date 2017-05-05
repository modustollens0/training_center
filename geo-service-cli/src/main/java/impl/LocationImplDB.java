package impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import dao.EntityDAO;
import dao.LocationDAO;
import models.Entity;
import models.Location;
//log4j, slf4j ротация
public class LocationImplDB implements LocationDAO, EntityDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final LocationRowMapper GetAllRowMapper = new  LocationRowMapper();

	@Override
	public List<Float> getTravelHistory(int id, LocalDateTime start, LocalDateTime end) {
		
	return 	jdbcTemplate.query("SELECT latitude, longitude FROM location Where id_entity=? and time >= ? and time <= ? Order by id_entity, time",
		new ResultSetExtractor<List<Float>>()
		{
			@Override
			public List<Float> extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					return new GetTravelHistory().mapRow(rs, 1);
				}
				else 
			     	return null;
				}
		}, id, start, end);
	}
	

	@Override
	public void put(int id, float latitude, float longitude, LocalDateTime time) {
		jdbcTemplate.update("insert into location (id_entity, latitude, longitude, time ) values (?,?,?,?)", id,
				latitude, longitude, time);

	}

	@Override
	public Location currentCoordinatesById(int id) {
		return jdbcTemplate.query("SELECT id, name FROM entity WHERE id = ?", 
				new ResultSetExtractor<Location>()
				{
					@Override
					public Location extractData(ResultSet rs) throws SQLException, DataAccessException {
						if(rs.next()) {
							return new LocationRowMapper().mapRow(rs, 1);
						}
						else 
					     	return null;
						}
					}, id);
	}

	@Override
	public List<Location> getAll() {
		
		return	jdbcTemplate.query(" SELECT DISTINCT * from location a where not exists"+
					"(SELECT * from location where id_entity = a.id_entity  and time > a.time)", GetAllRowMapper);
	}

	@Override
	public void put(int id, String name) {
		jdbcTemplate.update("insert into entity (id, name) values (?,?)", id, name);
		
	}

	class LocationRowMapper implements RowMapper<Location>{
		
		@Override
		public Location mapRow(ResultSet rs, int i) throws SQLException {
			Location location = new Location();
			location.setEntityId(rs.getInt("id_entity"));
			location.setLatitude(rs.getInt("id_entity"), rs.getFloat("latitude"));
			location.setLongitude(rs.getInt("id_entity"), rs.getFloat("longitude"));
		//	location.setTime(rs.getInt("id_entity"), rs.getTime("time"));
			
			return location;
		}	
	}

	class GetTravelHistory implements RowMapper<List<Float>>{
		
		@Override
		public List<Float> mapRow(ResultSet rs, int i) throws SQLException {
			List<Float> travelHistory= new ArrayList<Float>();
		
			return travelHistory;
		}	
	}
	
}
