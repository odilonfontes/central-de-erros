package br.com.odilonfontes.errorcenterapi.service;

import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface EventService {

    EventDTO save(EventDTO eventDTO);
    Page<EventDTO> findAll(Pageable pageable, String description, String source, LocalDate eventDate);
    EventDTO findById(Long id);

}
