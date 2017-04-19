package impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import DAO.EntityDAO;
//import dao.impl.EntityDAOImpl.EntityRowMapper;
import models.Entity;

@Repository
public class EntityDaoImpl implements EntityDAO {
	
	private JdbcTemplate jdbcTemplate;
	private final EntityRowMapper getAllRowMapper = new  EntityRowMapper();
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Entity getById(int id) { 
		return jdbcTemplate.query("SELECT id, name FROM entity WHERE id = ?", 
				new ResultSetExtractor<Entity>()
				{
					@Override
					public Entity extractData(ResultSet rs) throws SQLException, DataAccessException {
						if(rs.next()) {
							return new EntityRowMapper().mapRow(rs, 1);
						}
						else 
					     	return null;
						}
					}, id);
				}
	
	@Override
	public List<Entity> getAll() {
		
		return	jdbcTemplate.query("SELECT id, name FROM entity", getAllRowMapper);
	}
	
	class EntityRowMapper implements RowMapper<Entity>{

		@Override
		public Entity mapRow(ResultSet rs, int i) throws SQLException {
			Entity entity = new Entity();
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			return entity;
		}	
	}
	
	@Override
	public void put(int id, String name, float latitude, float longitude, LocalDateTime time) {
			
	}

	class AllEntityRowMapper implements RowMapper<Entity>{
	
		@Override
		public Entity mapRow(ResultSet rs, int i) throws SQLException {
			Entity entity = new Entity();
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			return entity;
		}	
	}
	

}
