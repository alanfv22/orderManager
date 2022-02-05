package com.ordermanager.repository.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ordermanager.repository.entities.UserEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {

	List<UserEntity> findByUserName(String userName);
}
