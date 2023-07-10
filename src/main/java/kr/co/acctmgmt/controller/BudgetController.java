package kr.co.acctmgmt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.Budget;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BudgetController {

	@PostMapping("/budget")
	public void getBGT(@RequestBody Budget budget) {
//	public void getBGT(@RequestBody Map<String, String> budget) {
		
		System.out.println(budget.toString());
	}
}
