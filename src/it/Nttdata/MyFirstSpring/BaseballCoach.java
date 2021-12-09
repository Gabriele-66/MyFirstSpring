package it.nttdata.myfirstspring;

public class BaseballCoach implements Coach {
    private FortuneService fortuneservice;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneservice = fortuneService;
    }

    public String getDailyWorkout() {
        return "Spend 20 minutes on batting practice || " + fortuneService.getFortune() ;
    }
    
}
