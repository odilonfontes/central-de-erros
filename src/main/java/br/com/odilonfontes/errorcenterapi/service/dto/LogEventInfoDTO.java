package br.com.odilonfontes.errorcenterapi.service.dto;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogEventInfoDTO implements Serializable {

    private Long id;

    private String description;

    private String log;

    private String source;

    private String eventDate;

    private LogEventLevel level;

    private Integer quantity;

}
