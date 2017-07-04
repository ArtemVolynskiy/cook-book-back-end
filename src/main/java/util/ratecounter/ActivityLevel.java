package util.ratecounter;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.EnumMap;


public enum ActivityLevel {
    @JsonProperty("minimum")
    MINIMUM,
    @JsonProperty("low")
    LOW,
    @JsonProperty("average")
    AVERAGE,
    @JsonProperty("high")
    HIGH,
    @JsonProperty("very_high")
    VERY_HIGH;

    static final EnumMap<ActivityLevel, Float> activityValues = new EnumMap<>(ActivityLevel.class);

    static {
        activityValues.put(MINIMUM, 1.2F);
        activityValues.put(LOW, 1.375F);
        activityValues.put(AVERAGE, 1.55F);
        activityValues.put(HIGH, 1.725F);
        activityValues.put(VERY_HIGH, 1.9F);
    }
}
