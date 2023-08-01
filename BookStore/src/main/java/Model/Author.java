package Model;

import java.sql.Date;
import java.util.Objects;

public class Author {
	private String authorID;
	private String authorName;
	private Date dateOfBirth;
	private String story;
	
	public Author () {
		
	}
	
	public Author(String authorID, String authorName, Date dateOfBirth, String story) {
		this.authorID = authorID;
		this.authorName = authorName;
		this.dateOfBirth = dateOfBirth;
		this.story = story;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorID, authorName, dateOfBirth, story);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(authorID, other.authorID);
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", authorName=" + authorName + ", dateOfBirth=" + dateOfBirth
				+ ", story=" + story + "]";
	}
	
	
}
