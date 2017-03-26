package com.pvub.dwrest;

/**
 * Created by Udai on 3/24/17.
 */
import com.codahale.metrics.health.HealthCheck;

public class DWRestCheck extends HealthCheck {
    private final String version;

    public DWRestCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (PersonDB.getCount() == 0) {
            return Result.unhealthy("No persons in DB! Version: " +
                    this.version);
        }
        return Result.healthy("OK with version: " + this.version +
                ". Persons count: " + PersonDB.getCount());
    }
}
