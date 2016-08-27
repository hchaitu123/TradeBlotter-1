package tradeBlotter.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="USER")
	public class User implements Serializable {
		
	    private static final long serialVersionUID = 1L;
	    
		private String userName;
		
		private int userID=-1;
		
		
		
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public int getUserID() {
			return userID;
		}
		public void setUserID(int userID) {
			this.userID = userID;
		}

	  

	}