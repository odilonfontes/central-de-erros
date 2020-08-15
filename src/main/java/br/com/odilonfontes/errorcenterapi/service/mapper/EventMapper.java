package br.com.odilonfontes.errorcenterapi.service.mapper;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import br.com.odilonfontes.errorcenterapi.service.dto.EventDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface EventMapper {

    @Mapping(source = "createdAt", target = "eventDate", dateFormat = "yyyy-MM-dd HH:mm")
    EventDTO toDTO(Event event);

    @Mapping(source = "eventDate", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm")
    Event toEntity(EventDTO eventDTO);

}
