package ua.lviv.lgs.domain;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@Column(name = "recruitment_plan")
	private int recruitmentPlan;
	
	@ElementCollection
    @CollectionTable(name="faculty_subject_and_points")
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name="subject_type")
    @Column(name="subject_points")
	private Map<Subject, Integer> subjectsMap;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "faculty")
	Set<Entrant> entrants;
	
	public Faculty() {
		if(this.entrants == null) {
			this.entrants = new HashSet<Entrant>();
		}
	}
	
	public Faculty(String name, Map<Subject, Integer> subjectsMap) {
		this.name = name;
		if(this.entrants == null) {
			this.entrants = new HashSet<Entrant>();
		} else this.subjectsMap = subjectsMap;
	}

	public Faculty(int recruitmentPlan, Integer id, String name, Map<Subject, Integer> subjectsMap) {
		this.recruitmentPlan = recruitmentPlan;
		this.id = id;
		this.name = name;
		if(this.entrants == null) {
			this.entrants = new HashSet<Entrant>();
		} else this.subjectsMap = subjectsMap;
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

	public Map<Subject, Integer> getSubjectsMap() {
		return subjectsMap;
	}

	public void setSubjectsMap(Map<Subject, Integer> subjectsMap) {
		this.subjectsMap = subjectsMap;
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
		result = prime * result + ((subjectsMap == null) ? 0 : subjectsMap.hashCode());
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
		if (subjectsMap == null) {
			if (other.subjectsMap != null)
				return false;
		} else if (!subjectsMap.equals(other.subjectsMap))
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
		return "Faculty [recruitmentPlan=" + recruitmentPlan + ", id=" + id + ", name=" + name + ", subjectsMap="
				+ subjectsMap
				+ "]";
	}
	
}
