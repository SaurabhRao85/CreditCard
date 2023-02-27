package com.axis.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.exception.IdNotFoundException;
import com.axis.model.CreditCard;
import com.axis.model.User;
import com.axis.repository.CreditCardRepository;
import com.axis.repository.UserRepository;
import com.axis.utility.AppConstant;

@Service
public class CreditCardServiceImpl implements CreditCardService {

   @Autowired
   private CreditCardRepository creditCardRepository;
   
   @Autowired
   private UserRepository userRepository;
   
    @Override
	public CreditCardDto addCreditCard(CreditCardDto creditCardDto) {
		
	 return convertToDto(creditCardRepository.save(convertToEntity(creditCardDto)));
	}
   
   @Override
	public List<CreditCardDto> getAllCreditCard() {
	   List<CreditCard> creditCards = creditCardRepository.findAll();
		
		List<CreditCardDto>  creditCardDtos = new ArrayList<CreditCardDto>();
		
		for(CreditCard creditCard :creditCards)
		{
			creditCardDtos.add(convertToDto(creditCard));
		}
			
			return creditCardDtos;
		}


	@Override
	public CreditCardDto findById(long id) {
		Optional<CreditCard> optCreditCard = creditCardRepository.findById(id);
	     
		   if(optCreditCard.isPresent())
			   return convertToDto(optCreditCard.get());
		   else   
		      throw new IdNotFoundException(AppConstant.ID_NOT_FOUND_MESSAGE);
	}
	
	  @Override
	  public List<CreditCardDto> findAllActiveByUserId(Long userId){
	        return creditCardRepository.findAllActiveByUserId(userId);
	    }

	@Override
	public boolean changeDailyLimit(CreditCardDto creditCardDto) {
		
		return creditCardRepository.changeDailyLimit(creditCardDto);
	}

	@Override
	public boolean activate(Long id) {
		
		return creditCardRepository.activate(id);
	}

	@Override
	public boolean deactivate(Long id) {
		
		return creditCardRepository.deactivate(id);
	}

	
	private CreditCardDto convertToDto(CreditCard creditCard)
	{
		CreditCardDto creditCardDto = new CreditCardDto();
		creditCardDto.setId(creditCard.getId());
		creditCardDto.setCardNumber(creditCard.getCardNumber());
		creditCardDto.setCardType(creditCard.getCardType());
		creditCardDto.setHolderName(creditCard.getHolderName());
		creditCardDto.setDailyLimit(creditCard.getDailyLimit());
		creditCardDto.setCsv(creditCard.getCsv());
		creditCardDto.setExpireDate(creditCard.getExpireDate());
		creditCardDto.setStatus(creditCard.getStatus());
		
		
		UserDto userDto = new UserDto();
		userDto.setId(creditCard.getUser().getId());
		userDto.setHolderName(creditCard.getUser().getHolderName());
		userDto.setAge(creditCard.getUser().getAge());
		userDto.setPassword(creditCard.getUser().getPassword());
		userDto.setRole(creditCard.getUser().getRole());
		userDto.setPhoneNumber(creditCard.getUser().getPhoneNumber());
		userDto.setAddress(creditCard.getUser().getAddress());
		userDto.setCity(creditCard.getUser().getCity());
		userDto.setState(creditCard.getUser().getState());
		userDto.setCountry(creditCard.getUser().getCountry());
		userDto.setPincode(creditCard.getUser().getPincode());
		userDto.setStatus(creditCard.getUser().getStatus());
		
		creditCardDto.setUserDto(userDto);	
		return creditCardDto;
	}
	
	private CreditCard convertToEntity(CreditCardDto creditCardDto)
	{
		CreditCard creditCard = new CreditCard();
		
		creditCard.setId(creditCardDto.getId());
		creditCard.setCardNumber(creditCardDto.getCardNumber());
		creditCard.setCardType(creditCardDto.getCardType());
		creditCard.setHolderName(creditCardDto.getHolderName());
		creditCard.setDailyLimit(creditCardDto.getDailyLimit());
		creditCard.setCsv(creditCardDto.getCsv());
		creditCard.setExpireDate(creditCardDto.getExpireDate());
		creditCard.setStatus(creditCardDto.getStatus());
		
		User user = new User();
		user.setId(creditCardDto.getUserDto().getId());
		user.setHolderName(creditCardDto.getUserDto().getHolderName());
		user.setAge(creditCardDto.getUserDto().getAge());
		user.setPassword(creditCardDto.getUserDto().getPassword());
		user.setRole(creditCardDto.getUserDto().getRole());
		user.setPhoneNumber(creditCardDto.getUserDto().getPhoneNumber());
		user.setAddress(creditCardDto.getUserDto().getAddress());
		user.setCity(creditCardDto.getUserDto().getCity());
		user.setState(creditCardDto.getUserDto().getState());
		user.setCountry(creditCardDto.getUserDto().getCountry());
		user.setPincode(creditCardDto.getUserDto().getPincode());
		user.setStatus(creditCardDto.getUserDto().getStatus());
		creditCard.setUser(user);
		return creditCard;
	}

	


	
	


	
	
}
