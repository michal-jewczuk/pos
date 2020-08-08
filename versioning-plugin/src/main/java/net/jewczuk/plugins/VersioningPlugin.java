package net.jewczuk.plugins;

import groovy.lang.Closure;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class VersioningPlugin implements Plugin<Project> {

    private static final String PLUGIN_NAME = "createJarWithMetadata";

    @Override
    public void apply(Project project) {
        VersioningTask versioningTask = project.getTasks().create(PLUGIN_NAME, VersioningTask.class);
        //project.getTasks().register(PLUGIN_NAME, VersioningTask.class);
    }
}
