package com.ex.utils;

public enum AssertValues {

    Stuff_You_Should_Know("Stuff You Should Know", 40),
    Who_Trolled_Amber("Who Trolled Amber", 40),
    Crime_Junkie("Crime Junkie", 30),
    The_Joe_Rogan_Experience("The Joe Rogan Experience", 10);

    private final String show;
    private final Integer value;


    AssertValues(String show, Integer value) {
        this.show = show;
        this.value = value;
    }

    public String getShow() {
        return show;
    }

    public Integer getValue() {
        return value;
    }

    public static Integer getValueByShow(String showName) {
        for (AssertValues assertValue : AssertValues.values()) {
            if (assertValue.getShow().equalsIgnoreCase(showName)) {
                return assertValue.getValue();
            }
        }
        throw new IllegalArgumentException("Show name not found: " + showName);
    }
}
