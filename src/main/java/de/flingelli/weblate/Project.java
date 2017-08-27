package de.flingelli.weblate;

import java.util.Map;

public class Project {
    private String name;
    private String slug;
    private Map<String, String> source_language;
    private String web;
    private String components_list_url;
    private String repository_url;
    private String changes_list_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Map<String, String> getSource_language() {
        return source_language;
    }

    public void setSource_language(Map<String, String> source_language) {
        this.source_language = source_language;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getComponents_list_url() {
        return components_list_url;
    }

    public void setComponents_list_url(String components_list_url) {
        this.components_list_url = components_list_url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getChanges_list_url() {
        return changes_list_url;
    }

    public void setChanges_list_url(String changes_list_url) {
        this.changes_list_url = changes_list_url;
    }
}
