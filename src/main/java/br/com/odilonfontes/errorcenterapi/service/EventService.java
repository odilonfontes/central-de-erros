package br.com.odilonfontes.errorcenterapi.service;

import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    EventDTO save(EventDTO eventDTO);
    Page<EventDTO> findAll(Pageable pageable);

}
