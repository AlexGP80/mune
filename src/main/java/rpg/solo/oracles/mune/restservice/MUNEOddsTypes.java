package rpg.solo.oracles.mune.restservice;

public enum MUNEOddsTypes {
    NO_ODDS("NO_ODDS"), LIKELY("LIKELY"), UNLIKELY("UNLIKELY"), NORMAL("NORMAL");

    private final String odds;

    MUNEOddsTypes(String odds) {
        this.odds = odds;
    }

    public String getOdds() {
        return odds;
    }

    public static MUNEOddsTypes getOddsForString(String odds) {
        if (odds.toUpperCase().compareTo(LIKELY.getOdds()) == 0) {
            return LIKELY;
        }
        if (odds.toUpperCase().compareTo(UNLIKELY.getOdds()) == 0) {
            return UNLIKELY;
        }
        if (odds.toUpperCase().compareTo(NORMAL.getOdds()) == 0) {
            return NORMAL;
        }
        return NO_ODDS;
    }
}
