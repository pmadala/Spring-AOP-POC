package org.SpringAOP.spring.main;

import java.io.File;
import java.io.IOException;

import org.SpringAOP.spring.service.WordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		
		/*String current = new File( "." ).getCanonicalPath();
        System.out.println("Current dir:"+current);
 String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);*/
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		WordService service = (WordService) appContext.getBean("wordService");
		System.out.println(service.getWord().getValue());

		service.getWord().setValue("dummy value");

		service.getWord().throwException();

		((ConfigurableApplicationContext) appContext).close();
	}
}
