package br.com.odilonfontes.errorcenterapi.service.mapper;

import br.com.odilonfontes.errorcenterapi.domain.LogEvent;
import br.com.odilonfontes.errorcenterapi.service.dto.CreateLogEventDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventCreatedDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventInfoDTO;
import br.com.odilonfontes.errorcenterapi.service.dto.LogEventItemListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface LogEventMapper {

    @Mapping(source = "eventDate", target = "eventDate", dateFormat = "yyyy-MM-dd")
    LogEventCreatedDTO toCreatedDTO(LogEvent logEvent);

    @Mapping(source = "eventDate", target = "eventDate", dateFormat = "yyyy-MM-dd")
    LogEventInfoDTO toInfoDTO(LogEvent logEvent);

    @Mapping(source = "eventDate", target = "eventDate", dateFormat = "yyyy-MM-dd")
    LogEventItemListDTO toItemListDTO(LogEvent logEvent);

    @Mapping(target = "quantity", ignore = true, source = "")
    @Mapping(target = "id", ignore = true, source = "")
    @Mapping(target = "eventDate", ignore = true, source = "")
    LogEvent toEntity(CreateLogEventDTO createLogEventDTO);

}
