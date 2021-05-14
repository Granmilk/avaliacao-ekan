package br.gov.sp.iamspe.ekan.repository;

import br.gov.sp.iamspe.ekan.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
