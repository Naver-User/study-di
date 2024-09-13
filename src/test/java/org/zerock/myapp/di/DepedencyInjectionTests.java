package org.zerock.myapp.di;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Log4j2
@Slf4j

@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)

// 지금부터 여러분이 테스트 하는 모든 스프링의 기능은,
// 스프링부트가 실행되어 있어야만 가능한 테스트이다!!
// 때문에 추가적인 어노테이션으로 테스트 수행시, 스프링부트가 함께 구동되도록 해야 합니다.
@SpringBootTest

// 이 테스트 클래스의 인스턴스도 자동으로, 스프링빈즈컨테이너의 빈으로 등록됩니다.
public class DepedencyInjectionTests {
	@Autowired private Restaurant restaurant;
	@Autowired private Hotel hotel;
	
	
	@BeforeAll
	void beforeAll() {	// 1회성 전처리
		log.trace("beforeAll() invoked.");
		
		Objects.requireNonNull(this.restaurant);
		log.info("\t+ this.restaurant: {}", this.restaurant);
		
		Objects.requireNonNull(this.hotel);
		log.info("\t+ this.hotel: {}", this.hotel);
	} // beforeAll
	
	
//	@Disabled
	@Order(1)
	@Test
//	@RepeatedTest(1)
	@DisplayName("contextLoads")
	@Timeout(value=1L, unit=TimeUnit.MINUTES)
	void contextLoads() {
		log.trace("contextLoads() invoked.");
		
	} // contextLoads

} // end class
