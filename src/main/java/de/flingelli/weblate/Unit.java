package de.flingelli.weblate;

public class Unit {
    private String translation;
    private String source;
    private String previous_source;
    private String target;
    private String id_hash;
    private String content_hash;
    private String location;
    private String context;
    private String comment;
    private String flags;
    private boolean fuzzy;
    private boolean translated;
    private int position;
    private boolean has_suggestion;
    private boolean has_comment;
    private boolean has_failing_check;
    private int num_words;
    private int priority;
    private int id;
    private String web_url;
    private String url;
    private String source_info;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPrevious_source() {
        return previous_source;
    }

    public void setPrevious_source(String previous_source) {
        this.previous_source = previous_source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getId_hash() {
        return id_hash;
    }

    public void setId_hash(String id_hash) {
        this.id_hash = id_hash;
    }

    public String getContent_hash() {
        return content_hash;
    }

    public void setContent_hash(String content_hash) {
        this.content_hash = content_hash;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public boolean isFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(boolean fuzzy) {
        this.fuzzy = fuzzy;
    }

    public boolean isTranslated() {
        return translated;
    }

    public void setTranslated(boolean translated) {
        this.translated = translated;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isHas_suggestion() {
        return has_suggestion;
    }

    public void setHas_suggestion(boolean has_suggestion) {
        this.has_suggestion = has_suggestion;
    }

    public boolean isHas_comment() {
        return has_comment;
    }

    public void setHas_comment(boolean has_comment) {
        this.has_comment = has_comment;
    }

    public boolean isHas_failing_check() {
        return has_failing_check;
    }

    public void setHas_failing_check(boolean has_failing_check) {
        this.has_failing_check = has_failing_check;
    }

    public int getNum_words() {
        return num_words;
    }

    public void setNum_words(int num_words) {
        this.num_words = num_words;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSource_info() {
        return source_info;
    }

    public void setSource_info(String source_info) {
        this.source_info = source_info;
    }
}
