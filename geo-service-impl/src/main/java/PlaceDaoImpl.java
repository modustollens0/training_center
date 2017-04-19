package impl;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import DAO.PlaceDAO;

@Repository
public class PlaceDaoImpl implements PlaceDAO{

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Float> getTravelHistory(int Id, LocalDateTime start, LocalDateTime end)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(int Id, float latitude, float longitude, LocalDateTime time) {
		// TODO Auto-generated method stub
		
	}
}
