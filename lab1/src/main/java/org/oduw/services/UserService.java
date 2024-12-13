package org.oduw.services;

import org.oduw.controllers.dtos.LoginDto;
import org.oduw.controllers.dtos.RegisterDto;
import org.oduw.controllers.dtos.UpdateDto;
import org.oduw.models.User;

public interface UserService {

    User getById(Long id);

    User register(RegisterDto dto);

    User login(LoginDto dto);

   User deleteById(Long id);

   User updateById(Long id, UpdateDto dto);
}
