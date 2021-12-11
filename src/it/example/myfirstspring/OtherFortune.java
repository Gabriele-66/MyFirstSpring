package it.example.myfirstspring;

import org.springframework.stereotype.Component;

@Component
public class OtherFortune implements FortuneService {
    
    @Override
    public String getFortune() {
        return "This is Other Fortune Service";
    }

    public void doInitStuffs() {
        System.out.println("Inizializing Other Fortune Service...");
    }

    public void doDestroyStuffs() {
        System.out.println("Destroying Other Fortune Service...");
    }
}
