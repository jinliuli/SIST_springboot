package com.test.jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.jpa.entity.Address;
import com.test.jpa.repository.AddressRepository;

@SpringBootTest
public class JAPTest {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	public void testRepository() {
		
		assertNotNull(addressRepository);
		
		//'Optional'은 프로그램 안정성때문에 생긴 안전장치임
		Optional<Address> address = addressRepository.findById(1L);
		
		System.out.println(address);
		//Optional[Address(seq=1, name=강아지, age=3, address=서울특별시 강남구 테헤란로 132 한독빌딩 8층, gender=m)]
		
	}
	
}
