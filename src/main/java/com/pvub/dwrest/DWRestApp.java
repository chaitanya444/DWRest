package com.pvub.dwrest;

/**
 * Created by Udai on 3/24/17.
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DWRestApp extends Application<DWRestConfig> {

    public static void main(String[] args) throws Exception {
        new DWRestApp().run(args);
    }

    @Override
    public void run(DWRestConfig config, Environment env) {
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

        final DWRestCheck healthCheck = new DWRestCheck(config.getVersion());
        env.healthChecks().register("template", healthCheck);
        env.jersey().register(healthCheck);
    }
}

