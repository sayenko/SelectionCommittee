package ua.lviv.lgs.domain;

import java.util.Comparator;

public class SortEntrantRegisterByEntrantTotalPionts implements Comparator<EntrantRegister>{

	@Override
	public int compare(EntrantRegister o1, EntrantRegister o2) {
		return o2.getEntrant().getTotalScore()-o1.getEntrant().getTotalScore();
	}

}
