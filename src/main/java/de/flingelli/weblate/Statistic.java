package de.flingelli.weblate;


public class Statistic {
    private String last_author;
    private String name;
    private String last_change;
    private String url_translate;
    private String language;
    private String code;
    private int total;
    private int translated;
    private double translated_percent;
    private int total_words;
    private int translated_words;
    private double words_percent;

    public String getLast_author() {
        return last_author;
    }

    public void setLast_author(String last_author) {
        this.last_author = last_author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_change() {
        return last_change;
    }

    public void setLast_change(String last_change) {
        this.last_change = last_change;
    }

    public String getUrl_translate() {
        return url_translate;
    }

    public void setUrl_translate(String url_translate) {
        this.url_translate = url_translate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTranslated() {
        return translated;
    }

    public void setTranslated(int translated) {
        this.translated = translated;
    }

    public double getTranslated_percent() {
        return translated_percent;
    }

    public void setTranslated_percent(double translated_percent) {
        this.translated_percent = translated_percent;
    }

    public int getTotal_words() {
        return total_words;
    }

    public void setTotal_words(int total_words) {
        this.total_words = total_words;
    }

    public int getTranslated_words() {
        return translated_words;
    }

    public void setTranslated_words(int translated_words) {
        this.translated_words = translated_words;
    }

    public double getWords_percent() {
        return words_percent;
    }

    public void setWords_percent(double words_percent) {
        this.words_percent = words_percent;
    }
}
