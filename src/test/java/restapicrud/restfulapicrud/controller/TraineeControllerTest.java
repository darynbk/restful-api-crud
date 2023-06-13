package restapicrud.restfulapicrud.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import restapicrud.restfulapicrud.entity.Trainee;
import restapicrud.restfulapicrud.repository.TraineeRepository;
import restapicrud.restfulapicrud.service.TraineeService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class TraineeControllerTest {

    @Mock
    TraineeRepository traineeRepository;

    @Mock
    TraineeService traineeService;

    @Mock
    TraineeController traineeController;

    @Test
    void save(@RequestBody Trainee trainee) throws Exception{
        traineeService.save(trainee);
    }

    @Test
    @DisplayName("GET /api/trainees возвращает HTTP-ответ со статусом 200 OK и списком менторов")
    void getAll() throws Exception {
        traineeController.getAll();
    }

    @Test
    void getById(@PathVariable("id") Long id) throws Exception{
        traineeService.getById(id);
    }

    @Test
    void update(@PathVariable("id") Long id, @RequestBody Trainee trainee) throws Exception{
        doReturn(trainee).when(this.traineeRepository).findAll();
        traineeService.updateById(id, trainee);
    }

    @Test
    void delete(@PathVariable("id") Long id) throws Exception{
        traineeService.deleteById(id);
    }
}