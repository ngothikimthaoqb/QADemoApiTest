package models.books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userId",
        "collectionOfIsbns"
})
@Generated("jsonschema2pojo")
public class AddABookRequest {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("collectionOfIsbns")
    private List<CollectionOfIsbn> collectionOfIsbns = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("collectionOfIsbns")
    public List<CollectionOfIsbn> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    @JsonProperty("collectionOfIsbns")
    public void setCollectionOfIsbns(List<CollectionOfIsbn> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}

