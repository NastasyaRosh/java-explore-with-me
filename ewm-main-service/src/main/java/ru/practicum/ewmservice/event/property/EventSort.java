package ru.practicum.ewmservice.event.property;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EventSort {
    EVENT_DATE("eventDate"),
    VIEWS("views");

    private final String value;
}
