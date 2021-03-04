package ua.lviv.lgs.domain;

public class SubjectsAndPoints {
	
	private Integer id;
	private Subject subject;
	private Integer points;
	
	public SubjectsAndPoints() {}

	public SubjectsAndPoints(Subject subject, Integer points) {
		this.subject = subject;
		this.points = points;
	}

	public SubjectsAndPoints(Integer id, Subject subject, Integer points) {
		this.id = id;
		this.subject = subject;
		this.points = points;
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
		SubjectsAndPoints other = (SubjectsAndPoints) obj;
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
