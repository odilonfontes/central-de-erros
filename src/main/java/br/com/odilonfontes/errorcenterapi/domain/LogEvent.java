package br.com.odilonfontes.errorcenterapi.domain;

import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "log_event", uniqueConstraints = @UniqueConstraint(columnNames = {"description", "source", "event_date",
        "level"}, name = "uk_event"))
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AllArgsConstructor
@Data
@Builder
public class LogEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    public LogEvent() {
        quantity = 1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(updatable = false)
    @Size(max = 256)
    @NotNull @NotBlank
    private String description;

    @Column(updatable = false)
    @Size(max = 32767)
    @NotNull @NotBlank
    private String log;

    @Column(updatable = false)
    @Size(max = 256)
    @NotNull @NotBlank
    private String source;

    @Column(updatable = false)
    @NotNull
    private LogEventLevel level;

    @Column(name = "event_date", updatable = false)
    @NotNull
    @CreatedDate
    @Setter(value = AccessLevel.NONE)
    private LocalDate eventDate;

    @NotNull
    @Setter(value = AccessLevel.NONE)
    private Integer quantity;

    public void increaseQuantity() {
        quantity += 1;
    }

}
