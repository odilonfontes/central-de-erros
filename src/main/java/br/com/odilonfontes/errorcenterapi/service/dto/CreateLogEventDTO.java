package br.com.odilonfontes.errorcenterapi.service.dto;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateLogEventDTO {

    @Size(max = 256)
    @NotNull @NotBlank
    private String description;

    @Size(max = 32767)
    @NotNull @NotBlank
    private String log;

    @Size(max = 256)
    @NotNull @NotBlank
    private String source;

    @NotNull
    private LogEventLevel level;

}
