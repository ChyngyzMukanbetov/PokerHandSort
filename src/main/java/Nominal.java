public enum Nominal {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN ("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String value;

    Nominal(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }

    public static Nominal getByValue(String v) {
        for (Nominal b : Nominal.values()) {
            if (b.value.equalsIgnoreCase(v)) {
                return b;
            }
        }
        return null;
    }
}
