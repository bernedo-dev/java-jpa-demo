package cl.zco.rbernedo.jpademo.repository;

import cl.zco.rbernedo.jpademo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
