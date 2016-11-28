package xorg.webservice.app.models.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by lonely on 11/5/16.
 */

@Data
@AllArgsConstructor
public class Event {

    private int eventId;

    private String eventName;

    private double latitude;

    private double longitude;
    
    private Timestamp createDate;

    private int userId;

    public Event(String content, double latitude, double longitude, int userId) {
        this.eventName = content;
        this.longitude = longitude;
        this.latitude = latitude;
        this.userId = userId;
    }
}
