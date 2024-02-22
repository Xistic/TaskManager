package org.tmanager.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tmanager.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
