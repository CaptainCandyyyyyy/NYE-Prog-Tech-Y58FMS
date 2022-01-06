package hu.nye.progtech.torpedo;

import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class GameResultService implements IGameResultService {
    private GameResultRepository gameResultRepository;

    public GameResultService(GameResultRepository gameResultRepository){
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public void create(String playerName, boolean isWinner) {
        gameResultRepository.save(new GameResult(playerName, isWinner));
    }

    @Override
    public List<GameResult> listAll() {
        return gameResultRepository.findAll();
    }
}
