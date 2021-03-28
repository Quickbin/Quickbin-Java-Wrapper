package pw.quickbin.main.exceptions;

public class RateLimitedException extends Exception{

    public RateLimitedException(boolean token){
        super("You are rate-limited on " + (token ? "token requests" : "ip requests") + "... please check https://docs.quickbin.pw/actions/requesting-a-token for details.");
    }

}
