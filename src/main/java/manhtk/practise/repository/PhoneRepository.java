package manhtk.practise.repository;

import manhtk.practise.model.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone, Long> {
}
