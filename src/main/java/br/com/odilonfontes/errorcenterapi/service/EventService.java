package br.com.odilonfontes.errorcenterapi.service;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    Event save(Event event);
    Page<Event> findAll(Pageable pageable);

}
