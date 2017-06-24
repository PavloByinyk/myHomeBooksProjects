package ua.com.pbyinyk.util;

/**
 * Created by 1 on 05.04.2016.
 */
public enum Language {
    ENGLISH("Англійська"),
    RUSSIAN("Русский"),
    UCRAINE("Український");

    private String language;

    Language (String language){
        this.language=language;
    }
    public String getLanguage(){
        return language;
    }
}
