package xast.sbertasks.SberCRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xast.sbertasks.SberCRUD.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
