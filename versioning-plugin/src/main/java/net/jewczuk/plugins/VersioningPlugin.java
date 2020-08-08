package net.jewczuk.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class VersioningPlugin implements Plugin<Project> {

    private static final String PLUGIN_NAME = "createJarWithMetadata";

    @Override
    public void apply(Project project) {
        project.getTasks().register(PLUGIN_NAME, VersioningTask.class);
    }
}
