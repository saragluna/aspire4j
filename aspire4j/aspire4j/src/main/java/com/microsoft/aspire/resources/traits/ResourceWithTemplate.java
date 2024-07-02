package com.microsoft.aspire.resources.traits;

import java.nio.file.Path;
import java.util.List;

/**
 * A resource that has a template associated with it. This may be one or more bicep files, microservice projects (e.g.
 * Spring Boot, Quarkus, etc.), or other types of templates. For each of the template files, we defer to Apache Velocity
 * to process the template and generate the final output. Where this output is placed is determined by the resource
 * itself - sometimes it is a temporary location (which the app host will tidy up), sometimes it will be the output
 * location specified by the app host user.
 * @param <T>
 */
public interface ResourceWithTemplate<T extends ResourceWithTemplate<T>> {

    List<TemplateFileOutput> processTemplate(Path outputPath);

    T self();

    record TemplateDescriptor(String inputFilename, String outputFilename) {   }

    // FIXME at some point string content won't be sufficient, and we will want to support binary content too
    record TemplateFileOutput(String filename, String content) {    }
}
