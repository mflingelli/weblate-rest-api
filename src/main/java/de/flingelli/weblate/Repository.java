package de.flingelli.weblate;

public class Repository {
    private boolean needs_commit;
    private boolean needs_merge;
    private boolean needs_push;
    private Object remote_commit;
    private String status;
    private String merge_failure;

    public boolean isNeeds_commit() {
        return needs_commit;
    }

    public void setNeeds_commit(boolean needs_commit) {
        this.needs_commit = needs_commit;
    }

    public boolean isNeeds_merge() {
        return needs_merge;
    }

    public void setNeeds_merge(boolean needs_merge) {
        this.needs_merge = needs_merge;
    }

    public boolean isNeeds_push() {
        return needs_push;
    }

    public void setNeeds_push(boolean needs_push) {
        this.needs_push = needs_push;
    }

    public Object getRemote_commit() {
        return remote_commit;
    }

    public void setRemote_commit(Object remote_commit) {
        this.remote_commit = remote_commit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerge_failure() {
        return merge_failure;
    }

    public void setMerge_failure(String merge_failure) {
        this.merge_failure = merge_failure;
    }
}
