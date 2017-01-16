package bitbucketpullrequestbuilder.bitbucketpullrequestbuilder.bitbucket;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Comparator;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import bitbucketpullrequestbuilder.bitbucketpullrequestbuilder.BitbucketRepository;

/**
 * POJOs representing the pull-requests extracted from the
 * JSON response of the Bitbucket API V2.
 *
 * @see https://confluence.atlassian.com/bitbucket/pullrequests-resource-423626332.html#pullrequestsResource-GETaspecificpullrequest
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pullrequest {
    private static final Logger logger = Logger.getLogger(Pullrequest.class.getName());

    private String     id;
    private String     version;
    private String     title;
    private String     description;
    private String     state;
    private Boolean    open;
    private Boolean    closed;
    private String     createdDate;
    private String     updatedDate;
    private Reference  toRef;
    private Reference  fromRef;
    private Boolean    locked;
    private Author     author;
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        private int pageLength;
        private List<Pullrequest> pullrequests;
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
        public List<Pullrequest> getPullrequests() {
            return pullrequests;
        }
        @JsonProperty("values")
        public void setPullrequests(List<Pullrequest> pullrequests) {
            this.pullrequests = pullrequests;
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Reference {
    	private String id;
    	private String displayId;
    	private String latestCommit;
    	private Repository repository;
    	
    	public String getId() {
    		return id;
    	}
    	
    	public void setId(String id) {
    		this.id = id;
    	}
    	
    	public String getDisplayId() {
    		return displayId;
    	}
    	
    	public void setDisplayId(String displayId) {
    		this.displayId = displayId;
    	}
    	
    	public String getLatestCommit() {
    		return latestCommit;
    	}
    	
    	public void setLatestCommit(String commit) {
    		this.latestCommit = commit;
    	}
    	
    	public Repository getRepository() {
    		return repository;
    	}
    	
    	public void setRepository(Repository repository) {
    		this.repository = repository;
    	}
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Clone {
    	private String href;
    	private String name;
    	
    	public String getHref() {
    		return href;
    	}
    	
    	public void setHref(String href) {
    		this.href = href;
    	}
    	
    	public String getName() {
    		return name;
    	}
    	
    	public void setName(String name) {
    		this.name = name;
    	}
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true) 
    public static class Links {
    	private ArrayList<Clone> clone;
    	
    	public ArrayList<Clone> getClone() {
    		return clone;
    	}
    	
    	public void setClone(ArrayList<Clone> clone) {
    		this.clone = clone;
    	}
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Repository {
        private String slug;
        private String id;
        private String name;
        private Project project;
        private Links links;
        
        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
        	this.slug = slug;
        }
        
        public String getId() {
        	return id;
        }
        
        public void setId(String id) {
        	this.id = id;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public Project getProject() {
            return project;
        }
        
        public void setProject(Project project) {
            this.project = project;
        }
        
        public Links getLinks() {
        	return links;
        }
        
        public void setLinks(Links links) {
        	this.links = links;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Owner {
    	private String name;
    	
    	public String getName() {
    		return name;
    	}
    	
    	public void setName(String name) {
    		this.name = name;
    	}
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Project {
    	private String key;
    	private String id;
    	private String name;
    	private String type;
    	private Owner owner;
    	
    	public String getKey() {
    		return key;
    	}
    	
    	public void setKey(String key) {
    		this.key = key;
    	}

    	public String getId() {
    		return id;
    	}
    	
    	public void setId(String id) {
    		this.id = id;
    	}

    	public String getName() {
    		return name;
    	}
    	
    	public void setName(String name) {
    		this.name = name;
    	}
    	
    	public String getType() {
    		return type;
    	}
    	
    	public void setType(String type) {
    		this.type = type;
    	}
    	
    	public Owner getOwner() {
    		return owner;
    	}
    	
    	public void setOwner(Owner owner) {
    		this.owner = owner;
    	}
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Branch {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Commit {
        private String hash;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }

    // Was: Approval
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Participant {
        private String role;
        private Boolean approved;

        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public Boolean getApproved() {
            return approved;
        }
        public void setApproved(Boolean approved) {
            this.approved = approved;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Anchor {	
    }
    
    // https://confluence.atlassian.com/bitbucket/pullrequests-resource-1-0-296095210.html#pullrequestsResource1.0-POSTanewcomment
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Comment implements Comparable<Comment> {
        private Integer id;
        private Object  properties;
        private Integer version;
        private String  text;

        public int compareTo(Comment target) {
            if (this.getId() > target.getId()) {
                return 1;
            } else if (this.getId().equals(target.getId())) {
                return 0;
            } else {
                return -1;
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public String getContent() {
            return text;
        }

        @JsonProperty("text")
        public void setContent(String content) {
            this.text = content;
        }
    }
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author {
      private String username;
      private String display_name;
      public static final String COMBINED_NAME = "%s <@%s>";
      
      public String getUsername() {
          return username;
      }
      public void setUsername(String username) {
          this.username = username;
      }
      
      @JsonProperty("display_name")
      public String getDisplayName() {
          return display_name;
      }
      
      @JsonProperty("display_name")
      public void setDisplayName(String display_name) {
          this.display_name = display_name;
      }
      public String getCombinedUsername() {
        return String.format(COMBINED_NAME, this.getDisplayName(), this.getUsername());
      }
    }

    //-------------------- only getters and setters follow -----------------

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Reference getToRef() {
        return toRef;
    }

    public void setToRef(Reference toRef) {
        this.toRef = toRef;
    }

    public Reference getFromRef() {
    	return fromRef;
    }
    
    public void setFromRef(Reference fromRef) {
        this.fromRef = fromRef;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Author getAuthor() {
      return this.author;
    }
    
    public void setAutohor(Author author) {
      this.author = author;
    }
    
    public String getVersion() {
    	return version;
    }
    
    public void setVersion(String version) {
    	this.version = version;
    }
    
    public Boolean getOpen() {
    	return open;
    }
    
    public void setOpen(Boolean open) {
    	this.open = open;
    }
    
    public Boolean getClosed() {
    	return closed;
    }
    
    public void setClosed(Boolean closed) {
    	this.closed = closed;
    }
    
    public Boolean getLocked() {
    	return locked;
    }
    
    public void setLocked(Boolean locked) {
    	this.locked = locked;
    }
}
