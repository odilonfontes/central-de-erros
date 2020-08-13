package br.com.odilonfontes.errorcenterapi.service;

import br.com.odilonfontes.errorcenterapi.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);
    Page<User> findAll(Pageable pageable);

}
