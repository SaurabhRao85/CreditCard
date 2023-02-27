package com.axis.controller;

import java.util.HashMap;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.configuration.UserFeignClient;
import com.axis.dto.CreditCardActivateRequest;
import com.axis.dto.CreditCardDailyLimitRequest;
import com.axis.dto.CreditCardDeactivateRequest;
import com.axis.dto.CreditCardDto;
import com.axis.exception.ValidationException;
import com.axis.model.CreditCard;
import com.axis.security.JwtUser;
import com.axis.security.JwtUserDetailsService;
import com.axis.service.CreditCardService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@Autowired
	UserFeignClient userFeignClient;

	@Autowired
	@Qualifier("jwtUserDetailsService")
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/creditCard")
	public ResponseEntity<CreditCardDto> addCreditCard(@RequestBody CreditCardDto creditCardDto) {
		return new ResponseEntity<CreditCardDto>(creditCardService.addCreditCard(creditCardDto), HttpStatus.OK);
	}

	@GetMapping("/creditCard")
	public ResponseEntity<List<CreditCardDto>> getAllCreditCard() {
		return new ResponseEntity<List<CreditCardDto>>(creditCardService.getAllCreditCard(), HttpStatus.OK);
	}

	@GetMapping("/creditCard/{id}")
	public ResponseEntity<CreditCardDto> getCreditCardById(@PathVariable int id) {
		return new ResponseEntity<CreditCardDto>(creditCardService.findById(id), HttpStatus.OK);
	}

	
	
	   @GetMapping(value = "/list") public ResponseEntity<?>findAllByAccountId(HttpServletRequest request) { JwtUser jwtUser =
	   userDetailsService.getUserFromHeaderToken(request);
	  
	   if (jwtUser == null) { HashMap res = new HashMap(); res.put("status_code",
	   401); res.put("message", "Operation failed, Invalid token "); return new
	   ResponseEntity<>(res, HttpStatus.BAD_REQUEST); }
	 
		List<CreditCardDto> creditCards = creditCardService.findAllActiveByUserId(jwtUser.getId());
		if (creditCards != null) {

			HashMap res = new HashMap();
			res.put("status_code", 200);
			res.put("message", "Operation, Find list creditcard success.");
			res.put("data", creditCards);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		HashMap res = new HashMap();
		res.put("status_code", 422);
		res.put("message", "Operation failed");

		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}

	
	@PutMapping(value = "/daily-limit")
	public ResponseEntity<?> dailyLimit(@Valid @RequestBody CreditCardDailyLimitRequest request, BindingResult result) {

		
		 if (result.hasErrors()) { throw new
		 ValidationException("Incorrect DailyLimit", result); } CreditCard
		 inputCreditCard = modelMapper.map(request, CreditCard.class); CreditCardDto
		 existCreditCard = creditCardService.findById(inputCreditCard.getId()); if
		 (existCreditCard != null) {
		 existCreditCard.setDailyLimit(inputCreditCard.getDailyLimit()); if
		 (creditCardService.changeDailyLimit(existCreditCard)) { HashMap res = new
		 HashMap(); res.put("data", existCreditCard); res.put("message",
		 "Change dailyLimit Successful."); res.put("status_code", 200); return new
		  ResponseEntity<>(res, HttpStatus.OK);
		 
			}
		}

		
		 HashMap res = new HashMap(); res.put("status_code", 422); res.put("message",
		 "Something went wrong."); return new ResponseEntity<>(res,
		 HttpStatus.BAD_REQUEST); }
		 

	@PutMapping(value = "/activate")
	public ResponseEntity<?> activate(@Valid @RequestBody CreditCardActivateRequest request, BindingResult result) {
		
		// invalid input 
		 if (result.hasErrors()) { throw new
		 ValidationException("Input creditcard id not correct", result); }
		 
		 CreditCard inputCreditCard = modelMapper.map(request, CreditCard.class);
		 CreditCardDto existCreditCard =
		 creditCardService.findById(inputCreditCard.getId()); if (existCreditCard !=
		 null) {
		  
		 // Check if card already deactivate if
		 if(existCreditCard.getStatus().equals("1")) 
		   { HashMap res = new HashMap();
		  res.put("status_code", 422); res.put("message",
		 "Input invalid, Can' activate because int already activate"); 
		  return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); }
		 

			// process deactivate service
			existCreditCard.setStatus(inputCreditCard.getStatus());
			if (creditCardService.activate(existCreditCard.getId())) {
				HashMap res = new HashMap();
				res.put("data", existCreditCard);
				res.put("message", "Operation, Activate  success");
				res.put("status_code", 200);
				return new ResponseEntity<>(res, HttpStatus.OK);
			}
		}

		HashMap res = new HashMap();
		
		 res.put("status_code", 500); res.put("message", "Something went wrong.");
		 return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST); }
		 

	
	@PutMapping(value = "/deactivate")
	public ResponseEntity<?> deactivate(@Valid @RequestBody CreditCardDeactivateRequest request, BindingResult result) {
		// invalid input
		if (result.hasErrors()) {
			throw new ValidationException("Input card id not correct", result);
		}

		CreditCard inputCreditCard = modelMapper.map(request, CreditCard.class);
		CreditCardDto existCreditCard = creditCardService.findById(inputCreditCard.getId());
		if (existCreditCard != null) {

			// Check if card already deactivate
			if (existCreditCard.getStatus().equals("0")) {
				HashMap res = new HashMap();
				res.put("status_code", 422);
				res.put("message", "Input invalid, Can' deactivate because int already deactivate");
				return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
			}

			// process deactivate service
			existCreditCard.setStatus(inputCreditCard.getStatus());
			if (creditCardService.deactivate(existCreditCard.getId())) {
				HashMap res = new HashMap();
				res.put("data", existCreditCard);
				res.put("message", "Operation, Deactivate  success");
				res.put("status_code", 200);
				return new ResponseEntity<>(res, HttpStatus.OK);

			}

		}

		HashMap res = new HashMap();
		res.put("status_code", 500);
		res.put("message", "Something went wrong.");
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}

}
