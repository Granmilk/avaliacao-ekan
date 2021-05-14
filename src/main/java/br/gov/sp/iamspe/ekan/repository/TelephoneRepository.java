package br.gov.sp.iamspe.ekan.repository;

import br.gov.sp.iamspe.ekan.domain.TelephoneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TelephoneRepository extends CrudRepository<TelephoneEntity, Long> {
}
