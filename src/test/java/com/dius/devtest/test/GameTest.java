package com.dius.devtest.test;

import com.dius.devtest.Game;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


public class GameTest {
    private Game game;

    @Before
    public void beforeGameTest() {
        game = new Game("shayan", "soha");
    }

    // Basic flow in playing state
    @Test
    public void scoreShouldBeLoveLoveWhenGameStarts(){
        assertThat(game.score()).isEqualTo("0-0");
    }

    @Test
    public void scoreShouldBeFifteenLoveWhenShayanScore1AndSohaScore0(){
        game.pointWonBy("shayan");
        assertThat(game.score()).isEqualTo("15-0");
    }

    @Test
    public void scoreShouldBeThirtyLoveWhenShayanScore2AndSohaScore0(){
        game.pointWonBy("shayan");
        game.pointWonBy("shayan");
        assertThat(game.score()).isEqualTo("30-0");
    }

    @Test
    public void scoreShouldBeThirtyFifteenWhenShayanScore2AndSohaScore1(){
        game.pointWonBy("shayan");
        game.pointWonBy("shayan");
        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("30-15");
    }

    @Test
    public void scoreShouldBeThirtyThirtyWhenShayanScore2AndSohaScore2(){
        IntStream.range(0,2).forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                }
        );
        assertThat(game.score()).isEqualTo("30-30");
    }

    @Test
    public void scoreShouldBeFourtyThirtyWhenShayanScore3AndSohaScore2(){
        IntStream.range(0,2).forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                }
        );
        game.pointWonBy("shayan");
        assertThat(game.score()).isEqualTo("40-30");
    }

    @Test
    public void shayanShouldBeGameWinnerWhenScore4AndSohaScore2(){
        game.pointWonBy("soha");
        IntStream.range(0,4).forEach((i)-> game.pointWonBy("shayan"));
        assertThat(game.score()).isEqualTo("shayan wins");
    }

    // Duece

    @Test
    public void scoreShouldBeDuesWhenScoreFourtyAndSohaScores40(){

        IntStream.range(0,3)
                .forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                });
        assertThat(game.score()).isEqualTo("Deuce");
    }

    // Advantage
    @Test
    public void shayanShouldBeInAdvantageWhenScoreIsDuesAndShayanScored(){

        IntStream.range(0,3).
                forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                });

        assertThat(game.score()).isEqualTo("Deuce");
        game.pointWonBy("shayan");
        assertThat(game.score()).isEqualTo("Advantage shayan");

    }

    @Test
    public void scoreShouldBeDuesWhenSohaIsInAdvantageAndShayanScored(){

        IntStream.range(0,3)
                .forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                });
        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("Advantage soha");

        game.pointWonBy("shayan");
        assertThat(game.score()).isEqualTo("Deuce");
    }

    @Test
    public void sohaShouldBeWinnerWhenScoredFromAdvantage(){

        IntStream.range(0,3)
                .forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                });
        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("Advantage soha");

        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("soha wins");
    }

    @Test
    public void scoreShouldBeAlwaysWinsAfterGameOver(){

        IntStream.range(0,3)
                .forEach((i)-> {
                    game.pointWonBy("shayan");
                    game.pointWonBy("soha");
                });
        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("Advantage soha");

        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("soha wins");

        game.pointWonBy("soha");
        assertThat(game.score()).isEqualTo("soha wins");
    }
}
