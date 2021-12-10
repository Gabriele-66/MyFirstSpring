package it.nttdata.myfirstspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SoccerCoach implements Coach {
    
    @Value("${coach.name}")
    private String name;

    @Value("${coach.surname}")
    private String surname;

    private String telNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String Surname) {
        this.surname = Surname;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public FortuneService getFortuneService() {
        return this.fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Autowired
    @Qualifier("happyFortune")
    FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return name + " " + surname + ": Kick the ball!  || " +
                fortuneService.getFortune();
    }



}
