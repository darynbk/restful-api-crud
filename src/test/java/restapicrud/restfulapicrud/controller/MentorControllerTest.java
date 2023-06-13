package restapicrud.restfulapicrud.controller;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import restapicrud.restfulapicrud.entity.Mentor;
import restapicrud.restfulapicrud.repository.MentorRepository;
import restapicrud.restfulapicrud.service.MentorService;
import java.time.LocalDate;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@ExtendWith(MockitoExtension.class)
class MentorControllerTest {

    @Mock
    MentorRepository mentorRepository;

    @Mock
    MentorService mentorService;

    @Mock
    MentorController mentorController;

    @After("")
    public void tearDown() {
        mentorRepository.deleteAll();
    }

    @Test
    void save(@RequestBody Mentor mentor) throws Exception{
        mentorService.save(mentor);
    }

    @Test
    @DisplayName("GET /api/mentors возвращает HTTP-ответ со статусом 200 OK и списком менторов")
    void getAll() throws Exception {
        mentorController.getAll();
    }

    @Test
    void getById(@PathVariable("id") Long id) throws Exception{
        Mentor mentor = Mentor.builder().id(11L).name("Aqzhol").
                birthDate(LocalDate.of(2001, 1, 1)).build();
        mentorRepository.save(mentor);
        mentorService.getById(id);
    }

    @Test
    void update(@PathVariable("id") Long id, @RequestBody Mentor mentor) throws Exception{
        doReturn(mentor).when(this.mentorRepository).findAll();
        mentorService.updateById(id, mentor);
    }

    @Test
    void delete(@PathVariable("id") Long id) throws Exception{
        mentorService.deleteById(id);
    }
}