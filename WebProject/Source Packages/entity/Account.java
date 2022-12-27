package entity;

public class Account {
   private int user_id;
   private String usernam;
   private String password;
   
public Account(int user_id, String usernam, String password) {
	super();
	this.user_id = user_id;
	this.usernam = usernam;
	this.password = password;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsernam() {
	return usernam;
}
public void setUsernam(String usernam) {
	this.usernam = usernam;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   
}
