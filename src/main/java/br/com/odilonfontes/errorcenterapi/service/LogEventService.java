package br.com.odilonfontes.errorcenterapi.service;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import br.com.odilonfontes.errorcenterapi.service.dto.CreateLogEventDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventCreatedDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventInfoDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventItemListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface LogEventService {

    LogEventCreatedDTO save(CreateLogEventDTO createLogEventDTO);

    Page<LogEventItemListDTO> findAll(Pageable pageable, String description, String log, String source,
                                      LocalDate eventDate, LogEventLevel level, Integer quantity);

    LogEventInfoDTO findById(Long id);

}
