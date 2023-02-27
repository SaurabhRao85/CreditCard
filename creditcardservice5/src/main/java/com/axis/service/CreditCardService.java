package com.axis.service;

import java.util.List;
import java.util.Optional;

import com.axis.dto.CreditCardDto;
import com.axis.model.CreditCard;

public interface CreditCardService {

	 public CreditCardDto addCreditCard(CreditCardDto creditCardDto);
	
	  public List<CreditCardDto> getAllCreditCard();
	  
	  public List<CreditCardDto> findAllActiveByUserId(Long userId);
	  
	  public boolean changeDailyLimit(CreditCardDto creditCardDto);
	  
	  public boolean activate(Long id);
	  
	  public boolean deactivate(Long id);

	public CreditCardDto findById(long id);

	
	
	        


	  
	  
	
	

	
	
	
}
