package bitbucketpullrequestbuilder.bitbucketpullrequestbuilder.bitbucket;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import bitbucketpullrequestbuilder.bitbucketpullrequestbuilder.bitbucket.Pullrequest.Anchor;
import bitbucketpullrequestbuilder.bitbucketpullrequestbuilder.bitbucket.Pullrequest.Comment;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        private int pageLength;
        private List<Activity> activities;
        private int page;
        private int size;

        @JsonProperty("pagelen")
        public int getPageLength() {
            return pageLength;
        }
        @JsonProperty("pagelen")
        public void setPageLength(int pageLength) {
            this.pageLength = pageLength;
        }
        @JsonProperty("values")
        public List<Activity> getActivities() {
            return activities;
        }
        @JsonProperty("values")
        public void setActivities(List<Activity> activities) {
            this.activities = activities;
        }
        public int getPage() {
            return page;
        }
        public void setPage(int page) {
            this.page = page;
        }
        public int getSize() {
            return size;
        }
        public void setSize(int size) {
            this.size = size;
        }
    }

    private String action;
    private String commentAction;
    private Comment comment;
    private Anchor commentAnchor;

    public String getAction() {
    	return action;
    }

    public void setAction(String action) {
    	this.action = action;
    }

    public String getCommentAction() {
    	return commentAction;
    }

    public void setCommentAction(String commentAction) {
    	this.commentAction = commentAction;
    }

    public Comment getComment() {
    	return comment;
    }

    public void setComment(Comment comment) {
    	this.comment = comment;
    }

    public Anchor getCommentAnchor() {
    	return commentAnchor;
    }

    public void setCommentAnchor(Anchor commentAnchor) {
    	this.commentAnchor = commentAnchor;
    }
}
