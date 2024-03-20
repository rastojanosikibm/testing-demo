package org.example;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;

public class DemoTest extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(this.getClass()))
                        .withFormats(CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new DemoSteps());
    }

    @Override
    protected List<String> storyPaths() {
        StoryFinder finder = new StoryFinder();
        return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Collections.singletonList("**/*.story"), Arrays.asList(""));
    }

}

/**
 * 
 * /java -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:/home/rastik/.local/share/JetBrains/Toolbox/apps/intellij-idea-ultimate/lib/idea_rt.jar=38805:/home/rastik/.local/share/JetBrains/Toolbox/apps/intellij-idea-ultimate/bin -Dfile.encoding=UTF-8 -classpath /home/rastik/.local/share/JetBrains/Toolbox/apps/intellij-idea-ultimate/lib/idea_rt.jar:/home/rastik/.local/share/JetBrains/Toolbox/apps/intellij-idea-ultimate/plugins/junit/lib/junit5-rt.jar:/home/rastik/.local/share/JetBrains/Toolbox/apps/intellij-idea-ultimate/plugins/junit/lib/junit-rt.jar:/home/rastik/projects/ibm/testing-demo/tests/target/classes:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-java/4.16.1/selenium-java-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-api/4.16.1/selenium-api-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-devtools-v118/4.16.1/selenium-devtools-v118-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-devtools-v119/4.16.1/selenium-devtools-v119-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-devtools-v120/4.16.1/selenium-devtools-v120-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-devtools-v85/4.16.1/selenium-devtools-v85-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-edge-driver/4.16.1/selenium-edge-driver-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-firefox-driver/4.16.1/selenium-firefox-driver-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-ie-driver/4.16.1/selenium-ie-driver-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-remote-driver/4.16.1/selenium-remote-driver-4.16.1.jar:/home/rastik/.m2/repository/com/google/guava/guava/32.1.2-jre/guava-32.1.2-jre.jar:/home/rastik/.m2/repository/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar:/home/rastik/.m2/repository/com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:/home/rastik/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar:/home/rastik/.m2/repository/org/checkerframework/checker-qual/3.33.0/checker-qual-3.33.0.jar:/home/rastik/.m2/repository/com/google/errorprone/error_prone_annotations/2.18.0/error_prone_annotations-2.18.0.jar:/home/rastik/.m2/repository/com/google/j2objc/j2objc-annotations/2.8/j2objc-annotations-2.8.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-api/1.28.0/opentelemetry-api-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-context/1.28.0/opentelemetry-context-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-exporter-logging/1.28.0/opentelemetry-exporter-logging-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk-metrics/1.28.0/opentelemetry-sdk-metrics-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-extension-incubator/1.28.0-alpha/opentelemetry-extension-incubator-1.28.0-alpha.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk-logs/1.28.0/opentelemetry-sdk-logs-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk-common/1.28.0/opentelemetry-sdk-common-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk-extension-autoconfigure-spi/1.28.0/opentelemetry-sdk-extension-autoconfigure-spi-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk-extension-autoconfigure/1.28.0/opentelemetry-sdk-extension-autoconfigure-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-api-events/1.28.0-alpha/opentelemetry-api-events-1.28.0-alpha.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk-trace/1.28.0/opentelemetry-sdk-trace-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-sdk/1.28.0/opentelemetry-sdk-1.28.0.jar:/home/rastik/.m2/repository/io/opentelemetry/opentelemetry-semconv/1.28.0-alpha/opentelemetry-semconv-1.28.0-alpha.jar:/home/rastik/.m2/repository/net/bytebuddy/byte-buddy/1.14.5/byte-buddy-1.14.5.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-os/4.16.1/selenium-os-4.16.1.jar:/home/rastik/.m2/repository/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-safari-driver/4.16.1/selenium-safari-driver-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-support/4.16.1/selenium-support-4.16.1.jar:/home/rastik/.m2/repository/com/google/auto/service/auto-service-annotations/1.1.1/auto-service-annotations-1.1.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-http/4.16.1/selenium-http-4.16.1.jar:/home/rastik/.m2/repository/dev/failsafe/failsafe/3.3.2/failsafe-3.3.2.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-json/4.16.1/selenium-json-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-manager/4.16.1/selenium-manager-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-chrome-driver/4.16.1/selenium-chrome-driver-4.16.1.jar:/home/rastik/.m2/repository/org/seleniumhq/selenium/selenium-chromium-driver/4.16.1/selenium-chromium-driver-4.16.1.jar:/home/rastik/.m2/repository/org/jbehave/jbehave-core/4.1/jbehave-core-4.1.jar:/home/rastik/.m2/repository/junit/junit/4.12/junit-4.12.jar:/home/rastik/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/home/rastik/.m2/repository/org/hamcrest/hamcrest-library/1.3/hamcrest-library-1.3.jar:/home/rastik/.m2/repository/org/hamcrest/hamcrest-integration/1.3/hamcrest-integration-1.3.jar:/home/rastik/.m2/repository/org/apache/commons/commons-collections4/4.1/commons-collections4-4.1.jar:/home/rastik/.m2/repository/commons-io/commons-io/2.5/commons-io-2.5.jar:/home/rastik/.m2/repository/org/apache/commons/commons-lang3/3.4/commons-lang3-3.4.jar:/home/rastik/.m2/repository/org/codehaus/plexus/plexus-utils/3.0.22/plexus-utils-3.0.22.jar:/home/rastik/.m2/repository/org/freemarker/freemarker/2.3.23/freemarker-2.3.23.jar:/home/rastik/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/home/rastik/.m2/repository/com/thoughtworks/xstream/xstream/1.4.9/xstream-1.4.9.jar:/home/rastik/.m2/repository/xmlpull/xmlpull/1.1.3.1/xmlpull-1.1.3.1.jar:/home/rastik/.m2/repository/xpp3/xpp3_min/1.1.4c/xpp3_min-1.1.4c.jar:/home/rastik/.m2/repository/org/springframework/spring-test/6.1.4/spring-test-6.1.4.jar:/home/rastik/.m2/repository/org/springframework/spring-core/6.1.4/spring-core-6.1.4.jar:/home/rastik/.m2/repository/org/springframework/spring-jcl/6.1.4/spring-jcl-6.1.4.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 org.example.DemoTest
 */