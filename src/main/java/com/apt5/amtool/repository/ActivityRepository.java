package com.apt5.amtool.repository;


import com.apt5.amtool.domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    @Override
    Iterable<Activity> findAllById(Iterable<Long> iterable);


}
