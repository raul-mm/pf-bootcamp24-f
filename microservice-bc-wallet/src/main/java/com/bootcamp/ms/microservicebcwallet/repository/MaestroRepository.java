package com.bootcamp.ms.microservicebcwallet.repository;

import com.bootcamp.ms.microservicebcwallet.domain.Maestro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaestroRepository extends CrudRepository<Maestro, Integer> {
}
