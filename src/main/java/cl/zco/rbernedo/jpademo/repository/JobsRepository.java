package cl.zco.rbernedo.jpademo.repository;

import cl.zco.rbernedo.jpademo.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job, Integer> {
}
