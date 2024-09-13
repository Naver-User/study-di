package org.zerock.myapp.di;

import org.springframework.stereotype.Component;

import lombok.Data;


// Restaurant -> Chef (의존성 관계)
@Data

// 이 클래스의 객체가 스프링의 빈즈 컨테이너 안에 자동생성되어야 한다
// 라는 의미를 스프링프레임워크에게 알려주는 어노테이션
//@Component	// 스테레오타입 어노테이션 : 스프링 빈즈컨테이너가 관리하는 빈이된다!!

@Component("restaurant")	// 빈의 기본이름은, 타입명 > 첫문자를 소문자로 변경
public class Restaurant {	// POJO

//	@Setter(onMethod_ = @Resource)
//	@Setter(onMethod_ = @Inject)
//	@Setter(onMethod_ = @Autowired)	// 주입시그널 전송#4 (스프링프레임워크 공식방법)
//	@Resource						// 주입시그널 전송#3
//	@Inject							// 주입시그널 전송#2
//	@Autowired 						// 주입시그널 전송#1 (스프링부트에서 주로 사용)
	private Chef chef;		// 의존성 객체 주입이 필요하다!!!
	
	
	
} // end class
