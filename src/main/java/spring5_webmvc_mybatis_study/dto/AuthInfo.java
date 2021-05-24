package spring5_webmvc_mybatis_study.dto;

public class AuthInfo {

	private long id;
	private String email;
	private String name;

	
	public AuthInfo() {
		// TODO Auto-generated constructor stub
	}

	public AuthInfo(long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

}
