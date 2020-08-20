package br.com.odilonfontes.errorcenterapi.service.impl;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import br.com.odilonfontes.errorcenterapi.domain.enumeration.EventLevel;
import br.com.odilonfontes.errorcenterapi.repository.EventRepository;
import br.com.odilonfontes.errorcenterapi.service.EventService;
import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import br.com.odilonfontes.errorcenterapi.service.mapper.EventMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static br.com.odilonfontes.errorcenterapi.service.specification.EventSpecification.*;

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
    public Page<EventDTO> findAll(Pageable pageable, String description, String log, String source,
                                  LocalDate eventDate, EventLevel level, Integer quantity) {
        Specification<Event> specification = Specification.where(descriptionContains(description))
                .and(logContains(log))
                .and(sourceContains(source))
                .and(eventDateEqual(eventDate))
                .and(levelEqual(level))
                .and(quantityEqual(quantity));
        return eventRepository.findAll(specification, pageable).map(eventMapper::toListItemDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public EventDTO findById(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        return eventMapper.toDTO(event);
    }

}
