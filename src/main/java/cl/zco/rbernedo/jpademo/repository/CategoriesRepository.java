package cl.zco.rbernedo.jpademo.repository;

import cl.zco.rbernedo.jpademo.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesRepository extends CrudRepository<Category, Integer> {

}
