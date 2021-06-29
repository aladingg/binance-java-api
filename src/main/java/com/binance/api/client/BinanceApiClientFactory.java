package com.binance.api.client;

import com.binance.api.client.impl.*;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.getSharedClient;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    /**
     * Proxy Host
     */
    private String proxyHost;

    /**
     * Proxy Port
     */
    private Integer proxyPort;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceApiClientFactory(String apiKey, String secret) {
        this(apiKey, secret, null, null);
    }

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     * @param proxyHost the Proxy Host
     * @param proxyPort the Proxy Port
     */
    private BinanceApiClientFactory(String apiKey, String secret, String proxyHost, Integer proxyPort) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     *
     * @return the binance api client factory
     */
    public static BinanceApiClientFactory newInstance(String apiKey, String secret, String proxyHost, Integer proxyPort) {
        return new BinanceApiClientFactory(apiKey, secret, proxyHost, proxyPort);
    }

    /**
     * New instance without proxy
     *
     * @return the binance api client factory
     */
    public static BinanceApiClientFactory newInstance(String apiKey, String secret) {
        return new BinanceApiClientFactory(apiKey, secret, null, null);
    }


    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     */
    public static BinanceApiClientFactory newInstance() {
        return new BinanceApiClientFactory(null, null);
    }

    /**
     * Creates a new synchronous/blocking REST client.
     */
    public BinanceApiRestClient newRestClient() {
        return new BinanceApiRestClientImpl(apiKey, secret, proxyHost, proxyPort);
    }

    /**
     * Creates a new asynchronous/non-blocking Margin REST client.
     */
    public BinanceApiAsyncMarginRestClient newAsyncMarginRestClient() {
        return new BinanceApiAsyncMarginRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new synchronous/blocking Margin REST client.
     */
    public BinanceApiMarginRestClient newMarginRestClient() {
        return new BinanceApiMarginRestClientImpl(apiKey, secret);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BinanceApiWebSocketClient newWebSocketClient() {
        return new BinanceApiWebSocketClientImpl(getSharedClient());
    }

    /**
     * Creates a new synchronous/blocking Swap REST client.
     */
    public BinanceApiSwapRestClient newSwapRestClient() {
        return new BinanceApiSwapRestClientImpl(apiKey, secret);
    }
}
