package models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dev",
        "test",
        "staging",
})
@Generated("jsonschema2pojo")
public class Config {

    @JsonProperty("dev")
    private URL dev;
    @JsonProperty("test")
    private URL test;
    @JsonProperty("staging")
    private URL staging;

    @JsonProperty("dev")
    public URL getDev() { return dev; }
    @JsonProperty("dev")
    public void setDev(URL value) { this.dev = value; }

    @JsonProperty("test")
    public URL getTest() { return test; }
    @JsonProperty("test")
    public void setTest(URL value) { this.test = value; }

    @JsonProperty("staging")
    public URL getStaging() { return staging; }
    @JsonProperty("staging")
    public void setStaging(URL value) { this.staging = value; }
}
