package kr.co.acctmgmt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.acctmgmt.domain.User;
import kr.co.acctmgmt.service.loginService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class MemberController {
	
	private final loginService loginService;
	
	@PostMapping("/scompany")
	public ResponseEntity<Void> login(@RequestBody User user) {
		
		if(!user.getId().isEmpty()) {
			if(!user.getPw().isEmpty()) {
			
			String userPw = loginService.getId(user.getId());
			//System.out.println(userPw); //userPw�� user1.getPw()�� ��
			
			if(user.getPw().equals(userPw)) {
				System.out.println("�α��� �Ϸ�");
				return new ResponseEntity<Void>(HttpStatus.OK);
				//�Ŀ� ��ũ �ٸ� ������ ����
			}}}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/company")
	public ResponseEntity<Void> insertUser(@RequestBody User user) {
//		String userId = "fu";
//		String userPw = "ck";
		System.out.println("id: "+ user.getId());
		System.out.println("pw: "+user.getPw());
		
//		User userPerson = loginService.getUser(userPerson);
		
//		if(user.getId().equals(userId)) {
//			if(user.getPw().equals(userPw)) {
//				System.out.println("�α��� ����!!!");
//			}
//			else {
//				System.out.println("����!!!");
//			}
//		}
		
		if(user.getPw().isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		loginService.insertUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/dcompany")
	public ResponseEntity<Void> deleteUser(@RequestBody User user) {
		
		if(!user.getId().isEmpty()) {
			System.out.println(user.getPw());
			
			String userPw = loginService.getId(user.getId());
			System.out.println(userPw); //userPw�� user1.getPw()�� ��
			
			if(user.getPw().equals(userPw)) {
				System.out.println("���� ����!!!");
				loginService.deleteUser(user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}}
		
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
}
