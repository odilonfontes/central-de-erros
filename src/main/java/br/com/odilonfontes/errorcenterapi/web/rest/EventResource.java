package br.com.odilonfontes.errorcenterapi.web.rest;

import br.com.odilonfontes.errorcenterapi.service.EventService;
import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventResource {

    private final EventService eventService;

    public EventResource(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO) {
        EventDTO result = eventService.save(eventDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getEvents(@PageableDefault(size = 50) Pageable pageable,
                                                    @RequestParam(required = false) String description) {
        Page<EventDTO> result = eventService.findAll(pageable);
        return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long id) {
        EventDTO result = eventService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
