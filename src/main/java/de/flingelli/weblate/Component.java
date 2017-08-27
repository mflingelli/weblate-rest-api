package de.flingelli.weblate;

public class Component {
    private String name;
    private String slug;
    private Project project;
    private String vcs;
    private String repo;
    private String git_export;
    private String branch;
    private String filemask;
    private String template;
    private String new_base;
    private String file_format;
    private String license;
    private String license_url;
    private String web_url;
    private String url;
    private String repository_url;
    private String translations_url;
    private String statistics_url;
    private String lock_url;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getVcs() {
        return vcs;
    }

    public void setVcs(String vcs) {
        this.vcs = vcs;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getGit_export() {
        return git_export;
    }

    public void setGit_export(String git_export) {
        this.git_export = git_export;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFilemask() {
        return filemask;
    }

    public void setFilemask(String filemask) {
        this.filemask = filemask;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getNew_base() {
        return new_base;
    }

    public void setNew_base(String new_base) {
        this.new_base = new_base;
    }

    public String getFile_format() {
        return file_format;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicense_url() {
        return license_url;
    }

    public void setLicense_url(String license_url) {
        this.license_url = license_url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getTranslations_url() {
        return translations_url;
    }

    public void setTranslations_url(String translations_url) {
        this.translations_url = translations_url;
    }

    public String getStatistics_url() {
        return statistics_url;
    }

    public void setStatistics_url(String statistics_url) {
        this.statistics_url = statistics_url;
    }

    public String getLock_url() {
        return lock_url;
    }

    public void setLock_url(String lock_url) {
        this.lock_url = lock_url;
    }

    public String getChanges_list_url() {
        return changes_list_url;
    }

    public void setChanges_list_url(String changes_list_url) {
        this.changes_list_url = changes_list_url;
    }
}
