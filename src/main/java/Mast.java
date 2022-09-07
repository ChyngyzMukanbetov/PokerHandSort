public enum Mast {
    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C");

    private final String value;

    Mast(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }

    public static Mast getByValue(String v) {
        for (Mast m : Mast.values()) {
            if (m.value.equalsIgnoreCase(v)) {
                return m;
            }
        }
        return null;
    }


}
