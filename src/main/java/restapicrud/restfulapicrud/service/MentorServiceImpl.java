package restapicrud.restfulapicrud.service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import restapicrud.restfulapicrud.entity.Mentor;
import restapicrud.restfulapicrud.repository.MentorRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Validated
@Service
@AllArgsConstructor
public class MentorServiceImpl implements MentorService{
    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public Mentor save(@Valid Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public List<Mentor> fetchAll() {
        return  mentorRepository.findAll();
    }

    @Override
    public Mentor getById(@Valid Long id){
        Optional<Mentor> mentor = mentorRepository.findById(id);
        return mentor.orElse(null);
    }

    @Override
    public Mentor updateById(@Valid Long id, Mentor mentor){

        Optional<Mentor> mentor1 = mentorRepository.findById(id);

        if (mentor1.isPresent()) {
            Mentor originalMentor = mentor1.get();

            if (Objects.nonNull(mentor.getId()) && !"".equalsIgnoreCase(String.valueOf(mentor.getId()))) {
                originalMentor.setId(mentor.getId());
            }
            if (mentor.getName() != null) {
                originalMentor.setName(mentor.getName());
            }
            if (mentor.getBirthDate() != null) {
                originalMentor.setBirthDate(mentor.getBirthDate());
            }
            return mentorRepository.save(originalMentor);
        }
        return null;
    }

    @Override
    public String deleteById(@Valid Long id){
        if (mentorRepository.findById(id).isPresent()) {
            mentorRepository.deleteById(id);
            return "Mentor deleted successfully";
        }
        return "No such mentor in the database";
    }

}
