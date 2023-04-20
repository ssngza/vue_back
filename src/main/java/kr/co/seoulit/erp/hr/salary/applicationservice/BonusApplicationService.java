package kr.co.seoulit.erp.hr.salary.applicationservice;

import kr.co.seoulit.erp.hr.salary.to.BonusTO;

import java.util.ArrayList;

public interface BonusApplicationService {
	public ArrayList<BonusTO> finderBonus();
	public void registerBonus(BonusTO bonus);
	public void removeAllBonus();

	public void updateBonus(BonusTO bonus);
}