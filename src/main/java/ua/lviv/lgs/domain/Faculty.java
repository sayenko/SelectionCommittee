package ua.lviv.lgs.domain;

import java.util.Set;

public class Faculty {
	
	private Integer id;
	private String name;
	private int recruitmentPlan;
	
	Set<SubjectsAndPoints> subjectsList;
	
	public Faculty() {}
	
	public Faculty(String name, Set<SubjectsAndPoints> subjectsList) {
		this.name = name;
		this.subjectsList = subjectsList;
	}

	public Faculty(int recruitmentPlan, Integer id, String name, Set<SubjectsAndPoints> subjectsList) {
		this.recruitmentPlan = recruitmentPlan;
		this.id = id;
		this.name = name;
		this.subjectsList = subjectsList;
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

	public Set<SubjectsAndPoints> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(Set<SubjectsAndPoints> subjectsList) {
		this.subjectsList = subjectsList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subjectsList == null) ? 0 : subjectsList.hashCode());
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
		if (subjectsList == null) {
			if (other.subjectsList != null)
				return false;
		} else if (!subjectsList.equals(other.subjectsList))
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
		return "Faculty [recruitmentPlan=" + recruitmentPlan + ", id=" + id + ", name=" + name + ", subjectsList="
				+ subjectsList + "]";
	}
	
}
