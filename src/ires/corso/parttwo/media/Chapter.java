package ires.corso.parttwo.media;

public class Chapter implements Cloneable
{
    private final String chapterContent;

    public Chapter(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Chapter(this.chapterContent);
    }
}
