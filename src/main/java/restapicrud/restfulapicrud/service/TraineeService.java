package restapicrud.restfulapicrud.service;

import jakarta.validation.Valid;
import restapicrud.restfulapicrud.entity.Trainee;

import java.util.List;

public interface TraineeService {
    Trainee save(@Valid Trainee trainee) throws Exception;

    List<Trainee> fetchAll() throws Exception;

    Trainee updateById(@Valid Long id, Trainee trainee) throws Exception;

    Trainee getById(@Valid Long id) throws Exception;

    String deleteById(@Valid Long id) throws Exception;
}
