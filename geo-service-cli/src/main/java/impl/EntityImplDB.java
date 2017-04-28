package impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.EntityDAO;
import models.Location;

public class EntityImplDB implements EntityDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
//	private final EntityRowMapper getAllRowMapper = new EntityRowMapper();

	/*
	 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	 * 
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	 * this.jdbcTemplate = jdbcTemplate; }
	 */

	@Override
	public Location currentCoordinatesById(int id) {
		/*
		 * return jdbcTemplate.query("SELECT id, name FROM entity WHERE id = ?",
		 * new ResultSetExtractor<Entity>() {
		 * 
		 * @Override public Entity extractData(ResultSet rs) throws
		 * SQLException, DataAccessException { if(rs.next()) { return new
		 * EntityRowMapper().mapRow(rs, 1); } else return null; } }, id); }
		 */
		return null;
	}

	@Override
	public List<Location> getAll() {

		return null; // jdbcTemplate.query("SELECT id, name FROM entity",
						// getAllRowMapper);
	}

	@Override
	public void put(int id, String name) {
		
		jdbcTemplate.update("insert into entity (id, name) values (?,?)", id, name);

	}

/*	class AllEntityRowMapper implements RowMapper<Entity> {

		@Override
		public Entity mapRow(ResultSet rs, int i) throws SQLException {
			Entity entity = new Entity();
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			return entity;
		}
	}
*/
}
