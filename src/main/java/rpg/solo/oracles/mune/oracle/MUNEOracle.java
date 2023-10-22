package rpg.solo.oracles.mune.oracle;

import rpg.solo.oracles.mune.restservice.MUNEOddsTypes;
import rpg.solo.oracles.mune.util.AdvantageType;
import rpg.solo.oracles.mune.util.RandomNumbers;

public class MUNEOracle {
    RandomNumbers randomNumbers;
    public MUNEOracle() {
        randomNumbers = new RandomNumbers();
    }
    public MUNEYesNoType getSimpleYesNoAnswer(MUNEOddsTypes odds) {
        if (odds != MUNEOddsTypes.NORMAL
                && odds != MUNEOddsTypes.LIKELY
                && odds != MUNEOddsTypes.UNLIKELY) {
            throw new IllegalArgumentException("Invalid odds: " + odds);
        }
        if (odds == MUNEOddsTypes.NORMAL) {
            return MUNEYesNoType.getFromInt(
                    randomNumbers.roll(1, 6));
        }
        if (odds == MUNEOddsTypes.LIKELY) {
            return MUNEYesNoType.getFromInt(
                    randomNumbers.roll(1, 6, AdvantageType.ADVANTAGE));
        }
        return MUNEYesNoType.getFromInt(
                randomNumbers.roll(1, 6, AdvantageType.DISADVANTAGE));
    }

}
