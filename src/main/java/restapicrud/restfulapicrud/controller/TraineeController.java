package restapicrud.restfulapicrud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restapicrud.restfulapicrud.service.TraineeService;
import restapicrud.restfulapicrud.entity.Trainee;

import java.util.List;

@Tag(name = "Стажеры", description = "Методы для работы со стажерами")
@RestController
@RequestMapping("/api/trainees")
@AllArgsConstructor
public class TraineeController {
    @Autowired
    private TraineeService traineeService;

    @PostMapping("/")
    @Operation(summary = "Внесение нового стажера")
    public Trainee save(@RequestBody Trainee trainee) throws Exception{
        return traineeService.save(trainee);
    }

    @GetMapping("/")
    @Operation(summary = "Получить информацию про всех стажеров")
    public List<Trainee> getAll() throws Exception{
        return traineeService.fetchAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить информацию про стажере по ID")
    public Trainee getById(@PathVariable("id") Long id) throws Exception{
        return traineeService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить информацию про стажере по ID")
    public Trainee update(@PathVariable("id") Long id, @RequestBody Trainee trainee) throws Exception{
        return traineeService.updateById(id, trainee);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить информацию о стажере по ID")
    public String delete(@PathVariable("id") Long id) throws Exception{
        return traineeService.deleteById(id);
    }
}
