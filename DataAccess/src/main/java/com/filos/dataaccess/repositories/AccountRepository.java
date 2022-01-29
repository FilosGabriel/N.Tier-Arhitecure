package com.filos.dataaccess.repositories;

import com.filos.core.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, UUID> {

    Optional<AccountEntity> findByName(String name);
}
