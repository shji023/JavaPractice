package Pack01;

public class DTO {
	String name;
	int age;
	String phone;
	String region;
	String role;
	String tool;
	String wts;
	DTO(String name, int age, String phone, String region, String role, String tool, String wts) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.region = region;
		this.role = role;
		this.tool = tool;
		this.wts = wts;}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegion() {
		return region;
	}
	public void setLRegion(String region) {
		this.region = region;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String getWts() {
		return wts;
	}
	public void setWts(String wts) {
		this.wts = wts;
	}
	
	
}
