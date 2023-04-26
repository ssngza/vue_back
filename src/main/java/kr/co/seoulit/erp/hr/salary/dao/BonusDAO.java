package kr.co.seoulit.erp.hr.salary.dao;

import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;

import java.util.ArrayList;

@Mapper
public interface BonusDAO {
	public ArrayList<BonusTO> selectBonus();

	public void insertBonus(BonusTO bonus);

	public void deleteAllBonus();

	public void updateBonus(BonusTO bonus);

	public BonusTO findEmp(String empCode);
}
