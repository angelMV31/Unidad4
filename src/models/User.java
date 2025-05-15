package models;

import java.util.Date;

public class User {

	public int id;
	public String name;
	public String email;
	public String rol;
	public String cel;
	public Date create;
	public Date update;
	
	public User(int id, String name, String email, String rol, String cel, Date create, Date update) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.rol=rol;
		this.cel=cel;
		this.create=create;
		this.update=update;
	}
}
