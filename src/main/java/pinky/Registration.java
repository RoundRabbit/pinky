package pinky;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Registration {

    private final String name;
    private final String url;

    @JsonCreator
    public Registration(@JsonProperty("name") final String name, @JsonProperty("url") final String url) {

        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {

        return this.name;
    }

    public String getUrl() {

        return this.url;
    }
}
