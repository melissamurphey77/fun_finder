package org.launchcode.fun_finder.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ParkDao extends CrudRepository<Park, Integer> {
    void delete(int parkId);
}
