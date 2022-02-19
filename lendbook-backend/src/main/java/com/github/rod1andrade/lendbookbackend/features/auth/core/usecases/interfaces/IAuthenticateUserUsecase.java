package com.github.rod1andrade.lendbookbackend.features.auth.core.usecases.interfaces;

import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Email;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.Password;
import com.github.rod1andrade.lendbookbackend.features.auth.core.valueobjects.UUID;

/**
 * 
 * @author rodri
 *
 */
public interface IAuthenticateUserUsecase {
	UUID apply(Email email, Password password);
}
