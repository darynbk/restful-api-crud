package restapicrud.restfulapicrud.service;

import jakarta.validation.Valid;
import restapicrud.restfulapicrud.entity.Mentor;

import java.util.List;

public interface MentorService {
    Mentor save(@Valid Mentor mentor) throws Exception;

    List<Mentor> fetchAll() throws Exception;

    Mentor updateById(@Valid Long id, Mentor mentor) throws Exception;

    Mentor getById(@Valid Long id) throws Exception;

    String deleteById(@Valid Long id) throws Exception;
}
