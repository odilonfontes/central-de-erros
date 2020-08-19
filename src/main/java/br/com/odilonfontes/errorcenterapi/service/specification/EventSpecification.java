package br.com.odilonfontes.errorcenterapi.service.specification;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;
import java.time.LocalDate;

public final class EventSpecification {

    public static Specification<Event> descriptionContains(String argument) {
        return (argument == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(criteriaBuilder.lower(root.get("description")),
                        criteriaBuilder.lower(criteriaBuilder.literal(contains(argument)))
                );
    }

    public static Specification<Event> sourceContains(String argument) {
        return (argument == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(criteriaBuilder.lower(root.get("source")),
                        criteriaBuilder.lower(criteriaBuilder.literal(contains(argument)))
                );
    }

    public static Specification<Event> eventDateEqual(LocalDate argument) {
        return (argument == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("eventDate"), argument);
    }

    private static String contains(String argument) {
        return (argument == null) ? null : MessageFormat.format("%{0}%", argument);
    }

}
