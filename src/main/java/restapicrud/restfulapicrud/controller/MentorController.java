package restapicrud.restfulapicrud.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import restapicrud.restfulapicrud.entity.Mentor;
import restapicrud.restfulapicrud.service.MentorService;

import java.util.List;

@Validated
@Tag(name = "Менторы", description = "Методы для работы с менторами")
@RestController
@RequestMapping("/api/mentors")
@AllArgsConstructor
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping("/")
    @Operation(summary = "Внесение нового ментора")
    public Mentor save(@Valid @RequestBody Mentor mentor) throws Exception{
        return mentorService.save(mentor);
    }

    @GetMapping("/")
    @Operation(summary = "Получить информацию обо всех менторов")
    public List<Mentor> getAll() throws Exception{
        return mentorService.fetchAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить информацию о менторе по ID")
    public Mentor getById(@Valid @PathVariable("id") Long id) throws Exception{
        return mentorService.getById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить информацию о менторе по ID")
    public Mentor update(@Valid @PathVariable("id") Long id, @RequestBody Mentor mentor) throws Exception{
        return mentorService.updateById(id, mentor);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить инфоомацию о менторе по ID")
    public String delete(@Valid @PathVariable("id") Long id) throws Exception{
        return mentorService.deleteById(id);
    }
}
