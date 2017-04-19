package models;
import java.time.LocalDateTime;

public class Place {

	private float latitude;
	private float longitude;
	private LocalDateTime time;//timeStamp
	private int entityId;
	
	public void setLatitude(int Id, float latitude)
	{
		
		this.latitude = latitude; 
	}
	
	public float getLatitude()
	{
		return latitude;
	}
	
	public void setLongitude(int Id, float longitude)
	{
		this.longitude = longitude; 
	}
	
	public float getLongitude(int Id)
	{
		return longitude; 
	}
	
	public void setTime(int Id, LocalDateTime time)
	{
		 this.time = time;
	}
	
	public LocalDateTime getTime(int Id)
	{
		return time; 
	}
	
	public void setEntityId(int Id)
	{
		this.entityId = Id; 
	}
	
	public int getEntityId()
	{
		return entityId; 
	}	
}
