package ru.practicum.ewmservice.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.ewmservice.request.model.Request;
import ru.practicum.ewmservice.request.model.RequestCounter;
import ru.practicum.ewmservice.request.property.RequestStatus;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(
            "select count(r) " +
                    "from Request r " +
                    "where r.event.id = ?1 " +
                    "and r.status = ?2"
    )
    Integer findCountRequestsByEventIdAndStatus(Long eventId, RequestStatus status);

    @Query(
            value = "SELECT new ru.practicum.ewmservice.request.model.RequestCounter(r.event.id, COUNT(r)) " +
                    "from Request r " +
                    "where r.event.id in ?1 " +
                    "and r.status = ?2 " +
                    "group by r.event.id "
    )
    List<RequestCounter> findCountRequestsByEventIdsAndStatus(List<Long> eventIds, RequestStatus status);

    List<Request> findByEventIdAndEventInitiatorId(Long eventId, Long userId);

    List<Request> findByIdIn(List<Long> ids);

    List<Request> findByRequesterId(Long id);

    Boolean existsByEventIdAndRequesterId(Long eventId, Long requesterId);
}