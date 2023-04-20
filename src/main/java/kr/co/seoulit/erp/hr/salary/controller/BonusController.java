package kr.co.seoulit.erp.hr.salary.controller;



import java.util.ArrayList;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.seoulit.erp.hr.salary.servicefacade.SalaryServiceFacade;
import kr.co.seoulit.erp.hr.salary.to.BonusTO;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/hr/salary/")
public class BonusController {

	@Autowired
	private  SalaryServiceFacade salaryServiceFacade;
	HashMap<String,Object> map = new HashMap<>();

	@RequestMapping(value = "/finderBonus",method = RequestMethod.GET)
	public HashMap<String,Object> finderBonus(){
		try {
			ArrayList<BonusTO> list = salaryServiceFacade.finderBonus();
			map.put("empBonus", list);
			map.put("errorMsg","success");
			map.put("errorCode", 0);

		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}

		return map;
	}

	@RequestMapping(value = "/registerBonus",method = RequestMethod.POST)
	public HashMap<String,Object> registerBonus(@RequestBody BonusTO bonus){
		try {
			salaryServiceFacade.registerBonus(bonus);
			map.clear();
			map.put("errorMsg","success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}


	@RequestMapping(value = "/updateBonus",method = RequestMethod.POST)
	public void updateBonus(@RequestBody BonusTO bonus){
		try {
			salaryServiceFacade.updateBonus(bonus);

		} catch (Exception ioe) {
			System.out.println(ioe.getMessage());
		}

	}

	@RequestMapping(value = "/removeAllBonus",method = RequestMethod.POST)
	public HashMap<String,Object> removeAllBonus(){
		try {
			salaryServiceFacade.removeAllBonus();
			map.clear();
			map.put("errorMsg","success");
			map.put("errorCode", 0);
		} catch (Exception ioe) {
			map.clear();
			map.put("errorCode", -1);
			map.put("errorMsg", ioe.getMessage());
		}
		return map;
	}
}