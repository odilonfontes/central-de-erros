package br.com.odilonfontes.errorcenterapi.web.rest;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import br.com.odilonfontes.errorcenterapi.service.LogEventService;
import br.com.odilonfontes.errorcenterapi.service.dto.CreateLogEventDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventCreatedDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventInfoDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventItemListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LogEventResource {

    private final LogEventService logEventService;

    public LogEventResource(LogEventService logEventService) {
        this.logEventService = logEventService;
    }

    @PostMapping("/log-events")
    public ResponseEntity<LogEventCreatedDTO> createEvent(@Valid @RequestBody CreateLogEventDTO createLogEventDTO) {
        LogEventCreatedDTO result = logEventService.save(createLogEventDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/log-events")
    public ResponseEntity<List<LogEventItemListDTO>> getEvents(@PageableDefault Pageable pageable,
                                                               @RequestParam(required = false) String description,
                                                               @RequestParam(required = false) String log,
                                                               @RequestParam(required = false) String source,
                                                               @RequestParam(required = false) LocalDate eventDate,
                                                               @RequestParam(required = false) LogEventLevel level,
                                                               @RequestParam(required = false) Integer quantity) {
        Page<LogEventItemListDTO> result = logEventService.findAll(pageable, description, log, source, eventDate, level, quantity);
        return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
    }

    @GetMapping("/log-events/{id}")
    public ResponseEntity<LogEventInfoDTO> getEvent(@PathVariable Long id) {
        LogEventInfoDTO result = logEventService.findById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
