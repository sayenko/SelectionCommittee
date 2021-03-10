package ua.lviv.lgs.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@Column(name = "recruitment_plan")
	private int recruitmentPlan;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "faculty")
    @Column(nullable = false)
	Set<PassingSubjectsAndPoints> subjectsList;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "faculty")
	Set<Entrant> entrants;
	
	public Faculty() {}
	
	public Faculty(String name, Set<PassingSubjectsAndPoints> subjectsList) {
		this.name = name;
		this.subjectsList = subjectsList;
	}

	public Faculty(int recruitmentPlan, Integer id, String name, Set<PassingSubjectsAndPoints> subjectsList) {
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

	public Set<PassingSubjectsAndPoints> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(Set<PassingSubjectsAndPoints> subjectsList) {
		this.subjectsList = subjectsList;
	}
	
	public Set<Entrant> getEntrants() {
		return entrants;
	}

	public void setEntrants(Set<Entrant> entrants) {
		this.entrants = entrants;
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
