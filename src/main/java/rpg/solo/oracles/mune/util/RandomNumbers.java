package rpg.solo.oracles.mune.util;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumbers {
    private final Random randomInstance;

    public RandomNumbers() {
        this.randomInstance = new Random();
    }

    public int getRandomInt(int minValue, int maxValue) {
        return randomInstance
                .ints(minValue, maxValue+1)
                .findFirst()
                .orElseThrow();
    }

    public int roll(int numDice, int diceSize) {
        return IntStream
                .range(1,numDice+1)
                .map(x -> getRandomInt(1, diceSize))
                .sum();
    }

    public int roll(int numDice, int diceSize, AdvantageType advantageType) {
        if (advantageType == AdvantageType.NORMAL) {
            return roll(numDice,diceSize);
        }
        if (advantageType == AdvantageType.ADVANTAGE) {
            return Math.max(roll(numDice, diceSize), roll(numDice, diceSize));
        }
        if (advantageType == AdvantageType.DISADVANTAGE) {
            return Math.min(roll(numDice, diceSize), roll(numDice, diceSize));
        }
        throw new IllegalArgumentException("AdvantageType not valid: " + advantageType);
    }
}
