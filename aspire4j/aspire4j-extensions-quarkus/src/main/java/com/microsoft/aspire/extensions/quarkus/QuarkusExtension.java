package com.microsoft.aspire.extensions.quarkus;

import com.microsoft.aspire.DistributedApplication;
import com.microsoft.aspire.extensions.quarkus.resources.QuarkusProject;
import com.microsoft.aspire.extensions.microservice.common.MicroserviceExtension;

public class QuarkusExtension extends MicroserviceExtension {
    public QuarkusExtension() {
        super("Quarkus", "Provides support for working with Quarkus applications.");
    }

    /**
     * Adds a new Quarkus project to the app host.
     * @param name The name of the Quarkus project.
     * @return A new {@link QuarkusProject} instance that can be used to configure the project.
     */
    public QuarkusProject addMicronautProject(String name) {
        return DistributedApplication.getInstance().addResource(new QuarkusProject(name));
    }
}
