package kr.co.seoulit.erp.hr.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.co.seoulit.erp.hr.attendance.servicefacade.AttdServiceFacade;
import kr.co.seoulit.erp.hr.attendance.to.DayAttdTO;

@CrossOrigin("*")
@RestController
//@RequestMapping(value = "/hr/*", produces = "application/json")
@RequestMapping("/hr/attendance/*")
public class DayAttdController {

	@Autowired
	private AttdServiceFacade attdServiceFacade;

	@GetMapping(value = "/dayAttendance")
	public HashMap<String, Object> findDayAttdList (
			@RequestParam("applyDay") String applyDay,
			@RequestParam("empCode") String empCode ) {
		System.out.println(empCode);

		HashMap<String, Object> model = new HashMap<>();
		model.put("DayAttendTO", attdServiceFacade.findDayAttdList(empCode, applyDay));
		return model;
	}

	// @RequestMapping(value="insa/attendance/dayAttendance",
	// method=RequestMethod.POST)
	@RequestMapping(value = "/dayAttendance", method = RequestMethod.POST)
	public Map<String, Object> registDayAttd(@RequestBody Map<String, String> dayAttdData) {
		// ("sendData") String sendData
		System.out.println("나와   " + dayAttdData);
		DayAttdTO dayAttd = new DayAttdTO();

		dayAttd.setEmpCode(dayAttdData.get("empCode"));
		dayAttd.setApplyDay(dayAttdData.get("applyDay"));
		dayAttd.setAttdTypeCode(dayAttdData.get("attdType"));
		dayAttd.setAttdTypeName(dayAttdData.get("attdTypeName"));
		dayAttd.setTime(dayAttdData.get("time"));

		HashMap<String, Object> map = attdServiceFacade.registDayAttd(dayAttd);
		System.out.println(map);
		return map;

	}

	@RequestMapping(value = "/deleteDayAttendance", method = RequestMethod.POST)
	public void deleteDayAttd(@RequestBody Map<String, ArrayList<DayAttdTO>> data) {

		ArrayList<DayAttdTO> dayAttdData = data.get("dayAttdData");
		System.out.println(dayAttdData);
		attdServiceFacade.deleteDayAttd(dayAttdData);

	}
}
