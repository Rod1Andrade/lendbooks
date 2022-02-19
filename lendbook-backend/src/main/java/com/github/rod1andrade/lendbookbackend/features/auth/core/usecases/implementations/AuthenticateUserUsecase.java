package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.implementations;

import java.util.Optional;
import java.util.function.BiPredicate;

import com.github.rod1andrade.lendbookbackend.features.auth.core.entities.User;
import com.github.rod1andrade.lendbookbackend.features.auth.core.enums.UserStatus;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.UserCredentialException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.UserNotActiveException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.exceptions.UserNotFoundException;
import com.github.rod1andrade.lendbookbackend.features.auth.core.repositories.IQueryUserRepository;
import com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces.IAuthenticateUserUsecase;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.UUID;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author rodri
 *
 */
@RequiredArgsConstructor
public class AuthenticateUserUsecase implements IAuthenticateUserUsecase {

	private final BiPredicate<String, String> compareFunctions; 
	private final IQueryUserRepository queryUserRepository;
	
	@Override
	public UUID apply(Email email, Password password) {
		Optional<User> userOptional = Optional.ofNullable(queryUserRepository.findByEmail(email));
		if(userOptional.isEmpty()) {
			throw new UserNotFoundException("User " + email.getValue()  + " not exists");
		}

		var user = userOptional.orElseThrow();
		if(user.getStatus().getUserStatus().equals(UserStatus.UNACTIVATE))
			throw new UserNotActiveException("User is not active.");

		if (!user.getPassword().check(password, compareFunctions))
			throw new UserCredentialException("Not valid credentials");

		return user.getUuid();
	}

}
