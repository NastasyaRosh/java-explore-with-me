package ru.practicum.ewmservice.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import ru.practicum.ewmservice.location.dto.LocationDto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewEventDto {
    @NotBlank
    @Size(min = 3, max = 120)
    private String title;
    @NotBlank
    @Size(min = 20, max = 2000)
    private String annotation;
    @NotBlank
    @Size(min = 20, max = 7000)
    private String description;
    @NotNull
    private Long category;
    @NotNull
    @Valid
    private LocationDto location;
    @NotNull
    @FutureOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime eventDate;
    private boolean paid;
    @PositiveOrZero
    private int participantLimit;
    private boolean requestModeration = true;


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewEventDto newEventDto = (NewEventDto) o;
        return Objects.equals(this.annotation, newEventDto.annotation) &&
                Objects.equals(this.category, newEventDto.category) &&
                Objects.equals(this.description, newEventDto.description) &&
                Objects.equals(this.eventDate, newEventDto.eventDate) &&
                Objects.equals(this.location, newEventDto.location) &&
                Objects.equals(this.paid, newEventDto.paid) &&
                Objects.equals(this.participantLimit, newEventDto.participantLimit) &&
                Objects.equals(this.requestModeration, newEventDto.requestModeration) &&
                Objects.equals(this.title, newEventDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                annotation,
                category,
                description,
                eventDate,
                location,
                paid,
                participantLimit,
                requestModeration,
                title
        );
    }

    @Override
    public String toString() {
        return "class NewEventDto {\n" +
                "    annotation: " + toIndentedString(annotation) + "\n" +
                "    category: " + toIndentedString(category) + "\n" +
                "    description: " + toIndentedString(description) + "\n" +
                "    eventDate: " + toIndentedString(eventDate) + "\n" +
                "    location: " + toIndentedString(location) + "\n" +
                "    paid: " + toIndentedString(paid) + "\n" +
                "    participantLimit: " + toIndentedString(participantLimit) + "\n" +
                "    requestModeration: " + toIndentedString(requestModeration) + "\n" +
                "    title: " + toIndentedString(title) + "\n" +
                "}";
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
