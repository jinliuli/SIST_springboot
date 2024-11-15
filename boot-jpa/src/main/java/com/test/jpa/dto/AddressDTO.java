package com.test.jpa.dto;

import com.test.jpa.entity.Address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder //빌더패턴 레코드 사용하는 어노테이션
public class AddressDTO {
	
	private Long seq;
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
	//본인(DTO) > (변환) > 엔티티
	public static Address toEntity(AddressDTO dto) {
		
		return Address.builder()
					.seq(dto.getSeq())
					.name(dto.getName())
					.age(dto.getAge())
					.address(dto.getAddress())
					.gender(dto.getGender())
					.build();
	}
	
	public Address toEntity() {
		
		return Address.builder()
				.seq(this.getSeq())
				.name(this.getName())
				.age(this.getAge())
				.address(this.getAddress())
				.gender(this.getGender())
				.build();
	}
	
	
}
