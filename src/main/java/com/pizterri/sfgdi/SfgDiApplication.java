package com.pizterri.sfgdi;

import com.pizterri.sfgdi.controllers.*;
import com.pizterri.sfgdi.datasource.FakeDataSource;
import com.pizterri.sfgdi.services.PrototypeBean;
import com.pizterri.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.pizterri.sfgdi", "com.pizterri.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());


		I18nController i18nController= (I18nController) ctx.getBean("i18nController");

		System.out.println("--------I8n");
		System.out.println(i18nController.SayHello());

		MyController myController= (MyController) ctx.getBean("myController");

		System.out.println("--------Primary");
		System.out.println(myController.sayHello());

		System.out.println("--------Property");

		PropertyInjectedController propertyInjectedController= (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------Setter");
		SetterInjectedController setterInjectedController= (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------Construction");
		ConstructorInjectedController constructorInjectedController= (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("---- Bean Scopes  ------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());


	}

}
