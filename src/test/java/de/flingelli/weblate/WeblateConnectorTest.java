package de.flingelli.weblate;

import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import static org.mockserver.model.HttpClassCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class WeblateConnectorTest {
    private ClientAndServer server;
    private ClientAndProxy proxy;

    @BeforeSuite
    public void startServer() throws IOException {
        server = ClientAndServer.startClientAndServer(50080);
        proxy = ClientAndProxy.startClientAndProxy(50090);
        registerResponses();
    }

    private void registerResponses() throws IOException {
        String root = new File("src/test/resources").getAbsolutePath();
        Files.walk(Paths.get("src/test/resources/api")).filter(Files::isDirectory).forEach(path -> {
            server.when(request().withPath(path.toFile().getAbsolutePath().substring(root.length()))).callback(callback().withCallbackClass(CommonCallback.class.getCanonicalName()));
        });
    }

    @AfterSuite
    public void stopServer() {
        server.stop();
        proxy.stop();
    }

    @Test
    public void getApiProjects() {
        Assert.assertEquals(getConnector().getApi().getProjects(), "http://localhost:50080/api/projects/");
    }

    private WeblateConnector getConnector() {
        return new WeblateConnector("http://localhost:50080", "password");
    }

    @Test
    public void getApiChanges() {
        Assert.assertEquals(getConnector().getApi().getChanges(), "http://localhost:50080/api/changes/");
    }

    @Test
    public void getApiComponents() {
        Assert.assertEquals(getConnector().getApi().getComponents(), "http://localhost:50080/api/components/");
    }

    @Test
    public void getApiLanguages() {
        Assert.assertEquals(getConnector().getApi().getLanguages(), "http://localhost:50080/api/languages/");
    }

    @Test
    public void getApiScreenshots() {
        Assert.assertEquals(getConnector().getApi().getScreenshots(), "http://localhost:50080/api/screenshots/");
    }

    @Test
    public void getApiSources() {
        Assert.assertEquals(getConnector().getApi().getSources(), "http://localhost:50080/api/sources/");
    }

    @Test
    public void getApiTranslations() {
        Assert.assertEquals(getConnector().getApi().getTranslations(), "http://localhost:50080/api/translations/");
    }

    @Test
    public void getApiUnits() {
        Assert.assertEquals(getConnector().getApi().getUnits(), "http://localhost:50080/api/units/");
    }

    @Test
    public void getProjects() {
        Projects projects = getConnector().getProjects();
        Assert.assertEquals(projects.getCount(), 2);
    }

    @Test
    public void getPreviousProjects() {
        WeblateConnector connector = getConnector();
        Projects projects = connector.getProjects();
        Projects nextProjects = connector.getNextProjects(projects);
        Assert.assertEquals(connector.getPreviousProjects(nextProjects), projects);
    }

    @Test
    public void getProject() {
        WeblateConnector connector = getConnector();
        Project project = connector.getProject("project");
        Assert.assertEquals(project.getRepository_url(), "http://127.0.0.1:8000/api/projects/hello/repository/");
    }

    @Test
    public void getComponents() {
        Components components = getConnector().getComponents();
        Assert.assertEquals(components.getCount(), 2);
    }

    @Test
    public void getPreviousComponents() {
        WeblateConnector connector = getConnector();
        Components nextComponents = connector.getNextComponents(connector.getComponents());
        Assert.assertNull(connector.getPreviousComponents(nextComponents).getPrevious());
    }

    @Test
    public void getComponentsOfProject() {
        WeblateConnector connector = getConnector();
        Components components = connector.getComponents("project");
        Assert.assertEquals(components.getCount(), 1);
    }

    @Test
    public void getComponent() {
        WeblateConnector connector = getConnector();
        Component component = connector.getComponent("project", "component");
        Assert.assertEquals(component.getBranch(), "master");
    }

    @Test
    public void getUnits() {
        WeblateConnector connector = getConnector();
        Units units = connector.getUnits();
        Assert.assertEquals(units.getCount(), 1);
    }

    @Test
    public void getPreviousUnits() {
        WeblateConnector connector = getConnector();
        Units nextUnits = connector.getNextUnits(connector.getUnits());
        Assert.assertNull(connector.getPreviousUnits(nextUnits).getPrevious());
    }

    @Test
    public void getLanguages() {
        WeblateConnector connector = getConnector();
        Languages languages = connector.getLanguages();
        Assert.assertEquals(languages.getCount(), 47);
    }

    @Test
    public void getPreviousLanguages() {
        WeblateConnector connector = getConnector();
        Languages languages = connector.getLanguages();
        Languages nextLanguages = connector.getNextLanguages(languages);
        Assert.assertEquals(connector.getPreviousLanguages(nextLanguages), languages);
    }

    @Test
    public void getChanges() {
        WeblateConnector connector = getConnector();
        Changes changes = connector.getChanges();
        Assert.assertEquals(changes.getCount(), 2);
    }

    @Test
    public void getPreviousChanges() {
        WeblateConnector connector = getConnector();
        Changes nextChanges = connector.getNextChanges(connector.getChanges());
        Assert.assertNull(connector.getPreviousChanges(nextChanges).getPrevious());
    }

    @Test
    public void getChangesOfProject() {
        WeblateConnector connector = getConnector();
        Changes changes = connector.getChanges("project");
        Assert.assertEquals(changes.getCount(), 2);
    }

    @Test
    public void getChangesOfComponent() {
        WeblateConnector connector = getConnector();
        Changes changes = connector.getChanges("project", "component");
        Assert.assertEquals(changes.getCount(), 2);
    }

    @Test
    public void getChangesOfComponentAndLanguage() {
        WeblateConnector connector = getConnector();
        Changes changes = connector.getChanges("project", "component", "fr");
        Assert.assertEquals(changes.getCount(), 2);
    }

    @Test
    public void getTranslations() {
        Translations translations = getConnector().getTranslations();
        Assert.assertEquals(translations.getCount(), 1);
    }

    @Test
    public void getPreviousTranslations() {
        WeblateConnector connector = getConnector();
        Translations nextTranslations = connector.getNextTranslations(connector.getTranslations());
        Assert.assertNull(connector.getPreviousTranslations(nextTranslations).getPrevious());
    }

    @Test
    public void getTranslationsOfComponent() {
        WeblateConnector connector = getConnector();
        Translations translations = connector.getTranslations("project", "component");
        Assert.assertEquals(translations.getCount(), 3);
    }

    @Test
    public void getTranslation() {
        WeblateConnector connector = getConnector();
        Translation translation = connector.getTranslation("project", "component", "fr");
        Assert.assertEquals(translation.getFilename(), "component-translation/src/main/resources/component-gui_fr.properties");
    }

    @Test
    public void getSources() {
        WeblateConnector connector = getConnector();
        Sources sources = connector.getSources();
        Assert.assertEquals(sources.getCount(), 2);
    }

    @Test
    public void getPreviousSources() {
        WeblateConnector connector = getConnector();
        Sources sources = connector.getSources();
        Sources nextSources = connector.getNextSources(sources);
        Assert.assertNull(connector.getPreviousSources(nextSources).getPrevious());
    }

    @Test
    public void getScreenshots() {
        WeblateConnector connector = getConnector();
        Screenshots screenshots = connector.getScreenshots();
        Assert.assertEquals(screenshots.getCount(), 0);
    }

    @Test
    public void getPreviousScreenshots() {
        WeblateConnector connector = getConnector();
        Screenshots screenshots = connector.getScreenshots();
        Screenshots nextScreenshots = connector.getNextScreenshots(screenshots);
        Assert.assertEquals(connector.getPreviousScreenshots(nextScreenshots), screenshots);
    }

    @Test
    public void getRepository() {
        WeblateConnector connector = getConnector();
        Repository repository = connector.getRepository("project", "component");
        Assert.assertEquals(repository.getStatus(),
                "On branch master\nYour branch is ahead of 'origin/master' by 1 commit.\n  " +
                        "(use \"git push\" to publish your local commits)\nnothing to commit, working directory clean\n");
    }

    @Test
    public void getLanguage() {
        WeblateConnector connector = getConnector();
        Language language = connector.getLanguage("fr");
        Assert.assertEquals(language.getCode(), "fr");
    }

    @Test
    public void getLock() {
        WeblateConnector connector = getConnector();
        Lock lock = connector.getLock("project", "component");
        Assert.assertFalse(lock.isLock());
    }

    @Test
    public void getStatistics() {
        WeblateConnector connector = getConnector();
        Statistics statistics = connector.getStatistics("project", "component");
        Assert.assertEquals(statistics.getResults().get(0).getLast_author(), "Markus");
    }

    @Test
    public void getPreviousStatistics() {
        WeblateConnector connector = getConnector();
        Statistics statistics = connector.getStatistics("project", "component");
        Statistics nextStatistcs = connector.getNextStatistics(statistics);
        Assert.assertEquals(connector.getPreviousStatistics(nextStatistcs), statistics);
    }

    @Test
    public void getComponentsChangedAfter() throws ParseException {
        WeblateConnector connector = getConnector();
        Set<String> components = connector.getComponentsChangedAfter("project", new SimpleDateFormat("dd-MM-yyyy").parse("01-06-2017"));
        Assert.assertFalse(components.isEmpty());
    }

}
