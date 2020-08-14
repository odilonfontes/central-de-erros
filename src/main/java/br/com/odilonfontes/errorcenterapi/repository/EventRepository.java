package br.com.odilonfontes.errorcenterapi.repository;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}
