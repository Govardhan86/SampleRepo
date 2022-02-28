package com.accenture.lkm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*
		 * Vehicle obj=new Car(); obj.drive();
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Vehicle obj = (Vehicle) context.getBean("vehicle");
		obj.drive();

		/*
		 * ApplicationContext context=new
		 * AnnotationConfigApplicationContext(AppConfig.class);
		 * 
		 * Vehicle obj=(Vehicle) context.getBean("car"); obj.drive();
		 */

	}
}
