package ru.practicum.ewmservice.request.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCounter {
    private Long eventId;
    private Long count;
}
