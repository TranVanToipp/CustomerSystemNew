package entyti;

public class Account {
	public String UserName,PassWord;
	public Account() {
	}
	
	public Account(String userName, String passWord) {
		UserName = userName;
		PassWord = passWord;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
}
