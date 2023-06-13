package restapicrud.restfulapicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapicrud.restfulapicrud.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
