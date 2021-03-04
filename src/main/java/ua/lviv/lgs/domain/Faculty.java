package ua.lviv.lgs.domain;

import java.util.Map;

public class Faculty {
	
	private Integer id;
	private String name;
	private int recruitmentPlan;
	
	Map<Discipline, Integer> disciplineSet;
	
	public Faculty() {}
	
	public Faculty(String name, Map<Discipline, Integer> disciplineSet) {
		this.name = name;
		this.disciplineSet = disciplineSet;
	}

	public Faculty(int recruitmentPlan, Integer id, String name, Map<Discipline, Integer> disciplineSet) {
		this.recruitmentPlan = recruitmentPlan;
		this.id = id;
		this.name = name;
		this.disciplineSet = disciplineSet;
	}

	public int getRecruitmentPlan() {
		return recruitmentPlan;
	}

	public void setRecruitmentPlan(int recruitmentPlan) {
		this.recruitmentPlan = recruitmentPlan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Discipline, Integer> getDisciplineSet() {
		return disciplineSet;
	}

	public void setDisciplineSet(Map<Discipline, Integer> disciplineSet) {
		this.disciplineSet = disciplineSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplineSet == null) ? 0 : disciplineSet.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + recruitmentPlan;
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
		Faculty other = (Faculty) obj;
		if (disciplineSet == null) {
			if (other.disciplineSet != null)
				return false;
		} else if (!disciplineSet.equals(other.disciplineSet))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recruitmentPlan != other.recruitmentPlan)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [recruitmentPlan=" + recruitmentPlan + ", id=" + id + ", name=" + name + ", disciplineSet="
				+ disciplineSet + "]";
	}
	
}
