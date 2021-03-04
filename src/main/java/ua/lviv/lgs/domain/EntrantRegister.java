package ua.lviv.lgs.domain;

public class EntrantRegister {
	
	private Integer id;
	private Integer entrantId;
	private Integer facultyId;
	
	public EntrantRegister() {}

	public EntrantRegister(Integer entrantId, Integer facultyId) {
		this.entrantId = entrantId;
		this.facultyId = facultyId;
	}

	public EntrantRegister(Integer id, Integer entrantId, Integer facultyId) {
		this.id = id;
		this.entrantId = entrantId;
		this.facultyId = facultyId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEntrantId() {
		return entrantId;
	}

	public void setEntrantId(Integer entrantId) {
		this.entrantId = entrantId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrantId == null) ? 0 : entrantId.hashCode());
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EntrantRegister other = (EntrantRegister) obj;
		if (entrantId == null) {
			if (other.entrantId != null)
				return false;
		} else if (!entrantId.equals(other.entrantId))
			return false;
		if (facultyId == null) {
			if (other.facultyId != null)
				return false;
		} else if (!facultyId.equals(other.facultyId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntrantRegister [id=" + id + ", entrantId=" + entrantId + ", facultyId=" + facultyId + "]";
	}
	
}
