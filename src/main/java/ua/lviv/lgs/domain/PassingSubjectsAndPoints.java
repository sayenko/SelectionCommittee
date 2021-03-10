package ua.lviv.lgs.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "passing_subjects_and_points")
public class PassingSubjectsAndPoints {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Subject subject;
	private Integer points;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;
	
	public PassingSubjectsAndPoints() {}

	public PassingSubjectsAndPoints(Subject subject, Integer points, Faculty faculty) {
		this.subject = subject;
		this.points = points;
		this.faculty = faculty;
	}

	public PassingSubjectsAndPoints(Integer id, Subject subject, Integer points, Faculty faculty) {
		this.id = id;
		this.subject = subject;
		this.points = points;
		this.faculty = faculty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}	
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		PassingSubjectsAndPoints other = (PassingSubjectsAndPoints) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (subject != other.subject)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectsAndPoints [id=" + id + ", subject=" + subject + ", points=" + points + "]";
	}
	
}
