package com.mariadesk.repositories;

import com.mariadesk.models.Call;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallsRepository extends CrudRepository<Call, Long> {

}
