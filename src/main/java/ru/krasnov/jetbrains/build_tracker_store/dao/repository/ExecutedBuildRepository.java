package ru.krasnov.jetbrains.build_tracker_store.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.krasnov.jetbrains.build_tracker_store.dao.entity.ExecutedBuild;

import java.util.UUID;

public interface ExecutedBuildRepository extends JpaRepository<ExecutedBuild, UUID> {
}
