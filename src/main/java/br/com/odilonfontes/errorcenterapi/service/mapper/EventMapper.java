package br.com.odilonfontes.errorcenterapi.service.mapper;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface EventMapper {

    @Mapping(source = "eventDate", target = "eventDate", dateFormat = "yyyy-MM-dd")
    EventDTO toDTO(Event event);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "eventDate", ignore = true)
    @Mapping(target = "quantity", ignore = true)
    Event toEntity(EventDTO eventDTO);

}
