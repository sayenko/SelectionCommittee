package ua.lviv.lgs.dto;

public class EntrantResponse {
	
	private String firstName;
	private String lastName;
	private Integer age;
	private String contacts;
	private String faculty;
	private String subjectAndPoints;
	
	public EntrantResponse() {
	}

	public EntrantResponse(String firstName, String lastName, Integer age, String contacts, String faculty,
			String subjectAndPoints) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contacts = contacts;
		this.faculty = faculty;
		this.subjectAndPoints = subjectAndPoints;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSubjectAndPoints() {
		return subjectAndPoints;
	}

	public void setSubjectAndPoints(String subjectAndPoints) {
		this.subjectAndPoints = subjectAndPoints;
	}
	
}
