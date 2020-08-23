package br.com.odilonfontes.errorcenterapi.repository;

import br.com.odilonfontes.errorcenterapi.domain.LogEvent;
import br.com.odilonfontes.errorcenterapi.domain.enumeration.LogEventLevel;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface LogEventRepository extends PagingAndSortingRepository<LogEvent, Long>, JpaSpecificationExecutor<LogEvent> {

    Optional<LogEvent> findByDescriptionAndSourceAndEventDateAndLevel(String description,
                                                                      String source,
                                                                      LocalDate eventDate,
                                                                      LogEventLevel level);

}
