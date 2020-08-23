package br.com.odilonfontes.errorcenterapi.service.dto;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateLogEventDTO {

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String log;

    @NotNull
    @NotBlank
    private String source;

    @NotNull
    private LogEventLevel level;

}
