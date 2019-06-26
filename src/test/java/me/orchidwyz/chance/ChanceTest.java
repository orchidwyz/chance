package me.orchidwyz.chance;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ChanceTest {

    private static final double FRACTION_A = 0.12D;
    private static final double FRACTION_B = 0.67D;

    private Chance chanceA;
    private Chance chanceB;

    @Before
    public void setUp() {
        chanceA = Chance.ofFraction(FRACTION_A);
        chanceB = Chance.ofFraction(FRACTION_B);
    }

    @Test
    public void should_return_not_chance() {
        //given

        //when
        Chance notChance = chanceA.not();

        //then
        assertThat(notChance).isEqualToComparingFieldByField(Chance.ofFraction(Chance.FRACTION_ONE - FRACTION_A));
    }

    @Test
    public void should_return_and_chance() {
        //given

        //when
        Chance andChance = chanceA.and(chanceB);

        //then
        assertThat(andChance).isEqualToComparingFieldByField(Chance.ofFraction(FRACTION_A * FRACTION_B));
    }

    @Test
    public void should_return_or_chance() {
        //given

        //when
        Chance orChance = chanceA.or(chanceB);

        //then
        Chance chance = Chance.ofFraction(FRACTION_A + FRACTION_B - FRACTION_A * FRACTION_B);
        assertThat(orChance).isEqualToComparingFieldByField(chance);
    }
}