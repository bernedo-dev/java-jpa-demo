package cl.zco.rbernedo.jpademo.repository;

import cl.zco.rbernedo.jpademo.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobsRepository extends JpaRepository<Job, Integer> {

    List<Job> findByStatus(String status);

    List<Job> findByFeaturedAndStatusOrderByIdDesc(int featured, String status);

    List<Job> findBySalaryBetweenOrderBySalaryDesc(double min, double max);

    List<Job> findByStatusIn(String[] states);

}
