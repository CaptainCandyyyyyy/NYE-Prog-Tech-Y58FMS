package hu.nye.progtech.torpedo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Starts the game loop.
 */

@SpringBootApplication
public class TorpedoApplication {
    @Configuration
    public class Config {
        @Bean
        public IGameResultService gameResultService(){
            return new GameResultService();
        }
    }
public static void main(String[] args) {
SpringApplication.run(Main.class, args);
}
}
