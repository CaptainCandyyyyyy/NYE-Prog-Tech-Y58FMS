package hu.nye.progtech.torpedo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class GameResult {
    private String playerName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public GameResult(String playerName, Boolean isWinner){
        this.playerName = playerName;
        this.isWinner = isWinner;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isWinner() {
        return isWinner;
    }

    private boolean isWinner;

    }

