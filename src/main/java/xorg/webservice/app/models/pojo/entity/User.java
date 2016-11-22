package xorg.webservice.app.models.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;


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
	
	private Timestamp regDate;
	
	private String accessToken;
	
	public User ( String userName, String pass, String salt ) {
		this.userName = userName;
		this.hashPassword = pass;
		this.encryptSalt = salt;
	}
}
