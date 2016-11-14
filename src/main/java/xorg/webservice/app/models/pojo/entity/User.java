package xorg.webservice.app.models.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.DateTime;


/**
 * Created by raccoon on 19.09.16.
 *
 * @version: 1.0beta
 */

@Data
@AllArgsConstructor
public class User {
	
	private int userId;
	
	private String userName;
	
	private String hashPassword;
	
	private String encryptSalt;
	
	private DateTime regDate;
	
	private String accessToken;
	
}
