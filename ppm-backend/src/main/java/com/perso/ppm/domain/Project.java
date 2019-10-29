package com.perso.ppm.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Project code is mandatory")
    @Column(unique = true, length = 32)
    private String code;

    @NotNull(message = "Project title is mandatory")
    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    private Date deadline;

    public Project() {
    }

    public Project(@NotBlank(message = "Project code is mandatory") String code, @NotBlank(message = "Project title is mandatory") String title,
                   String description, Date createdAt, Date deadline) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.deadline = deadline;
    }
}
