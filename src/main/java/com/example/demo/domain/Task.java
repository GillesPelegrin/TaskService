package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.example.demo.util.DateTimeWrapper.currentDateTime;
import static com.example.demo.util.ExceptionUtil.isNotNull;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "creationdate")
    private LocalDateTime creationDate;

    @Column(name = "updatedate")
    private LocalDateTime updateDate;

    private Task(Long id, String title, String message, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.creationDate = currentDateTime();
        this.updateDate = currentDateTime();

        validate();
    }

    private void validate() {
        isNotNull(this.title, "title is required in Task");
        isNotNull(this.message, "message is required in Task");
    }
}
