package ru.krasnov.jetbrains.build_tracker_store.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Table(name = "executed_task")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ExecutedTask {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "build_id")
    private ExecutedBuild build;

    private String name;

    @Column(name = "start_timestamp")
    private LocalDateTime executionStartTimestamp;

    @Column(name = "end_timestamp")
    private LocalDateTime executionEndTimestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExecutedTask that = (ExecutedTask) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
