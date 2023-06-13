package restapicrud.restfulapicrud.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import restapicrud.restfulapicrud.entity.Trainee;
import restapicrud.restfulapicrud.repository.TraineeRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Validated
@Service
@AllArgsConstructor
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepository;

    @Override
    public Trainee save(Trainee trainee){
        return traineeRepository.save(trainee);
    }

    @Override
    public List<Trainee> fetchAll() {
        return  traineeRepository.findAll();
    }

    @Override
    public Trainee getById(Long id){
        Optional<Trainee> trainee = traineeRepository.findById(id);
        return trainee.orElse(null);
    }

    @Override
    public Trainee updateById(Long id, Trainee trainee){

        Optional<Trainee> trainee1 = traineeRepository.findById(id);

        if (trainee1.isPresent()) {
            Trainee originalTrainee = trainee1.get();

            if (Objects.nonNull(trainee.getId()) && !"".equalsIgnoreCase(String.valueOf(trainee.getId()))) {
                originalTrainee.setId(trainee.getId());
            }
            if (trainee.getTrName() != null) {
                originalTrainee.setTrName(trainee.getTrName());
            }
            if (trainee.getTrBirthDate() != null) {
                originalTrainee.setTrBirthDate(trainee.getTrBirthDate());
            }
            if (trainee.getTrMentorId() != null) {
                originalTrainee.setTrMentorId(trainee.getTrMentorId());
            }
            if (trainee.getTrBirthDate() != null) {
                originalTrainee.setTrMentorsName(trainee.getTrMentorsName());
            }
            return traineeRepository.save(originalTrainee);
        }
        return null;
    }

    @Override
    public String deleteById(Long id){
        if (traineeRepository.findById(id).isPresent()) {
            traineeRepository.deleteById(id);
            return "Trainee deleted successfully";
        }
        return "No such trainee in the database";
    }
}
