package ru.krasnov.jetbrains.build_tracker_store.dao.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(name = "executed_build")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ExecutedBuild {

    @GeneratedValue
    @Id
    private UUID id;

    private String host;

    @Column(name = "requested_task_names")
    private String requestedTaskNames;

    @Column(name = "start_timestamp")
    private LocalDateTime buildStartTimestamp;

    @Column(name = "end_timestamp")
    private LocalDateTime buildEndTimestamp;

    @OneToMany(mappedBy = "build", cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<ExecutedTask> executedTasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExecutedBuild that = (ExecutedBuild) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
