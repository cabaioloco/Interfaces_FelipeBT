package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
	private SimpleStringProperty firstName;

	private SimpleStringProperty lastName;
	private SimpleStringProperty email;
	private SimpleIntegerProperty age;
	private SimpleStringProperty genero;
	private SimpleStringProperty lenguaje;
	private SimpleIntegerProperty sueldo;



	public Persona(String fName, String lName, String email, Integer age, String genero,String lenguaje, Integer Sueldo) {
		this.firstName = new SimpleStringProperty(fName);
		this.lastName = new SimpleStringProperty(lName);
		this.email = new SimpleStringProperty(email);
		this.age = new SimpleIntegerProperty(age);
		this.genero = new SimpleStringProperty(genero);
		this.lenguaje = new SimpleStringProperty(lenguaje);
		this.sueldo = new SimpleIntegerProperty(Sueldo);
	}

	public Persona() {
	}

	public Integer getSueldo() {
		return sueldo.get();
	}

	public void setSueldo(SimpleIntegerProperty sueldo) {
		this.sueldo = sueldo;
	}

	public String getFirstName() {
		return firstName.get();
	}


	public String getLastName() {
		return lastName.get();
	}

	

	public String getEmail() {
		return email.get();
	}

	

	public Integer getAge() {
		return age.get();
	}

	

	public String getGenero() {
		return genero.get();
	}

	public void setGenero(String genero) {
		this.genero.set(genero);
	}
	public String getLenguaje() {
		return lenguaje.get();
	}

	public void setFirstName(SimpleStringProperty firstName) {
		this.firstName = firstName;
	}

	public void setLastName(SimpleStringProperty lastName) {
		this.lastName = lastName;
	}

	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}

	public void setAge(SimpleIntegerProperty age) {
		this.age = age;
	}

	public void setGenero(SimpleStringProperty genero) {
		this.genero = genero;
	}

	public void setLenguaje(SimpleStringProperty lenguaje) {
		this.lenguaje = lenguaje;
	}

}