package com.binance.api.client;

import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.*;
import com.binance.api.client.domain.general.Coin;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface BinanceApiRestClient {

    // General endpoints

    BinanceApiRestClient withMainAccount();

    BinanceApiRestClient withSubAccount(String apiKey, String secret);

    /**
     * Test connectivity to the Rest API.
     */
    void ping();

    /**
     * Test connectivity to the Rest API and get the current server time.
     *
     * @return current server time.
     */
    Long getServerTime();

    /**
     * @return Current exchange trading rules and symbol information
     */
    ExchangeInfo getExchangeInfo();

    /**
     * @return All Token Binance Support Depositing and Withdrawing
     */
    List<Coin> getAllCoins();

    // Market Data endpoints

    /**
     * Get order book of a symbol.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  depth of the order book (max 100)
     */
    OrderBook getOrderBook(String symbol, Integer limit);

    /**
     * Get recent trades (up to last 500). Weight: 1
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  of last trades (Default 500; max 1000.)
     */
    List<TradeHistoryItem> getTrades(String symbol, Integer limit);

    /**
     * Get older trades. Weight: 5
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     * @param limit  of last trades (Default 500; max 1000.)
     * @param fromId TradeId to fetch from. Default gets most recent trades.
     */
    List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId);

    /**
     * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with
     * the same price will have the quantity aggregated.
     * <p>
     * If both <code>startTime</code> and <code>endTime</code> are sent, <code>limit</code>should not
     * be sent AND the distance between <code>startTime</code> and <code>endTime</code> must be less than 24 hours.
     *
     * @param symbol    symbol to aggregate (mandatory)
     * @param fromId    ID to get aggregate trades from INCLUSIVE (optional)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get aggregate trades from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get aggregate trades until INCLUSIVE (optional).
     * @return a list of aggregate trades for the given symbol
     */
    List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime);

    /**
     * Return the most recent aggregate trades for <code>symbol</code>
     *
     * @see #getAggTrades(String, String, Integer, Long, Long)
     */
    List<AggTrade> getAggTrades(String symbol);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @param symbol    symbol to aggregate (mandatory)
     * @param interval  candlestick interval (mandatory)
     * @param limit     Default 500; max 1000 (optional)
     * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
     * @param endTime   Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
     * @return a candlestick bar for the given symbol and interval
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime);

    /**
     * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
     *
     * @see #getCandlestickBars(String, CandlestickInterval, Integer, Long, Long)
     */
    List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval);

    /**
     * Get 24 hour price change statistics.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    TickerStatistics get24HrPriceStatistics(String symbol);

    /**
     * Get 24 hour price change statistics for all symbols.
     */
    List<TickerStatistics> getAll24HrPriceStatistics();

    /**
     * Get Latest price for all symbols.
     */
    List<TickerPrice> getAllPrices();

    /**
     * Get latest price for <code>symbol</code>.
     *
     * @param symbol ticker symbol (e.g. ETHBTC)
     */
    TickerPrice getPrice(String symbol);

    /**
     * Get best price/qty on the order book for all symbols.
     */
    List<BookTicker> getBookTickers();

    // Account endpoints

    /**
     * Send in a new order.
     *
     * @param order the new order to submit.
     * @return a response containing details about the newly placed order.
     */
    NewOrderResponse newOrder(NewOrder order);

    /**
     * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into the matching engine.
     *
     * @param order the new TEST order to submit.
     */
    void newOrderTest(NewOrder order);

    /**
     * Check an order's status.
     *
     * @param orderStatusRequest order status request options/filters
     * @return an order
     */
    Order getOrderStatus(OrderStatusRequest orderStatusRequest);

    /**
     * Cancel an active order.
     *
     * @param cancelOrderRequest order status request parameters
     */
    CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);

    /**
     * Get all open orders on a symbol.
     *
     * @param orderRequest order request parameters
     * @return a list of all account open orders on a symbol.
     */
    List<Order> getOpenOrders(OrderRequest orderRequest);

    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param orderRequest order request parameters
     * @return a list of all account orders
     */
    List<Order> getAllOrders(AllOrdersRequest orderRequest);

    /**
     * Get all account orders; active, canceled, or filled.
     *
     * @param symbol    symbol to get orders from
     * @param orderId   order id to get
     * @param startTime start time
     * @param endTime   end time
     * @param limit     default 500, max 1000
     * @return a list of all account orders
     */
    List<Order> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

    /**
     * Get current account information.
     */
    Account getAccount(Long recvWindow, Long timestamp);

    /**
     * Get current account information using default parameters.
     */
    Account getAccount();

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol    symbol to get trades from
     * @param limit     default 500; max 1000
     * @param startTime Start time
     * @param endTime   End time
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol, Integer limit, Long startTime, Long endTime);

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol symbol to get trades from
     * @param limit  default 500; max 1000
     * @param fromId TradeId to fetch from. Default gets most recent trades.
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp);

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol symbol to get trades from
     * @param limit  default 500; max 1000
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol, Integer limit);

    /**
     * Get trades for a specific account and symbol.
     *
     * @param symbol symbol to get trades from
     * @return a list of trades
     */
    List<Trade> getMyTrades(String symbol);

    /**
     * Fetch deposit address.
     *
     * @return deposit address.
     */
    DepositAddress getDepositAddress(String network, String coin);

    // User stream endpoints

    List<Deposit> getDepositHistory(String coin, DepositStatus depositStatus, Date startTime, Date endTime, Integer offset, Integer limit);

    /**
     * Start a new user data stream.
     *
     * @return a listen key that can be used with data streams
     */
    String startUserDataStream();

    /**
     * PING a user data stream to prevent a time out.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void keepAliveUserDataStream(String listenKey);

    /**
     * Close out a new user data stream.
     *
     * @param listenKey listen key that identifies a data stream
     */
    void closeUserDataStream(String listenKey);

    /////////////////////////////////////////////////////////// Broker API Begin ///////////////////////////////

    /**
     * Create Sub Account
     */
    CreateSubAccountResult createSubAccount(String tag);

    /**
     * Create Sub Account Api Key
     */
    SubAccountApiKey createSubAccountApiKey(String subAccountId, boolean canTrade);

    /**
     * Get Sub Account Api Key (Without Secret Key)
     */
    List<SubAccountApiKey> getSubAccountApiKey(String subAccountId);

    /**
     * Delete Sub Account Api Key
     */
    void deleteSubAccountApiKey(String subAccountId, String apiKey);

    /**
     * Get Broker Account Info
     */
    BrokerAccountInfo getBrokerAccountInfo();

    /**
     * Get Sub Account Info
     */
    SubAccount getSubAccount(String subAccountId);

    /**
     * Get All Sub Account
     */
//    List<SubAccount> getSubAccounts(Long page, Long size);
    List<SubAccount> getSubAccounts(Integer page, Integer size);

    /**
     * Get Sub Account Deposit History
     */
    List<SubAccountDeposit> getSubAccountDepositHistory(String subAccountId, Date startTime, Date endTime);

    /**
     * Submit a withdraw request.
     */
    WithdrawResult withdraw(String coin, String withdrawOrderId, String network, String address, String addressTag, BigDecimal amount, String name);

    /**
     * Sub Account Transfer
     */
    SubAccountTransferResult subAccountTransfer(String fromId, String toId, String clientTranId, String coin, BigDecimal amount);

    /**
     * Query Sub Account Transfer By ClientTranId
     */
    SubAccountTransferRecord getSubAccountTransfer(String clientTransId);

    /**
     * Query Sub Account Transfer List
     */
    List<SubAccountTransferRecord> getSubAccountTransferHistory(Date startTime, Date endTime, int page, int size);

    /**
     * Query Withdraw List
     */
    List<Withdraw> getWithdrawHistory(String coin, Withdraw.Status status, int offset, int limit, Date startTime, Date endTime);
}
