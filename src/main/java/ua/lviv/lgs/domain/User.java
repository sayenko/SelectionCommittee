package ua.lviv.lgs.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String login;
	private String password;
	private String passwordConfirm;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE }, mappedBy = "user")
	private Set<EntrantRegister> entrantRegisterSet;
	
	@OneToOne(mappedBy="user")
	private Entrant entrant;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {}

	public User(String login, String password, Role role, Entrant entrant) {
		this.login = login;
		this.password = password;
		this.role = role;
		this.entrant = entrant;
	}

	public User(Integer id, String login, String password, String passwordConfirm, Role role, Entrant entrant) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.role = role;
		this.entrant = entrant;
	}
	
	public User(User user) {
		this.id = user.id;
		this.login = user.login;
		this.password = user.password;
		this.passwordConfirm = user.passwordConfirm;
		this.role = user.role;
		this.entrant = user.entrant;
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

	public Entrant getEntrant() {
		return entrant;
	}

	public void setEntrant(Entrant entrant) {
		this.entrant = entrant;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<EntrantRegister> getEntrantRegisterSet() {
		return entrantRegisterSet;
	}

	public void setEntrantRegisterSet(Set<EntrantRegister> entrantRegisterSet) {
		this.entrantRegisterSet = entrantRegisterSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrant == null) ? 0 : entrant.hashCode());
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
		return "User [id=" + id + ", login=" + login + ", role=" + role + "]";
	}	
	
}
