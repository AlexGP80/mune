package rpg.solo.oracles.mune.oracle;

public enum MUNEYesNoType {
    YES_AND(1, "Yes, and..."),
    YES(2,"Yes"),
    YES_BUT(3, "Yes, but..."),
    NO_BUT(4, "No, but..."),
    NO(5, "No"),
    NO_AND(6, "No, and...");

    private final String typeStr;
    private final int value;
    MUNEYesNoType(int value, String typeStr) {
        this.typeStr = typeStr;
        this.value = value;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public int getValue() {
        return value;
    }

    public static MUNEYesNoType getFromInt(int number) {
        if (number == 1) {
            return YES_AND;
        }
        if (number == 2) {
            return YES;
        }
        if (number == 3) {
            return YES_BUT;
        }
        if (number == 4) {
            return NO_BUT;
        }
        if (number == 5) {
            return NO;
        }
        if (number == 6) {
            return NO_AND;
        }
        throw new IllegalArgumentException("No type for number: " + number);
    }
}
