package br.com.odilonfontes.errorcenterapi.service.dto;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogEventCreatedDTO {

    private Long id;

    private String description;

    private String source;

    private String eventDate;

    private LogEventLevel level;

    private Integer quantity;

}
