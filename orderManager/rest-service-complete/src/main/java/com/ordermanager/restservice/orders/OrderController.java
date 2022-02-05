package com.ordermanager.restservice.orders;


import com.ordermanager.restservice.users.NewUserMapping;
import com.ordermanager.restservice.users.NewUserResponse;
import com.ordermanager.services.OrderServices;
import com.ordermanager.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanager.repository.entities.OrderEntity;
import com.ordermanager.restservice.ApplicationConstants;
import com.ordermanager.services.OrderServices;

import com.ordermanager.domain.Order;
import com.ordermanager.restservice.ApplicationConstants;


/* Esta anotacion sirve para declarar los servicios del backend. Servicios Rest */
@RestController
public class OrderController {
	@Autowired
	private OrderServices orderServices = null;

	@PostMapping(ApplicationConstants.ORDERS_ROUTE) // creacion de orden
	NewOrderResponse createOrder(@RequestBody NewOrderMapping order) {

		NewOrderResponse newOrderResponse = new NewOrderResponse();

		try {

			// Objeto que crea en la base de datos al usuario.
			String responseCode  = orderServices.createOrder(order);

			newOrderResponse.setResponseCode(responseCode);

			return newOrderResponse;


		} catch (Exception e) {

			e.printStackTrace();
			newOrderResponse.setResponseCode("ORDER_NOT_CREATED");
			return newOrderResponse;


		}


	}

	
	@GetMapping(ApplicationConstants.ORDERS_ROUTE)
	public Order getOrderById(@RequestParam(value = "orderId", defaultValue = "none") String name) {
		return new Order();
	}
	
	/* http://localhost:8080/orders?checked=true&approved=NOT_APPROVED&dateFrom=112243243243&dateTo=4242432423 */
	@GetMapping("/ordersByFilter")
	public Order[] getOrderByFilter(
			@RequestParam(value = "checked", defaultValue = "none") boolean checked,
			@RequestParam(value = "approved", defaultValue = "none") String approved,
			@RequestParam(value = "dateFrom", defaultValue = "none") String dateFrom,
			@RequestParam(value = "dateTo", defaultValue = "none") String dateTo
			
			) {
	
		
		System.out.println("dateFrom = " + dateFrom);
		System.out.println("dateTo = " + dateTo);
		
		
		Order[] orders = new Order[2];
		
		orders[0] = new Order();
		orders[1] = new Order();
		
		/* caso real se llama al modulo que se conecta a la base de datos y trae los datos segun el filtro*/
		
		
		return orders;
	
	}
	
	
	@PutMapping(ApplicationConstants.ORDERS_ROUTE)
	UpdateOrderResponse  updateOrder(@RequestBody UpdateOrderMapping orderUpdateData) {
		
		UpdateOrderResponse updateOrderResponse = new UpdateOrderResponse();
		
	    try {
			
	    	// TODO el actualizar el user en la base de datos
	    	
	    	// Se indica que todo fue Ok.
	    	updateOrderResponse.setResponseCode("ORDER_UPDATED");

	    	return updateOrderResponse;
	    	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			updateOrderResponse.setResponseCode("ORDER_NOT_UPDATED");
	    	return updateOrderResponse;

			
		}
	    
	    
	  }

}
