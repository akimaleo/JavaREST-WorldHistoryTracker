package xorg.webservice.app.models.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by lonely on 11/18/16.
 */
@Data
@AllArgsConstructor
public class InEvent {
	private String content;
	private double longitude;
	private double latitude;
	
}
