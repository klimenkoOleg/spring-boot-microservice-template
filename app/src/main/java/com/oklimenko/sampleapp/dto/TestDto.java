package com.oklimenko.sampleapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.oklimenko.sampleapp.util.DateFormat.DATE_WITH_TIME_PATTERN;
import static com.oklimenko.sampleapp.util.DateFormat.TIMEZONE;

/**
 * Successful result details
 */
@JsonInclude(NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class TestDto {

  private UUID id;
  private String name;
  @JsonFormat(shape = STRING, pattern = DATE_WITH_TIME_PATTERN, timezone = TIMEZONE)
  private LocalDateTime timestamp;
}
