package com.ordermanager.services;

import com.ordermanager.domain.User;
import com.ordermanager.repository.entities.OrderEntity;

import com.ordermanager.repository.repositories.OrderEntityRepository;

import com.ordermanager.restservice.orders.NewOrderMapping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

@Service
public class OrderServices {

    @Autowired
    private OrderEntityRepository OrderEntityRepository;



    public String createOrder(NewOrderMapping order) {

        try {

            System.out.println("Executing createOrder in UserServices");

            List<OrderEntity> list = OrderEntityRepository.findByOrderReference(order.getOrderReference());

            if(list != null && list.size() == 0) {

                System.out.println("Order is not created in the DB");

                OrderEntity OrderEntity = new OrderEntity();
                OrderEntity.setOrderDate(order.getOrderDate());
                OrderEntity.setChecked(order.getChecked());
                OrderEntity.setOrderReference(order.getOrderReference());
                OrderEntity.setStatus(order.getStatus());



                OrderEntityRepository.save(OrderEntity);

                return "ORDER_CREATED";

            } else {

                System.out.println("ORDER is  created in the DB");
                System.out.println(list.get(0).getOrderReference());

                return "ORDER_ALREADY_EXISTS";
            }



        }catch(Exception e) {

            e.printStackTrace();
            return "ORDER_NOT_CREATED";

        }
    }

   /* public String updateOrder(boolean checked, String status) {

        try {

            OrderEntityRepository.updateOrder(checked,status);

            return "ORDER_UPDATE";
        }
        catch(Exception e) {
            return "ORDER_NOT_UPDATE";
        }

    }*/
}
