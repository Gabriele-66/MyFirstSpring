package it.nttdata.myfirstspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        //senza spring
        HappyFortune happyFortune = new HappyFortune();
        Coach baseballCoach = new BaseballCoach(happyFortune);
        Coach trackCoach = new TrackCoach();

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());

        System.out.println("--------------------");
        //utilizzo spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach myCoach = context.getBean("myCoach", Coach.class);
        System.out.println(myCoach.getDailyWorkout());
        context.close();

        //dep injection
        System.out.println("--------------------");
        ClassPathXmlApplicationContext contextDIConstructor = new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Coach myCoach2 = contextDIConstructor.getBean("myDICoach", Coach.class);
        System.out.println(myCoach2.getDailyWorkout());
        contextDIConstructor.close();

        // setter injection
        System.out.println("--------------------");
        ClassPathXmlApplicationContext contextDISetter = new ClassPathXmlApplicationContext(
                "applicationContextDISetter.xml");
        System.out.println("Getting bean");
        Coach myCoach3 = contextDISetter.getBean("TCoach", Coach.class);
        System.out.println(myCoach3.getDailyWorkout());
        
        // init e destroy
        System.out.println("---------- Closing context ----------");
        contextDISetter.close();
    }
}
