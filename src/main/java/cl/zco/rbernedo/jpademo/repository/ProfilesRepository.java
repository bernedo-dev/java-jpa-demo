package cl.zco.rbernedo.jpademo.repository;

import cl.zco.rbernedo.jpademo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository  extends JpaRepository<Profile, Integer> {
}
