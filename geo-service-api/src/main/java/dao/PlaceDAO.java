package dao;

import java.time.LocalDateTime;
import java.util.List;

public interface PlaceDAO {
	
	public List<Float> getTravelHistory(int Id, LocalDateTime start, LocalDateTime end);
	public void put(int Id, float latitude, float longitude, LocalDateTime time);

}
