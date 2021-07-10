package cl.zco.rbernedo.jpademo.repository;

import cl.zco.rbernedo.jpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
