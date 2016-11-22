package xorg.webservice.app.models.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by lonely on 11/18/16.
 */
@Data
@AllArgsConstructor
public class EventSearchDto {
	private double latitude;
	private double longitude;
	private int radius;
	private Timestamp from;
	private Timestamp to;
}
