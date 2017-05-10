package dao;

import java.sql.Timestamp;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface LocationDAO {

	public List<Float> getTravelHistory(int Id, Timestamp start, Timestamp end);

	public void put(int id, float latitude, float longitude, Timestamp time);

}
