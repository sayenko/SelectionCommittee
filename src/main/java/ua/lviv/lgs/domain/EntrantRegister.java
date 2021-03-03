package ua.lviv.lgs.domain;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class EntrantRegister {
	private Map<Faculty, Set<Entrant>> entrantsRegister;
	
	public EntrantRegister() {
		if(entrantsRegister == null) {
			entrantsRegister = new HashMap<Faculty, Set<Entrant>>();
		}
	}

	public Map<Faculty, Set<Entrant>> getEntrantsRegister() {
		return entrantsRegister;
	}

	public void setEntrantsRegister(Map<Faculty, Set<Entrant>> entrantsRegister) {
		this.entrantsRegister = entrantsRegister;
	}

	@Override
	public String toString() {
		return "EntrantRegister [entrantsRegister=" + entrantsRegister + "]";
	}
	
}
