package br.com.odilonfontes.errorcenterapi.service.specification;

import br.com.odilonfontes.errorcenterapi.domain.Event;
import br.com.odilonfontes.errorcenterapi.domain.enumeration.EventLevel;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;
import java.time.LocalDate;

public final class EventSpecification {

    public static Specification<Event> descriptionContains(String value) {
        return (value == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(criteriaBuilder.lower(root.get("description")),
                        criteriaBuilder.lower(criteriaBuilder.literal(contains(value)))
                );
    }

    public static Specification<Event> logContains(String value) {
        return (value == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(criteriaBuilder.lower(root.get("log")),
                        criteriaBuilder.lower(criteriaBuilder.literal(contains(value)))
                );
    }

    public static Specification<Event> sourceContains(String value) {
        return (value == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(criteriaBuilder.lower(root.get("source")),
                        criteriaBuilder.lower(criteriaBuilder.literal(contains(value)))
                );
    }

    public static Specification<Event> eventDateEqual(LocalDate value) {
        return (value == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("eventDate"), value);
    }

    public static Specification<Event> levelEqual(EventLevel value) {
        return (value == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("level"), value);
    }

    public static Specification<Event> quantityEqual(Integer value) {
        return (value == null) ? null : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.get("quantity"), value);
    }

    private static String contains(String value) {
        return (value == null) ? null : MessageFormat.format("%{0}%", value);
    }

}
