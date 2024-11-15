package com.test.jpa.entity;

import com.test.jpa.dto.AddressDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import javax.persistence.Entity; (javax는 Apach쪽 임포트임)

//Entity
//- 데이터베이스의 테이블의 참조 객체
//- DB의 tblAddress 테이블과 연결된 객체
//- 엔티티에는 Setter를 구현 안함 > 생성자로 구현
//- 엔티티에는 필요에 따라 Getter는 구현 가능함.
@Entity
@Getter
@ToString
@Table(name = "tblAddress") //야믈 파일에서 안정해주면 tbl_address 스테이크 표기법으로 됨
@Builder //빌더패턴에서 사용하는 어노테이션
@NoArgsConstructor //인자가 없는 생성자 만들기
@AllArgsConstructor //모든 생성자 만들기
public class Address {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) MySQL용
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "별칭") OracleSQL용
//	@SequenceGenerator(name="별칭", sequenceName = "seqAddress", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq_generator")
	@SequenceGenerator(name="address_seq_generator", sequenceName = "seqAddress", allocationSize = 1)	
	private Long seq; //long > 문자값타입이라 null을 못 넣음 그래서 Long 으로 만들기
	
	private String name;
	private Integer age;
	private String address;
	private String gender;
	
	
	//Entity(본인) > (변환) > DTO
	public static AddressDTO toDTO(Address address) {
		
//		AddressDTO dto = new AddressDTO(); //@Builder 빌더 패턴 때문에 기본 생성자가 private으로 막힘
//		dto.setSeq(address.getSeq());
//		dto.setName(address.getName());
//		dto.setAge(address.getAge());
//		dto.setAddress(address.getAddress());
//		dto.setGender(address.getGender());
		
		
		return AddressDTO.builder()
					.seq(address.seq)
					.name(address.name)
					.age(address.age)
					.address(address.address)
					.gender(address.gender)
					.build();
	}
	
	//객체변수로 만들어보기 > 본인을 결과값으로
	public AddressDTO toDTO() {
		
//		AddressDTO dto = new AddressDTO();
//		dto.setSeq(this.getSeq());
//		dto.setName(this.getName());
//		dto.setAge(this.getAge());
//		dto.setAddress(this.getAddress());
//		dto.setGender(this.getGender());
		
		return AddressDTO.builder()
				.seq(this.getSeq())
				.name(this.getName())
				.age(this.getAge())
				.address(this.getAddress())
				.gender(this.getGender())
				.build();
	}
	
}
