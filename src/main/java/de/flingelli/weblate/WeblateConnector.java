package de.flingelli.weblate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeblateConnector {
    private static final int HTTP_OK = 200;
    private final SimpleDateFormat timeStampFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private final String url;
    private final String token;
    private final Client client;

    public WeblateConnector(String url, String token) {
        this.url = url;
        this.token = token;
        client = ClientBuilder.newClient();
    }

    public Api getApi() {
        Response response = getWebTarget("/api").request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Api>(){});
        }
        return new Api();
    }

    private WebTarget getWebTarget(String path) {
        if (path.contains("?page=")) {
            String[] items = path.split("page=");
            return client.target(url).path(path.substring(0, path.indexOf('?'))).queryParam("page", items[1]);
        } else {
            return client.target(url).path(path);
        }
    }

    public Projects getProjects() {
        return getCommonProjects("/api/projects");
    }

    public Projects getNextProjects(Projects projects) {
        if (projects.getNext() != null) {
            return getCommonProjects(projects.getNext().substring(url.length()));
        }
        return projects;
    }

    public Projects getPreviousProjects(Projects projects) {
        if (projects.getPrevious() != null) {
            return getCommonProjects(projects.getPrevious().substring(url.length()));
        }
        return projects;
    }

    public Projects getCommonProjects(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Projects>(){});
        }
        return new Projects();
    }

    public Project getProject(String project) {
        Response response = getWebTarget("/api/projects/" + project).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Project>(){});
        }
        return new Project();
    }

    public Components getComponents() {
        return getCommonComponents("/api/components");
    }

    public Components getComponents(String project) {
        return getCommonComponents("/api/projects/" + project + "/components");
    }

    public Components getNextComponents(Components components) {
        if (components.getNext() != null) {
            return getCommonComponents(components.getNext().substring(url.length()));
        }
        return components;
    }

    public Components getPreviousComponents(Components components) {
        if (components.getPrevious() != null) {
            return getCommonComponents(components.getPrevious().substring(url.length()));
        }
        return components;
    }

    private Components getCommonComponents(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Components>(){});
        }
        return new Components();
    }

    public Component getComponent(String project, String component) {
        Response response = getWebTarget("/api/components/" + project + "/" + component).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Component>(){});
        }
        return new Component();
    }

    public Units getUnits() {
        return getCommonUnits("/api/units");
    }

    public Units getNextUnits(Units units) {
        if (units.getNext() != null) {
            return getCommonUnits(units.getNext().substring(url.length()));
        }
        return units;
    }

    public Units getPreviousUnits(Units units) {
        if (units.getPrevious() != null) {
            return getCommonUnits(units.getPrevious().substring(url.length()));
        }
        return units;
    }

    private Units getCommonUnits(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Units>(){});
        }
        return new Units();
    }

    public Languages getLanguages() {
        return getCommonLanguages("/api/languages");
    }

    public Languages getNextLanguages(Languages languages) {
        if (languages.getNext() != null) {
            return getCommonLanguages(languages.getNext().substring(url.length()));
        }
        return languages;
    }

    public Languages getPreviousLanguages(Languages languages) {
        if (languages.getPrevious() != null) {
            return getCommonLanguages(languages.getPrevious().substring(url.length()));
        }
        return languages;
    }

    private Languages getCommonLanguages(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Languages>(){});
        }
        return new Languages();
    }

    public Changes getChanges() {
        return getCommonChanges("/api/changes");
    }

    public Changes getChanges(String project) {
        return getCommonChanges("/api/projects/" + project + "/changes");
    }

    public Changes getChanges(String project, String component) {
        return getCommonChanges("/api/components/" + project + "/" + component + "/changes");
    }

    public Changes getChanges(String project, String component, String language) {
        return getCommonChanges("/api/translations/" + project + "/" + component + "/" + language + "/changes");
    }

    public Changes getNextChanges(Changes changes) {
        if (changes.getNext() != null) {
            return getCommonChanges(changes.getNext().substring(url.length()));
        }
        return changes;
    }

    public Changes getPreviousChanges(Changes changes) {
        if (changes.getPrevious() != null) {
            return getCommonChanges(changes.getPrevious().substring(url.length()));
        }
        return changes;
    }

    private Changes getCommonChanges(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Changes>(){});
        }
        return new Changes();
    }

    public Translations getTranslations() {
        return getCommonTranslations("/api/translations");
    }

    public Translations getNextTranslations(Translations translations) {
        if (translations.getNext() != null) {
            return getCommonTranslations(translations.getNext().substring(url.length()));
        }
        return translations;
    }

    public Translations getPreviousTranslations(Translations translations) {
        if (translations.getPrevious() != null) {
            return getCommonTranslations(translations.getPrevious().substring(url.length()));
        }
        return translations;
    }


    public Translations getTranslations(String project, String component) {
        return getCommonTranslations("/api/components/" + project + "/" + component + "/translations");
    }

    public Translation getTranslation(String project, String component, String language) {
        return getCommonTranslation("/api/translations/" + project + "/" + component + "/" + language);
    }

    private Translation getCommonTranslation(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Translation>(){});
        }
        return new Translation();
    }

    private Translations getCommonTranslations(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Translations>(){});
        }
        return new Translations();
    }

    public Sources getSources() {
        return getCommonSources("/api/sources");
    }

    public Sources getNextSources(Sources sources) {
        if (sources.getNext() != null) {
            return getCommonSources(sources.getNext().substring(url.length()));
        }
        return sources;
    }

    public Sources getPreviousSources(Sources sources) {
        if (sources.getPrevious() != null) {
            return getCommonSources(sources.getPrevious().substring(url.length()));
        }
        return sources;
    }

    private Sources getCommonSources(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Sources>(){});
        }
        return new Sources();
    }

    public Screenshots getScreenshots() {
        return getCommonScreenshots("/api/screenshots");
    }

    public Screenshots getNextScreenshots(Screenshots screenshots) {
        if (screenshots.getNext() != null) {
            return getCommonScreenshots(screenshots.getNext().substring(url.length()));
        }
        return screenshots;
    }

    public Screenshots getPreviousScreenshots(Screenshots screenshots) {
        if (screenshots.getPrevious() != null) {
            return getCommonScreenshots(screenshots.getPrevious().substring(url.length()));
        }
        return screenshots;
    }

    private Screenshots getCommonScreenshots(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Screenshots>(){});
        }
        return new Screenshots();
    }

    public Repository getRepository(String project, String component) {
        Response response = getWebTarget("/api/components/" + project + "/" + component + "/repository").request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Repository>(){});
        }
        return new Repository();
    }

    public Language getLanguage(String language) {
        Response response = getWebTarget("/api/languages/" + language).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Language>(){});
        }
        return new Language();
    }

    public Lock getLock(String project, String component) {
        Response response = getWebTarget("/api/components/" + project + "/" + component + "/lock").request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Lock>(){});
        }
        return new Lock();
    }

    public Statistics getStatistics(String project, String component) {
        return getCommonStatistics("/api/components/" + project + "/" + component + "/statistics");
    }

    public Statistics getNextStatistics(Statistics statistics) {
        if (statistics.getNext() != null) {
            return getCommonStatistics(statistics.getNext().substring(url.length()));
        }
        return statistics;
    }

    public Statistics getPreviousStatistics(Statistics statistics) {
        if (statistics.getPrevious() != null) {
            return getCommonStatistics(statistics.getPrevious().substring(url.length()));
        }
        return statistics;
    }

    private Statistics getCommonStatistics(String path) {
        Response response = getWebTarget(path).request(MediaType.APPLICATION_JSON).header("Authorization", "Token " + token).get(Response.class);
        if (response.getStatus() == HTTP_OK) {
            return response.readEntity(new GenericType<Statistics>(){});
        }
        return new Statistics();
    }

    public Set<String> getComponentsChangedAfter(String project, Date date) {
        Set<String> result = new HashSet<>();
        Changes changes = getChanges(project);
        List<Change> changesList = new ArrayList<>(changes.getResults());
        while(changes.getNext() != null && isAfter(changesList.get(changesList.size() - 1), date)) {
            changes = getNextChanges(changes);
            changesList.addAll(changes.getResults());
        }
        changesList.stream().filter(change -> isAfter(change, date)).forEach(change -> result.add(change.getComponent()));
        return result;
    }

    public Set<String> getComponentsChangedAfter(String project, String language, Date date) {
        Set<String> result = new HashSet<>();
        Components components = getComponents(project);
        List<Component> componentList = new ArrayList<>(components.getResults());
        while(components.getNext() != null) {
            components = getNextComponents(components);
            componentList.addAll(components.getResults());
        }
        componentList.forEach(component -> {
            Changes changes = getChanges(project, component.getSlug(), language);
            if (changes.getResults() != null && !changes.getResults().isEmpty()) {
                Change change = changes.getResults().get(0);
                if (isAfter(change, date)) {
                    result.add(change.getComponent());
                }
            }
        });
        return result;
    }

    boolean isAfter(Change change, Date date) {
        return getDate(change.getTimestamp()).after(date);
    }

    Date getDate(String timestamp) {
        try {
            timeStampFormat.setTimeZone(TimeZone.getTimeZone("CET"));
            return timeStampFormat.parse(timestamp);
        } catch (ParseException e) {

        }
        return new Date();
    }
}
