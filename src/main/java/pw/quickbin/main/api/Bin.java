package pw.quickbin.main.api;

public class Bin {

    private final String binKey;
    private final String fullUrl;
    private final String language;

    public Bin(String binKey, String fullUrl, String language){
        this.binKey = binKey;
        this.fullUrl = fullUrl;
        this.language = language;
    }

    /**
     * The identifier of the bin (e.g. https://quickbin.pw/view/{identifier})
     * @return the identifier of the bin.
     */
    public String getBinKey(){
        return binKey;
    }

    /**
     * Returns the full URL of the bin.
     * @return the full URL of the bin as a string.
     */
    public String getFullUrl(){
        return fullUrl;
    }

    /**
     * Returns the language of the bin.
     * @return the language of the bin.
     */
    public String getLanguage(){
        return language;
    }

}
