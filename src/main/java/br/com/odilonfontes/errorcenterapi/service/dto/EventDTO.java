package br.com.odilonfontes.errorcenterapi.service.dto;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.EventLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDTO implements Serializable {

    private Long id;

    @NotNull
    private String description;

    @NotNull
    private String log;

    @NotNull
    private String source;

    private String eventDate;

    @NotNull
    private EventLevel level;

    @NotNull
    private Integer quantity;

}
