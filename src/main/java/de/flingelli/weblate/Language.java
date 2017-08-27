package de.flingelli.weblate;

public class Language {
    private String code;
    private String name;
    private int nplurals;
    private String pluralequation;
    private String direction;
    private String web_url;
    private String url;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNplurals() {
        return nplurals;
    }

    public void setNplurals(int nplurals) {
        this.nplurals = nplurals;
    }

    public String getPluralequation() {
        return pluralequation;
    }

    public void setPluralequation(String pluralequation) {
        this.pluralequation = pluralequation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
}
