package xorg.webservice.app.models.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.sql.Timestamp;

/**
 * Created by lonely on 11/5/16.
 */

@Data
@AllArgsConstructor
public class Event {
	
	private int eventId;
	
	private String eventName;
	
	private Point position;
	
	private Timestamp createDate;
	
	private int userId;
	
}
