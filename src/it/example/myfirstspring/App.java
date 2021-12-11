package it.example.myfirstspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.example.myfirstspring.config.ComponentScanConfig;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println("--------- Senza Spring -----------");
        HappyFortune happyFortune = new HappyFortune();
        Coach baseballCoach = new BaseballCoach(happyFortune);
        Coach trackCoach = new TrackCoach();
        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());

        System.out.println("\n--------- Utilizzo Spring -----------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("myCoach", Coach.class);
        System.out.println(myCoach.getDailyWorkout());
        context.close();

        System.out.println("\n--------- Dep Injection -----------");
        ClassPathXmlApplicationContext contextDIConstructor = new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Coach myCoach2 = contextDIConstructor.getBean("myDICoach", Coach.class);
        System.out.println(myCoach2.getDailyWorkout());
        contextDIConstructor.close();

        System.out.println("\n-------- Setter Injection ------------");
        ClassPathXmlApplicationContext contextDISetter = new ClassPathXmlApplicationContext(
                "applicationContextDISetter.xml");
        System.out.println("Getting bean");
        Coach myCoach3 = contextDISetter.getBean("TCoach", Coach.class);
        System.out.println(myCoach3.getDailyWorkout());
         
        System.out.println("\n---------- Closing context (Init e Destroy)----------");
        contextDISetter.close();

        System.out.println("\n---------- Setter Annotations ----------");
        ClassPathXmlApplicationContext contextAnnotations = new ClassPathXmlApplicationContext(
                "applicationContextAnnotation.xml");
        Coach myCoach4 = contextAnnotations.getBean("tennisCoach", Coach.class);
        System.out.println(myCoach4.getDailyWorkout());

        System.out.println("\n---------- Field injection Annotations ----------");
        Coach myCoach5 = contextAnnotations.getBean("soccerCoach", Coach.class);
        System.out.println(myCoach5.getDailyWorkout());
        contextAnnotations.close();

        System.out.println("\n---------- Spring config whit java code  ----------");
        AnnotationConfigApplicationContext contextJavaConfig = new AnnotationConfigApplicationContext(
                ComponentScanConfig.class);
        Coach myCoach6 = contextJavaConfig.getBean("soccerCoach", Coach.class);
        System.out.println(myCoach6.getDailyWorkout());
        contextJavaConfig.close();
    }
}
