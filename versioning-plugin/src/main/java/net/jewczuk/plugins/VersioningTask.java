package net.jewczuk.plugins;


import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;

public class VersioningTask extends DefaultTask {

    private String classifierName = "CUSTOM";

    @TaskAction
    public void printVersion() {
        System.out.println(classifierName);
    }

    @Input
    public String getClassifierName() {
        return classifierName;
    }

    @Option(option = "classifier", description = "Appends string as classifier")
    public void setClassifierName(String classifierName) {
        this.classifierName = classifierName;
    }
}
