package restapicrud.restfulapicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restapicrud.restfulapicrud.entity.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}
