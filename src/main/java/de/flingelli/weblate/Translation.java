package de.flingelli.weblate;

public class Translation {
    private Language language;
    private Component component;
    private String translated;
    private int fuzzy;
    private int total;
    private int translated_words;
    private int fuzzy_words;
    private int failing_checks_words;
    private int total_words;
    private int failing_checks;
    private int have_suggestion;
    private int have_comment;
    private String language_code;
    private String filename;
    private String revision;
    private String web_url;
    private String share_url;
    private String translate_url;
    private String url;
    private boolean is_template;
    private double translated_percent;
    private double fuzzy_percent;
    private double failing_checks_percent;
    private String last_change;
    private String last_author;
    private String repository_url;
    private String file_url;
    private String statistics_url;
    private String changes_list_url;
    private String units_list_url;

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

    public int getFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(int fuzzy) {
        this.fuzzy = fuzzy;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTranslated_words() {
        return translated_words;
    }

    public void setTranslated_words(int translated_words) {
        this.translated_words = translated_words;
    }

    public int getFuzzy_words() {
        return fuzzy_words;
    }

    public void setFuzzy_words(int fuzzy_words) {
        this.fuzzy_words = fuzzy_words;
    }

    public int getFailing_checks_words() {
        return failing_checks_words;
    }

    public void setFailing_checks_words(int failing_checks_words) {
        this.failing_checks_words = failing_checks_words;
    }

    public int getTotal_words() {
        return total_words;
    }

    public void setTotal_words(int total_words) {
        this.total_words = total_words;
    }

    public int getFailing_checks() {
        return failing_checks;
    }

    public void setFailing_checks(int failing_checks) {
        this.failing_checks = failing_checks;
    }

    public int getHave_suggestion() {
        return have_suggestion;
    }

    public void setHave_suggestion(int have_suggestion) {
        this.have_suggestion = have_suggestion;
    }

    public int getHave_comment() {
        return have_comment;
    }

    public void setHave_comment(int have_comment) {
        this.have_comment = have_comment;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getTranslate_url() {
        return translate_url;
    }

    public void setTranslate_url(String translate_url) {
        this.translate_url = translate_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isIs_template() {
        return is_template;
    }

    public void setIs_template(boolean is_template) {
        this.is_template = is_template;
    }

    public double getTranslated_percent() {
        return translated_percent;
    }

    public void setTranslated_percent(double translated_percent) {
        this.translated_percent = translated_percent;
    }

    public double getFuzzy_percent() {
        return fuzzy_percent;
    }

    public void setFuzzy_percent(double fuzzy_percent) {
        this.fuzzy_percent = fuzzy_percent;
    }

    public double getFailing_checks_percent() {
        return failing_checks_percent;
    }

    public void setFailing_checks_percent(double failing_checks_percent) {
        this.failing_checks_percent = failing_checks_percent;
    }

    public String getLast_change() {
        return last_change;
    }

    public void setLast_change(String last_change) {
        this.last_change = last_change;
    }

    public String getLast_author() {
        return last_author;
    }

    public void setLast_author(String last_author) {
        this.last_author = last_author;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getStatistics_url() {
        return statistics_url;
    }

    public void setStatistics_url(String statistics_url) {
        this.statistics_url = statistics_url;
    }

    public String getChanges_list_url() {
        return changes_list_url;
    }

    public void setChanges_list_url(String changes_list_url) {
        this.changes_list_url = changes_list_url;
    }

    public String getUnits_list_url() {
        return units_list_url;
    }

    public void setUnits_list_url(String units_list_url) {
        this.units_list_url = units_list_url;
    }
}
