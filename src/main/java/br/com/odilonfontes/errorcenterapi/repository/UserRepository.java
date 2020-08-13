package br.com.odilonfontes.errorcenterapi.repository;

import br.com.odilonfontes.errorcenterapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
