package pw.quickbin.main;

import pw.quickbin.main.api.QuickBin;
import pw.quickbin.main.impl.QuickBinFactory;

import java.util.concurrent.ExecutorService;

public class QuickbinBuilder {

    private String token;
    private String agent;
    private ExecutorService service;

    /**
     * Sets the token sent from the email.
     * @param token the token to use.
     * @return builder for chain requests.
     */
    public QuickbinBuilder setToken(String token){
        this.token = token;
        return this;
    }

    /**
     * Sets the custom user-agent sent from the email.
     * @param agent the custom user-agent to use.
     * @return builder for chain requests.
     */
    public QuickbinBuilder setAgent(String agent){
        this.agent = agent;
        return this;
    }

    /**
     * Sets the executor service for the requests, can be null.
     * @param service the executor service to use (can be null).
     * @return builder for chain requests.
     */
    public QuickbinBuilder setExecutorService(ExecutorService service){
        this.service = service;
        return this;
    }

    public QuickBin build(){
        return new QuickBinFactory(token, agent, service);
    }


}
