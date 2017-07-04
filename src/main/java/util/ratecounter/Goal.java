package util.ratecounter;


import com.fasterxml.jackson.annotation.JsonProperty;

public enum Goal {
    @JsonProperty("lose")
    LOOSE,
    @JsonProperty("keep")
    KEEP,
    @JsonProperty("gain")
    GAIN;
}
