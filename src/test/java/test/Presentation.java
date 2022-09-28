package test;

import java.util.Objects;

public class Presentation {

    private final String title;
    private final String author;
    private final String url;

    public Presentation(String title, String author, String url) {
        this.title = title;
        this.author = author;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presentation that = (Presentation) o;
        return title.equals(that.title) && author.equals(that.author) && url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, url);
    }
}
