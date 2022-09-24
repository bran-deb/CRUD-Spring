package com.cursojava.cursolm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CursolmApplication.class);
	}
	//netstat -ano | findstr LISTENING | findstr 8080 //mostrar proceso en puerto
	//taskill -PID 11808 -F //terminar proceso de puerto

}
