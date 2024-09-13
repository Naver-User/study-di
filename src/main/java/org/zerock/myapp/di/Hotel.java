package org.zerock.myapp.di;

import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.Data;


@Data

@Component
public class Hotel {
	@Resource(type = Chef.class)
//	@Autowired 
	private Chef chef;

} // end class

