package com.ordermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanager.domain.User;
import com.ordermanager.repository.entities.UserEntity;
import com.ordermanager.repository.repositories.UserEntityRepository;
import com.ordermanager.restservice.users.NewUserMapping;



@Service
public class UserServices {

	@Autowired
	private UserEntityRepository userEntityRepository;

	public User getUser(String userName,String userPassword) {
		
		return new User();
		
	}
	
	public UserEntity findUser(String userName) {
		
		List<UserEntity> list = userEntityRepository.findByUserName(userName.toLowerCase());
		
		if(list != null && list.size() == 1) {
			
			return list.get(0);
			
		} else {
			
			return null;
		}
	}
	
	public String createUser( NewUserMapping aUser) {
		
		try {
			
			System.out.println("Executing createUser in UserServices");
			
			List<UserEntity> list = userEntityRepository.findByUserName(aUser.getUserName().toLowerCase());
			
			if(list != null && list.size() == 0) {

				System.out.println("User is not created in the DB");

					UserEntity userEntity = new UserEntity();
					userEntity.setFirstName(aUser.getFirstName());
					userEntity.setLastName(aUser.getLastName());
					userEntity.setUserName(aUser.getUserName().toLowerCase());
					userEntity.setPassword(aUser.getPassword());
					userEntity.setRole(aUser.getRole());


					userEntityRepository.save(userEntity);


					return "USER_CREATED";


				
			} else {
				
				System.out.println("User is  created in the DB");
				System.out.println(list.get(0).getLastName());

				return "USER_ALREADY_EXISTS";
			}
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return "USER_NOT_CREATED";
			
		}
		
		
	}

    public String updateUser(NewUserMapping aUser) {
		try {

			System.out.println("Executing createUser in UserServices");

			List<UserEntity> list = userEntityRepository.findByUserName(aUser.getUserName().toLowerCase());

			if(list != null && list.size() == 0) {

				System.out.println("User is not created in the DB");

				return "USER_NOT_FOUND";

			} else {

				System.out.println("User is  created in the DB");
				System.out.println(list.get(0).getLastName());

				UserEntity userEntity = list.get(0);
				userEntity.setFirstName(aUser.getFirstName());
				userEntity.setLastName(aUser.getLastName());
				userEntity.setPassword(aUser.getPassword());
				userEntity.setRole(aUser.getRole());


				userEntityRepository.save(userEntity);

				return "USER_UPDATE";
			}

		}catch(Exception e) {

			e.printStackTrace();
			return "USER_NOT_FOUND";

		}



    }
}
