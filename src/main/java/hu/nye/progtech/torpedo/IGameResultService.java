package hu.nye.progtech.torpedo;

import java.util.List;

import org.springframework.context.annotation.Bean;

/**
 * Starts the game loop.
 */

public interface IGameResultService {
void create(String playerName, boolean isWinner);

List<GameResult> listAll();


}
