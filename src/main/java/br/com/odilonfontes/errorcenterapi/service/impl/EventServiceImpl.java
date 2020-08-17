package br.com.odilonfontes.errorcenterapi.service.impl;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import br.com.odilonfontes.errorcenterapi.repository.EventRepository;
import br.com.odilonfontes.errorcenterapi.service.EventService;
import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import br.com.odilonfontes.errorcenterapi.service.mapper.EventMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        LocalDate currentDate = LocalDate.now();
        Event event = eventRepository.findByDescriptionAndSourceAndEventDateAndLevel(
                eventDTO.getDescription(), eventDTO.getSource(), currentDate, eventDTO.getLevel())
                .orElse(eventMapper.toEntity(eventDTO));

        if (event.getId() != null) {
            event.increaseQuantity();
        }

        event = eventRepository.save(event);
        return eventMapper.toDTO(event);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EventDTO> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable)
                .map(eventMapper::toDTO);
    }

}
