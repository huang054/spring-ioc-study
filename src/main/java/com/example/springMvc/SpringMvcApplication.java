package com.example.springMvc;

import com.example.springMvc.Event.CustomApplicationContext;
import com.example.springMvc.beanRigest.Beans;
import com.example.springMvc.beanRigest.CustomizeBeanDefinitionRegistryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({Beans.class, CustomizeBeanDefinitionRegistryPostProcessor.class})
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
		 /* SpringApplication springApplication = new SpringApplication(SpringMvcApplication.class);
		          springApplication.setApplicationContextClass(CustomApplicationContext.class);
		         springApplication.run(args);*/


	}

}
