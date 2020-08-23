package br.com.odilonfontes.errorcenterapi.service.impl;

import br.com.odilonfontes.errorcenterapi.domain.LogEvent;
import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import br.com.odilonfontes.errorcenterapi.repository.LogEventRepository;
import br.com.odilonfontes.errorcenterapi.service.LogEventService;
import br.com.odilonfontes.errorcenterapi.service.dto.CreateLogEventDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventCreatedDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventInfoDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventItemListDTO;
import br.com.odilonfontes.errorcenterapi.service.mapper.LogEventMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static br.com.odilonfontes.errorcenterapi.service.specification.LogEventSpecification.*;

@Service
@Transactional
public class LogLogEventServiceImpl implements LogEventService {

    private final LogEventRepository logEventRepository;
    private final LogEventMapper logEventMapper;

    public LogLogEventServiceImpl(LogEventRepository logEventRepository, LogEventMapper logEventMapper) {
        this.logEventRepository = logEventRepository;
        this.logEventMapper = logEventMapper;
    }

    @Override
    public LogEventCreatedDTO save(CreateLogEventDTO createLogEventDTO) {
        LogEvent logEvent = generateLogEvent(createLogEventDTO);
        logEvent = logEventRepository.save(logEvent);
        return logEventMapper.toCreatedDTO(logEvent);
    }

    private LogEvent generateLogEvent(CreateLogEventDTO createLogEventDTO) {
        String description = createLogEventDTO.getDescription();
        String source = createLogEventDTO.getSource();
        LogEventLevel level = createLogEventDTO.getLevel();

        LogEvent logEvent = logEventRepository.findByDescriptionAndSourceAndEventDateAndLevel(description, source,
                LocalDate.now(), level).orElse(logEventMapper.toEntity(createLogEventDTO));

        if (logEvent.getId() != null) {
            logEvent.increaseQuantity();
        }

        return logEvent;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LogEventItemListDTO> findAll(Pageable pageable, String description, String log, String source,
                                             LocalDate eventDate, LogEventLevel level, Integer quantity) {
        Specification<LogEvent> specification = Specification.where(descriptionContains(description))
                .and(logContains(log))
                .and(sourceContains(source))
                .and(eventDateEqual(eventDate))
                .and(levelEqual(level))
                .and(quantityEqual(quantity));
        return logEventRepository.findAll(specification, pageable).map(logEventMapper::toItemListDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public LogEventInfoDTO findById(Long id) {
        LogEvent logEvent = logEventRepository.findById(id).orElse(null);
        return logEventMapper.toInfoDTO(logEvent);
    }

}
