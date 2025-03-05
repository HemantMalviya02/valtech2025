package webservices;
import java.util.List;

public class Movie {
	private int id;
	private String name;
	private String language;
	private String genre;
	
	private List<String> actors;

	public Movie () {}
	
	public Movie(int id, String name, String language, String genre, List<String> actors) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.genre = genre;
		this.actors = actors;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", language=" + language + ", genre=" + genre + ", actors="
				+ actors + "]";
	}
	
	
}
