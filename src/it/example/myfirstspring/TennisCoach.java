package it.example.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  //("pippo")
public class TennisCoach implements Coach {

    //@Qualifier("otherFortune")
    private FortuneService fortuneService;

    public TennisCoach() {}

   // @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Autowired
    @Qualifier("otherFortune")
    public void setFortuneService(FortuneService fortuneService) {  //non serve per annotation vedi costruttore
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Try to hit the ball :P || " + fortuneService.getFortune();
    }

    public void doInitStuffs() {
        System.out.println("Inizializing Tennis Coach...");
    }

    public void doDestroyStuffs() {
        System.out.println("Destroying Tennis Coach...");
    }

}
