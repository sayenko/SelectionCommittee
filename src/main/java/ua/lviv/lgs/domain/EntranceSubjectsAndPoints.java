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
@Table(name = "entrance_subjects_and_points")
public class EntranceSubjectsAndPoints {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Subject subject;
	private Integer points;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "entrant_id", nullable = false)
	private Entrant entrant;
	
	public EntranceSubjectsAndPoints() {}

	public EntranceSubjectsAndPoints(Subject subject, Integer points, Entrant entrant) {
		this.subject = subject;
		this.points = points;
		this.entrant = entrant;
	}

	public EntranceSubjectsAndPoints(Integer id, Subject subject, Integer points, Entrant entrant) {
		this.id = id;
		this.subject = subject;
		this.points = points;
		this.entrant = entrant;
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

	public Entrant getEntrant() {
		return entrant;
	}

	public void setEntrant(Entrant entrant) {
		this.entrant = entrant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrant == null) ? 0 : entrant.hashCode());
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
		EntranceSubjectsAndPoints other = (EntranceSubjectsAndPoints) obj;
		if (entrant == null) {
			if (other.entrant != null)
				return false;
		} else if (!entrant.equals(other.entrant))
			return false;
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
		return "EntranceSubjectsAndPoints [id=" + id + ", subject=" + subject + ", points=" + points + ", entrant="
				+ entrant + "]";
	}
	
}
