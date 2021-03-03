package ua.lviv.lgs.domain;

import java.util.Set;

public class User {
	private Integer id;
	private String login;
	private String password;
	private Role role;
	private Set<Entrant> entrantSet;
	
	public User() {}

	public User(String login, String password, Role role, Set<Entrant> entrantSet) {
		this.login = login;
		this.password = password;
		this.role = role;
		this.entrantSet = entrantSet;
	}

	public User(Integer id, String login, String password, Role role, Set<Entrant> entrantSet) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.entrantSet = entrantSet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Entrant> getEntrantSet() {
		return entrantSet;
	}

	public void setEntrantSet(Set<Entrant> entrantSet) {
		this.entrantSet = entrantSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrantSet == null) ? 0 : entrantSet.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		User other = (User) obj;
		if (entrantSet == null) {
			if (other.entrantSet != null)
				return false;
		} else if (!entrantSet.equals(other.entrantSet))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + ", entrant="
				+ entrantSet + "]";
	}	
	
}
