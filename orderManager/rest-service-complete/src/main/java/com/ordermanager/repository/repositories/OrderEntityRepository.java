package com.ordermanager.repository.repositories;


import java.util.List;

import com.ordermanager.repository.entities.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, Integer> {

     List<OrderEntity> findByOrderReference(String orderReference);


     List <OrderEntity> findById(int id);

     //otra forma

    /* @Query( value = "SElECT o from OrderEntity WHERE o.ID LIKE %:id%")
     List <OrderEntity> searchById(@Param("id") int id);


     @Query("update orderEntity o set o.checked = ?1 where o.status = ?2")
     public  OrderEntity updateOrder(boolean checked, String status);*/



}

