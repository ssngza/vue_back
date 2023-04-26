package kr.co.seoulit.erp.hr.salary.applicationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.seoulit.erp.hr.salary.dao.BonusDAO;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;

import java.util.ArrayList;

@Component
public class BonusApplicationServiceImpl implements BonusApplicationService{

	
	
	@Autowired
	private BonusDAO bonusDAO;
	
	@Override
	public ArrayList<BonusTO> finderBonus() {
		// TODO Auto-generated method stub
		return bonusDAO.selectBonus();
	}

	@Override
	public void registerBonus(BonusTO bonus) {
		// TODO Auto-generated method stub
		bonusDAO.insertBonus(bonus);
	}

	@Override
	public void removeAllBonus() {
		// TODO Auto-generated method stub
		bonusDAO.deleteAllBonus();
	}

	@Override
	public void updateBonus(BonusTO bonus) {
		bonusDAO.updateBonus(bonus);
	}

	@Override
	public BonusTO findEmp(String empCode) {
		return bonusDAO.findEmp(empCode);
	}

}