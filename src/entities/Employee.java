package entities;

import entities.excecptions.EmailException;
import entities.excecptions.LastNameException;
import entities.excecptions.NameException;

public class Employee {

	private String name;
	private String lastName;
	private String email;
	private Integer pis;

	public Employee() {
	}

	public Employee(String name, String lastName, String email, Integer pis) {
		int y = 0;
		if (name.length() < 2 || name.length() > 30) {
			throw new NameException("O nome do funcionário deve possuir de 2 a 30 caracteres!");
		}
		if (lastName.length() < 2 || lastName.length() > 50) {
			throw new LastNameException("O sobrenome do funcionário deve possuir de 2 a 50 caracteres!");
		}
		while (y == 0) {
			for (int x = 0; x < email.length(); x++) {
				if (email.charAt(x) == 64) {
					y += 1;
				}
			}
			if (y != 1) {
				throw new EmailException("Email inválido!");
			}
		}
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.pis = pis;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Integer getPis() {
		return pis;
	}

	public void updateName(String name) {
		if (name.length() < 2 || name.length() > 30) {
			throw new NameException("O nome do funcionário deve possuir de 2 a 30 caracteres!");
		}
		this.name = name;
	}

	public void updateLastName(String lastName) {
		if (lastName.length() < 2 || lastName.length() > 50) {
			throw new LastNameException("O sobrenome do funcionário deve possuir de 2 a 50 caracteres!");
		}
		this.lastName = lastName;
	}

	public void updateEmail(String email) {
		int y = 0;
		while (y == 0) {
			for (int x = 0; x < email.length(); x++) {
				if (email.charAt(x) == 64) {
					y += 1;
				}
			}
			if (y != 1) {
				throw new EmailException("Email inválido!");
			}
		}
		this.email = email;
	}

	public void updatePis(Integer pis) {
		this.pis = pis;
	}

	public String toString() {
		return "Nome: " + name + " " + lastName + "\n" + "Email: " + email + "\n" + "PIS: " + pis;
	}
}
