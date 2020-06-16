package virtual_pet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VirtualPetTest {
    VirtualPet Argo = new VirtualPet();

    @Test
    public void hangerUpdatedByTick(){
        int hangerBeforeTick = Argo.getHanger();
        Argo.tick();
        int hangerAfterTicks = Argo.getHanger();
        Assertions.assertThat(hangerAfterTicks).isNotEqualTo(hangerBeforeTick);
    }

    @Test
    public void hangerUpdatedByPlayedGameUpdate(){
        int hangerBeforePlayedGameUpdate = Argo.getHanger();
        Argo.playedGameUpdate();
        int hangerAfterPlayedGameUpdate = Argo.getHanger();
        Assertions.assertThat(hangerAfterPlayedGameUpdate).isNotEqualTo(hangerBeforePlayedGameUpdate);
    }

    @Test
    public void hangerUpdatedByNightUpdate(){
        int hangerBeforeNightUpdate = Argo.getHanger();
        Argo.nightHanger();
        int hangerAfterNightUpdate = Argo.getHanger();
        Assertions.assertThat(hangerAfterNightUpdate).isNotEqualTo(hangerBeforeNightUpdate);
    }

    @Test
    public void hangerUpdatedByTicksAndLivesUpdatedWhenHungerIsEqualTo100() {
        int hangerBeforeTicks = Argo.getHanger();
        int remainingLivesBeforeTicks = Argo.getRemainingLives();
        Argo.playedGameUpdate();
        Argo.nightUpdate();
        Argo.takeoutUpdate();
        Argo.tick();
        Argo.updateLives();
        int hangerAfterTicks = Argo.getHanger();
        int remainingLivesAfterTicks = Argo.getRemainingLives();
        Assertions.assertThat(hangerAfterTicks).isEqualTo(100);
        Assertions.assertThat(hangerAfterTicks).isGreaterThan(hangerBeforeTicks);
        Assertions.assertThat(remainingLivesBeforeTicks).isEqualTo(3);
        Assertions.assertThat(remainingLivesAfterTicks).isLessThan(3);
    }

    @Test
    public void feedUpdateShouldReduceHanger(){
        int hangerBeforeFeed = Argo.getHanger();
        Argo.feedUpdate();
        int hangerAfterFeed = Argo.getHanger();
        Assertions.assertThat(hangerAfterFeed).isLessThan(hangerBeforeFeed);
    }

        @Test
    public void restartMethodShouldReturnNewValue() {
        int thirstBeforeRestart = Argo.getThirst();
        Argo.restart();
        int thirstAfterRestart = Argo.getThirst();
        Assertions.assertThat(thirstBeforeRestart).isNotEqualTo(thirstAfterRestart);
    }

    @Test
    public void gameShouldEndWhenLivesLessThanZeroAndUpdateLivesShouldUpdate() {
        boolean aliveBeforeTicks = Argo.alive();
        int remainingLivesBeforeTicks = Argo.getRemainingLives();
        Argo.playedGameUpdate();
        Argo.updateLives();
        Argo.nightUpdate();
        Argo.updateLives();
        Argo.takeoutUpdate();
        Argo.updateLives();
        Argo.tick();
        Argo.updateLives();
        Argo.playedGameUpdate();
        Argo.updateLives();
        Argo.nightUpdate();
        Argo.updateLives();
        Argo.takeoutUpdate();
        Argo.tick();
        Argo.updateLives();
        int remainingLivesAfterTicks = Argo.getRemainingLives();
        boolean aliveAfterTicks = Argo.alive();
        Assertions.assertThat(remainingLivesBeforeTicks).isEqualTo(3);
        Assertions.assertThat(remainingLivesAfterTicks).isLessThan(0);
        Assertions.assertThat(aliveBeforeTicks).isEqualTo(true);
        Assertions.assertThat(aliveAfterTicks).isEqualTo(false);
    }
}
