package com.binance.api.client.impl;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.*;
import com.binance.api.client.domain.general.Coin;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.*;
import retrofit2.Call;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.binance.api.client.impl.BinanceApiServiceGenerator.*;

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking method calls.
 */
public class BinanceApiRestClientImpl implements BinanceApiRestClient {

    private final BinanceApiService binanceApiService;

    private final String mainAccountApiKey;
    private final String mainAccountSecret;

    public BinanceApiRestClientImpl(String apiKey, String secret) {
        this(apiKey, secret, null, null);
    }

    public BinanceApiRestClientImpl(String apiKey, String secret, String proxyHost, Integer proxyPort) {
        mainAccountApiKey = apiKey;
        mainAccountSecret = secret;

        binanceApiService = createService(BinanceApiService.class, apiKey, secret, proxyHost, proxyPort);
    }

    @Override
    public BinanceApiRestClient withMainAccount() {
        switchApiKey(mainAccountApiKey, mainAccountSecret);
        return this;
    }

    @Override
    public BinanceApiRestClient withSubAccount(String apiKey, String secret) {
        switchApiKey(apiKey, secret);
        return this;
    }

    // General endpoints

    @Override
    public void ping() {
        executeSync(binanceApiService.ping());
    }

    @Override
    public Long getServerTime() {
        return executeSync(binanceApiService.getServerTime()).getServerTime();
    }

    @Override
    public ExchangeInfo getExchangeInfo() {
        return executeSync(binanceApiService.getExchangeInfo());
    }

    @Override
    public List<Coin> getAllCoins() {
        return executeSync(binanceApiService.getAllCoins(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    // Market Data endpoints

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return executeSync(binanceApiService.getOrderBook(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getTrades(String symbol, Integer limit) {
        return executeSync(binanceApiService.getTrades(symbol, limit));
    }

    @Override
    public List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId) {
        return executeSync(binanceApiService.getHistoricalTrades(symbol, limit, fromId));
    }

    @Override
    public List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getAggTrades(symbol, fromId, limit, startTime, endTime));
    }

    @Override
    public List<AggTrade> getAggTrades(String symbol) {
        return getAggTrades(symbol, null, null, null, null);
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getCandlestickBars(symbol, interval.getIntervalId(), limit, startTime, endTime));
    }

    @Override
    public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval) {
        return getCandlestickBars(symbol, interval, null, null, null);
    }

    @Override
    public TickerStatistics get24HrPriceStatistics(String symbol) {
        return executeSync(binanceApiService.get24HrPriceStatistics(symbol));
    }

    @Override
    public List<TickerStatistics> getAll24HrPriceStatistics() {
        return 	executeSync(binanceApiService.getAll24HrPriceStatistics());
    }

    @Override
    public TickerPrice getPrice(String symbol) {
        return executeSync(binanceApiService.getLatestPrice(symbol));
    }

    @Override
    public List<TickerPrice> getAllPrices() {
        return executeSync(binanceApiService.getLatestPrices());
    }

    @Override
    public List<BookTicker> getBookTickers() {
        return executeSync(binanceApiService.getBookTickers());
    }

    @Override
    public NewOrderResponse newOrder(NewOrder order) {
        final Call<NewOrderResponse> call;
        if (order.getQuoteOrderQty() == null) {
            call = binanceApiService.newOrder(order.getSymbol(), order.getSide(), order.getType(),
                    order.getTimeInForce(), order.getQuantity(), order.getPrice(),
                    order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(), order.getNewOrderRespType(),
                    order.getRecvWindow(), order.getTimestamp());
        } else {
            call = binanceApiService.newOrderQuoteQty(order.getSymbol(), order.getSide(), order.getType(),
                    order.getTimeInForce(), order.getQuoteOrderQty(), order.getPrice(),
                    order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(), order.getNewOrderRespType(),
                    order.getRecvWindow(), order.getTimestamp());
        }
        return executeSync(call);
    }

    @Override
    public void newOrderTest(NewOrder order) {
        executeSync(binanceApiService.newOrderTest(order.getSymbol(), order.getSide(), order.getType(),
                order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
                order.getIcebergQty(), order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp()));
    }

    // Account endpoints

    @Override
    public Order getOrderStatus(OrderStatusRequest orderStatusRequest) {
        return executeSync(binanceApiService.getOrderStatus(orderStatusRequest.getSymbol(),
                orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(),
                orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp()));
    }

    @Override
    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) {
        return executeSync(binanceApiService.cancelOrder(cancelOrderRequest.getSymbol(),
                cancelOrderRequest.getOrderId(), cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
                cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getOpenOrders(OrderRequest orderRequest) {
        return executeSync(binanceApiService.getOpenOrders(orderRequest.getSymbol(), orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public List<Order> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return executeSync(binanceApiService.getAllOrders(symbol, orderId, startTime, endTime, limit,
                BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public List<Order> getAllOrders(AllOrdersRequest orderRequest) {
        return executeSync(binanceApiService.getAllOrders(orderRequest.getSymbol(),
                orderRequest.getOrderId(), orderRequest.getLimit(),
                orderRequest.getRecvWindow(), orderRequest.getTimestamp()));
    }

    @Override
    public Account getAccount(Long recvWindow, Long timestamp) {
        return executeSync(binanceApiService.getAccount(recvWindow, timestamp));
    }

    @Override
    public Account getAccount() {
        return getAccount(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
    }

    @Override
    public List<Trade> getMyTrades(String symbol, Integer limit, Long startTime, Long endTime) {
        return executeSync(binanceApiService.getMyTrades(symbol, limit, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis(), startTime, endTime));
    }

    @Override
    public List<Trade> getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp) {
        return executeSync(binanceApiService.getMyTrades(symbol, limit, fromId, recvWindow, timestamp));
    }

    @Override
    public List<Trade> getMyTrades(String symbol, Integer limit) {
        return getMyTrades(symbol, limit, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
    }

    @Override
    public List<Trade> getMyTrades(String symbol) {
        return getMyTrades(symbol, null, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
    }

    @Override
    public DepositAddress getDepositAddress(String network, String coin) {
        return executeSync(binanceApiService.getDepositAddress(coin, network, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public List<Deposit> getDepositHistory(String coin, DepositStatus depositStatus, Date startTime, Date endTime, Integer offset, Integer limit) {
        Integer status = depositStatus == null ? null : depositStatus.getStatus();
        Long sTime = startTime == null ? null : startTime.getTime();
        Long eTime = endTime == null ? null : endTime.getTime();

        return executeSync(binanceApiService.getDepositHistory(coin, status, sTime, eTime, offset, limit, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    // User stream endpoints

    @Override
    public String startUserDataStream() {
        return executeSync(binanceApiService.startUserDataStream()).toString();
    }

    @Override
    public void keepAliveUserDataStream(String listenKey) {
        executeSync(binanceApiService.keepAliveUserDataStream(listenKey));
    }

    // Sub Account endpoints

    @Override
    public void closeUserDataStream(String listenKey) {
        executeSync(binanceApiService.closeAliveUserDataStream(listenKey));
    }

    @Override
    public CreateSubAccountResult createSubAccount(String tag) {
        return executeSync(binanceApiService.createSubAccount(tag, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public SubAccountApiKey createSubAccountApiKey(String subAccountId, boolean canTrade) {
        return executeSync(binanceApiService.createSubAccountApiKey(subAccountId, canTrade, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public List<SubAccountApiKey> getSubAccountApiKey(String subAccountId) {
        return executeSync(binanceApiService.getSubAccountApiKey(subAccountId, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public void deleteSubAccountApiKey(String subAccountId, String apiKey) {
        executeSync(binanceApiService.deleteSubAccountApiKey(subAccountId, apiKey, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public BrokerAccountInfo getBrokerAccountInfo() {
        return executeSync(binanceApiService.getBrokerAccountInfo(BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public SubAccount getSubAccount(String subAccountId) {
        List<SubAccount> subAccounts = executeSync(binanceApiService.querySubAccount(subAccountId, 1, 500, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
        if (subAccounts.size() == 1) {
            return subAccounts.get(0);
        }

        return null;
    }

    @Override
    public List<SubAccount> getSubAccounts(Integer page, Integer size) {
        return executeSync(binanceApiService.querySubAccount(null, page, size, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public List<SubAccountDeposit> getSubAccountDepositHistory(String subAccountId, Date startTime, Date endTime) {
        return executeSync(binanceApiService.getSubAccountDepositHistory(subAccountId, startTime.getTime(), endTime.getTime(), BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public SubAccountTransferResult subAccountTransfer(String fromId, String toId, String clientTranId, String coin, BigDecimal amount) {
        return executeSync(binanceApiService.subAccountTransfer(fromId, toId, clientTranId, coin, amount.toPlainString(), BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public SubAccountTransferRecord getSubAccountTransfer(String clientTransId) {
        List<SubAccountTransferRecord> subAccountTransferRecords = executeSync(binanceApiService.getSubAccountTransferHistory(null, null, clientTransId, true, null, null, null, null, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));

        if (subAccountTransferRecords.size() == 1) {
            return subAccountTransferRecords.get(0);
        }

        return null;
    }

    @Override
    public List<SubAccountTransferRecord> getSubAccountTransferHistory(Date startTime, Date endTime, int page, int size) {
        return executeSync(binanceApiService.getSubAccountTransferHistory(null, null, null, true, startTime.getTime(), endTime.getTime(), page, size, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public WithdrawResult withdraw(String coin, String withdrawOrderId, String network, String address, String addressTag, BigDecimal amount, String name) {
        return executeSync(binanceApiService.withdraw(coin, withdrawOrderId, network, address, addressTag, amount.toPlainString(),
                true, name, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

    @Override
    public List<Withdraw> getWithdrawHistory(String coin, Withdraw.Status status, int offset, int limit, Date startTime, Date endTime) {
        Integer s = status == null ? null : status.getStatus();
        Long sTime = startTime == null ? null : startTime.getTime();
        Long eTime = endTime == null ? null : endTime.getTime();

        return executeSync(binanceApiService.getWithdrawHistory(coin, s, offset , limit, sTime, eTime, BinanceApiConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis()));
    }

}
