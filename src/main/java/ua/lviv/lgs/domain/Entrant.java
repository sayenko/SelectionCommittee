package ua.lviv.lgs.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrant")
public class Entrant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	private Integer age;
	private String contacts;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(mappedBy="entrant")
	private EntrantRegister entrantRegister;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "faculty_id")
	Faculty faculty;
	
	@ElementCollection
    @CollectionTable(name="entrant_subject_and_points")
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name="subject_type")
    @Column(name="subject_points")
	private Map<Subject, Integer> subjectsMap;
	
	@Lob
	private String photo;
	
	@Column(name = "total_score")
	private Integer totalScore;
	
	@Column(name = "is_added_to_register")
	private boolean isAddedToRegister;
	
	public Entrant() {
		
		if(this.subjectsMap == null) {
			this.subjectsMap = new HashMap<Subject, Integer>();
		}
		
	}
	
	public Entrant(String firstName, String lastName, Integer age, String contacts, User user,
			Map<Subject, Integer> subjectsMap, Faculty faculty) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contacts = contacts;
		this.user = user;
		this.faculty = faculty;
		
		if(this.subjectsMap == null) {
		this.subjectsMap = new HashMap<Subject, Integer>();
	} else this.subjectsMap = subjectsMap;
	}

	public Entrant(Integer id, String firstName, String lastName, Integer age, String contacts, User user,
			Map<Subject, Integer> subjectsMap, Faculty faculty) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contacts = contacts;
		this.user = user;
		this.faculty = faculty;
		
		if(this.subjectsMap == null) {
			this.subjectsMap = new HashMap<Subject, Integer>();
		} else this.subjectsMap = subjectsMap;
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Map<Subject, Integer> getSubjectsMap() {
		return subjectsMap;
	}

	public void setSubjectsMap(Map<Subject, Integer> subjectsMap) {
		this.subjectsMap = subjectsMap;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public EntrantRegister getEntrantRegister() {
		return entrantRegister;
	}

	public void setEntrantRegister(EntrantRegister entrantRegister) {
		this.entrantRegister = entrantRegister;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	
	public boolean isAddedToRegister() {
		return isAddedToRegister;
	}

	public void setAddedToRegister(boolean isAddedToRegister) {
		this.isAddedToRegister = isAddedToRegister;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((subjectsMap == null) ? 0 : subjectsMap.hashCode());
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
		if (subjectsMap == null) {
			if (other.subjectsMap != null)
				return false;
		} else if (!subjectsMap.equals(other.subjectsMap))
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
				+ ", contacts=" + contacts + ", user=" + user + ", subjectsMap="
				+ subjectsMap + ", facultyList="
				+ faculty
				+ "]";
	}
	
}