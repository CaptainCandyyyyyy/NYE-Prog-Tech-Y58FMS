package hu.nye.progtech.torpedo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Starts the game loop.
 */

@Repository
public interface GameResultRepository extends JpaRepository<GameResult, Integer> {
    Optional<GameResult> findALL();
}
