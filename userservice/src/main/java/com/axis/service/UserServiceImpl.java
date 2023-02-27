package com.axis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dto.CreditCardDto;
import com.axis.dto.UserDto;
import com.axis.model.CreditCard;
import com.axis.model.User;
import com.axis.repository.CreditCardRepository;
import com.axis.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		
		return convertToDto(userRepository.save(convertToEntity(userDto)));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users=	userRepository.findAll();
		
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(User user :users)
		{
			userDtos.add(convertToDto(user));
		}
			
			return userDtos;
			
		}
	

	@Override
	public UserDto getUserById(int id) {
		
		return null;
	}

	@Override
	public UserDto updateUserByUserID(long id, UserDto userDto) {
		
		return null;
	}

	@Override
	public void deleteUserByUserId(long id) {
		
		
	}

	private UserDto convertToDto(User user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setHolderName(user.getHolderName());
		userDto.setAge(user.getAge());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());
		userDto.setAddress(user.getAddress());
		userDto.setCity(user.getCity());
		userDto.setState(user.getState());
		userDto.setCountry(user.getCountry());
		userDto.setPincode(user.getPincode());
		userDto.setStatus(user.getStatus());
		userDto.setCreatedAt(user.getCreatedAt());
		
		CreditCardDto creditCardDto = new CreditCardDto();
		creditCardDto.setId(user.getCreditCard().getId());
		creditCardDto.setCardNumber(user.getCreditCard().getCardNumber());
		creditCardDto.setHolderName(user.getCreditCard().getHolderName());
		creditCardDto.setCardType(user.getCreditCard().getCardType());
		creditCardDto.setCsv(user.getCreditCard().getCsv());
		creditCardDto.setDailyLimit(user.getCreditCard().getDailyLimit());
		creditCardDto.setExpireDate(user.getCreditCard().getExpireDate());
		creditCardDto.setStatus(user.getCreditCard().getStatus());

		userDto.setCreditCardDto(creditCardDto);
		return userDto;
	}
	
	private User convertToEntity(UserDto userDto)
	{
		User user = new User();
		user.setId(userDto.getId());
		user.setHolderName(userDto.getHolderName());
		user.setAge(userDto.getAge());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setPassword(userDto.getPassword());
		user.setRole(userDto.getRole());
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setCountry(userDto.getCountry());
		user.setPincode(userDto.getPincode());
		user.setStatus(userDto.getStatus());
		user.setCreatedAt(userDto.getCreatedAt());
		
		
		CreditCard creditCard = new CreditCard();
		CreditCardDto creditCardDto = new CreditCardDto();
		creditCard.setId(userDto.getCreditCardDto().getId());
		creditCard.setCardNumber(userDto.getCreditCardDto().getCardNumber());
		creditCard.setHolderName(userDto.getCreditCardDto().getHolderName());
		creditCard.setCardType(userDto.getCreditCardDto().getCardType());
		creditCard.setCsv(userDto.getCreditCardDto().getCsv());
		creditCard.setDailyLimit(userDto.getCreditCardDto().getDailyLimit());
		creditCard.setExpireDate(userDto.getCreditCardDto().getExpireDate());
		creditCard.setStatus(userDto.getCreditCardDto().getStatus());

		
		user.setCreditCard(creditCard);
		
		return user;
	}
}
