package ua.lviv.lgs.domain;

import java.util.Set;

public class Entrant {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String contacts;
	private User user;	
	Set<SubjectsAndPoints> subjectsList;
	Faculty faculty;
	
	public Entrant() {}

	public Entrant(String firstName, String lastName, Integer age, String contacts, User user,
			Set<SubjectsAndPoints> subjectsList, Faculty faculty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contacts = contacts;
		this.user = user;
		this.subjectsList = subjectsList;
		this.faculty = faculty;
	}

	public Entrant(Integer id, String firstName, String lastName, Integer age, String contacts, User user,
			Set<SubjectsAndPoints> subjectsList, Faculty faculty) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contacts = contacts;
		this.user = user;
		this.subjectsList = subjectsList;
		this.faculty = faculty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<SubjectsAndPoints> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(Set<SubjectsAndPoints> subjectsList) {
		this.subjectsList = subjectsList;
	}

	public Faculty getFacultyList() {
		return faculty;
	}

	public void setFacultyList(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((subjectsList == null) ? 0 : subjectsList.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrant other = (Entrant) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (subjectsList == null) {
			if (other.subjectsList != null)
				return false;
		} else if (!subjectsList.equals(other.subjectsList))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", contacts=" + contacts + ", user=" + user + ", subjectsList=" + subjectsList + ", facultyList="
				+ faculty + "]";
	}
	
}
