package me.orchidwyz.chance;

import lombok.Getter;
import lombok.NonNull;

public class Chance {

    public static final double FRACTION_ONE = 1D;
    public static final double FRACTION_ZERO = 0D;

    @Getter
    private double fraction;

    private Chance(double fraction) {
        if (fraction > FRACTION_ONE) {
            this.fraction = FRACTION_ONE;
        } else {
            this.fraction = fraction < FRACTION_ZERO ? FRACTION_ZERO : fraction;
        }
    }

    public static Chance ofFraction(double fraction) {
        return new Chance(fraction);
    }

    public Chance and(@NonNull Chance that) {
        return Chance.ofFraction(fraction * that.fraction);
    }

    public Chance or(@NonNull Chance that) {
        return Chance.ofFraction(fraction + that.fraction - fraction * that.fraction);
    }

    public Chance not() {
        return Chance.ofFraction(FRACTION_ONE - fraction);
    }
}
