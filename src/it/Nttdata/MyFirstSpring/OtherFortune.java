package it.nttdata.myfirstspring;

public class OtherFortune implements FortuneService {
    
    @Override
    public String getFortune() {
        return "This is Other Fortune Service";
    }
}
