package com.axis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.axis.dto.CreditCardDto;
import com.axis.model.CreditCard;


public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

	boolean activate(Long id);

	boolean deactivate(Long id);

	boolean changeDailyLimit(CreditCardDto creditCardDto);

	List<CreditCardDto> findAllActiveByUserId(Long userId);
	
	

	//List<CreditCardDto> getAllActiveByConsumerId(Long consumerId);

	//Optional<CreditCard> getActiveById(Long id);
	
	// CreditCard getById(Long id);

	//boolean changeDailyLimit(CreditCard creditCard);

	//boolean activate(Long id);

	//boolean deactivate(Long id);
	
	


	
}
