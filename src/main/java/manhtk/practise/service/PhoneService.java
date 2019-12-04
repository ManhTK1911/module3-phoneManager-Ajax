package manhtk.practise.service;

import manhtk.practise.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {
    Iterable<Phone> findAll();
    Phone findById(Long id);
    void save(Phone phone);
    void remove(Long id);
}
