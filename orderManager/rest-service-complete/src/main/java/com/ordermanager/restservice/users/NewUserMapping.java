package com.ordermanager.restservice.users;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NewUserMapping {

	@NotNull(message="Debes especificar el nombre")
	@Size(min = 5, max = 30, message="El nombre tiene que tener entre 5 y 30 caracteres")
	private String firstName = null;

	@NotNull(message="Debes especificar el apellido")
	@Size(min = 5, max = 30, message="El apellido tiene que tener entre 5 y 30 caracteres")
	private String lastName = null;

	@NotNull(message="Debes especificar el nombre de usuario")
	@Size(min = 5, max = 10, message="El nombre de usuario tiene que tener entre 5 y 30 caracteres")
	private String userName = null;

	private String password = null;

	//@Pattern(regexp = "((^ Admin $  |  ^ Operator $))", message= " El rol debe ser admin u operator")
	private String role = null;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
