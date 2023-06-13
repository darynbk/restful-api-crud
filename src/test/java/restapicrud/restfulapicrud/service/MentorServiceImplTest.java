package restapicrud.restfulapicrud.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restapicrud.restfulapicrud.repository.MentorRepository;

@ExtendWith(MockitoExtension.class )
public class MentorServiceImplTest {

    @Mock
    private MentorRepository mentorRepository;

    @InjectMocks
    private MentorServiceImpl mentorService;

    @Test
    public void shouldReturnSave(){

    }

    @Test
    void fetchAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void deleteById() {
    }
}
