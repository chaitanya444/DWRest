/**
 * Created by Udai on 3/24/17.
 */

package com.pvub.dwrest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class DWRestConfig extends Configuration
{
    @NotEmpty
    private String version;

    @JsonProperty
    public String getVersion() {
        return version;
    }

    @JsonProperty
    public void setVersion(String version) {
        this.version = version;
    }
}