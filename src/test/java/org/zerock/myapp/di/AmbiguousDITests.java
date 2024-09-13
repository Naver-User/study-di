package org.zerock.myapp.di;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

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

@SpringBootTest
public class AmbiguousDITests {
	// NoUniqueBeanDefinitionException : 2개 이상의 빈 타입이 발견되어서 오류발생
//	@Autowired private Animal animal;	// Animal > Dog, Cat
	
//	@Autowired private Dog dog;
//	@Autowired private Cat cat;
	
	// NoSuchBeanDefinitionException   : 1개도 매칭되는 빈 타입이 없어서 오류발생	
	@Autowired(required = false) 	// 주입할만한 빈이 없을 때에는 주입안해줘도 괜찮다!
	DataSource dataSource;
	
	
	@BeforeAll
	void beforeAll() {	// 1회성 전처리
		log.trace("beforeAll() invoked.");
		
//		Objects.requireNonNull(this.animal);
//		log.info("\t+ this.animal: {}", this.animal);
//		
//		Objects.requireNonNull(this.dog);
//		log.info("\t+ this.dog: {}", this.dog);
//		
//		Objects.requireNonNull(this.cat);
//		log.info("\t+ this.cat: {}", this.cat);
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
