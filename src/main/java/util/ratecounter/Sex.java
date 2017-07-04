package util.ratecounter;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum Sex {
    @JsonProperty("male")
    MALE,
    @JsonProperty("female")
    FEMALE;
}
