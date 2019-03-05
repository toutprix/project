package com.demo.jwtauthentication.controller;

import com.demo.jwtauthentication.message.request.AddCaseForm;
import com.demo.jwtauthentication.message.response.ResponseMessage;
import com.demo.jwtauthentication.model.Case;
import com.demo.jwtauthentication.model.User;
import com.demo.jwtauthentication.repository.CaseRepository;
import com.demo.jwtauthentication.repository.UserRepository;
import com.demo.jwtauthentication.security.services.CaseService;
import com.demo.jwtauthentication.security.services.UserPrinciple;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MainController {

	@Autowired
	CaseRepository caseRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CaseService caseService;



	@PostMapping("/api/test/addcase")
	public ResponseEntity<?> addCase(@RequestBody AddCaseForm addCaseForm){

		User user = userRepository.findByUsername(addCaseForm.getUsername());
		Case cases = new Case(addCaseForm.getDate(),addCaseForm.getText(),user);
		caseRepository.save(cases);

		return new ResponseEntity<>(new ResponseMessage("Case to added"), HttpStatus.OK);
	}

	@GetMapping("/api/test/today")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getCaseToday(){
		System.out.println("SEND!!!!!!!!!");

		UserPrinciple userDetailsImpl =
				(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Case> list = caseService.findForToday(
						userRepository.findByUsername(
						userDetailsImpl.getUsername()));
		System.out.println("TODAY");
		for(Case x : list){
			System.out.println(x.getDate());
		}
		return new Gson().toJson(list);
	}

	@GetMapping("/api/test/after")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getCaseAfter(){

		UserPrinciple userDetailsImpl =
				(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Case> list = caseService.findForTomorrow(
				userRepository.findByUsername(
						userDetailsImpl.getUsername()));

		System.out.println("AFTER");
		for(Case x : list){
			System.out.println(x.getDate());
		}
		return new Gson().toJson(list);
	}

	@GetMapping("/api/test/after2")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getCaseAfter2(){

		UserPrinciple userDetailsImpl =
				(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Case> list = caseService.findForDayAfterTomorrow(
				userRepository.findByUsername(
						userDetailsImpl.getUsername()));
		System.out.println("AFTER2");
		for(Case x : list){
			System.out.println(x.getDate());
		}
		return new Gson().toJson(list);
	}

	@GetMapping("/api/test/after3")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getCaseAfter3(){

		UserPrinciple userDetailsImpl =
				(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Case> list = caseService.findForAfterDayAfterTomorrow(
				userRepository.findByUsername(
						userDetailsImpl.getUsername()));
		System.out.println("AFTER3");
		for(Case x : list){
			System.out.println(x.getDate());
		}
		return new Gson().toJson(list);
	}

	@GetMapping("/api/test/month")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String getCaseMonth(){

		UserPrinciple userDetailsImpl =
				(UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Case> list = caseService.findForMonth(
				userRepository.findByUsername(
						userDetailsImpl.getUsername()));
		System.out.println("MONTH");
		for(Case x : list){
			System.out.println(x.getDate());
		}
		return new Gson().toJson(list);
	}

}