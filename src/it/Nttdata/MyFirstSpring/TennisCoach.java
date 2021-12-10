package it.nttdata.myfirstspring;

public class TennisCoach implements Coach {
    private FortuneService fortuneService;

    public void setFortuneService(FortuneService fortuneService) {
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
