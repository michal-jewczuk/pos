package net.jewczuk.plugins;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class VersioningTask extends DefaultTask {

    @Input
    private String classifierName ="CUSTOM";

    @TaskAction
    public void printVersion() {
        System.out.println(classifierName);
    }

    public String getClassifierName() {
        return classifierName;
    }

    public void setClassifierName(String classifierName) {
        this.classifierName = classifierName;
    }
}
