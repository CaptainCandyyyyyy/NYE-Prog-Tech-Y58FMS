package hu.nye.progtech.torpedo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Starts the game.
 */

@SpringBootApplication
public class TorpedoApplication {

    /**
     * Should annotate Bean but unfortunately after trying every fix on the first page of google it doesn't.....
     */
@Autowired
IGameResultService gameResultService;

    public static void main(String[] args) {
SpringApplication.run(TorpedoApplication.class, args);
}
}
