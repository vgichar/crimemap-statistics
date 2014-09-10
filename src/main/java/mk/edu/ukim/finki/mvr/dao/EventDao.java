package mk.edu.ukim.finki.mvr.dao;

import java.util.Date;
import java.util.List;

import mk.edu.ukim.finki.mvr.model.Event;

public interface EventDao {

	public List<Event> queryAllEvents();
	
	public Event getEventById (int id);
	
	public List<Event> queryEventsByBiltenDate(Date biltenDate);
	
	public List<Event> queryEventsByLocation (String location);
	
}
