package Pack01;

//커맨드 객체
public class Person {
	String id;
	int pwd;
	Person( String id, int pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	
}