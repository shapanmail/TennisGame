package com.dius.devtest.test;



import com.dius.devtest.Player;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class PlayerTest {

    private Player player;


    @Before
    public void beforeGameTest() {
        player = new Player("soha");
    }

    @Test
    public void playerPropertiesShouldBeInitialValuesAfterInstantiation() {
        assertThat(player.getName()).isEqualTo("soha");
        assertThat(player.pointString()).isEqualTo("0");
        assertThat(player.isWinner()).isFalse();
        assertThat(player.isInAdvantage()).isFalse();
        assertThat(player.isIn40()).isFalse();

        player.setAdvantage(true);
        assertThat(player.isInAdvantage()).isTrue();

        player.setWinner(true);
        assertThat(player.isWinner()).isTrue();
    }
}
