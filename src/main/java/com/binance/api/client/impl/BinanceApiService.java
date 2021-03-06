package com.binance.api.client.impl;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.SwapRemoveType;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.Coin;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.*;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
public interface BinanceApiService {

    // General endpoints

    @GET("/api/v1/ping")
    Call<Void> ping();

    @GET("/api/v1/time")
    Call<ServerTime> getServerTime();

    @GET("/api/v1/exchangeInfo")
    Call<ExchangeInfo> getExchangeInfo();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/config/getall")
    Call<List<Coin>> getAllCoins(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    // Market data endpoints

    @GET("/api/v1/depth")
    Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @GET("/api/v1/trades")
    Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/api/v1/historicalTrades")
    Call<List<TradeHistoryItem>> getHistoricalTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId);

    @GET("/api/v1/aggTrades")
    Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId, @Query("limit") Integer limit,
                                      @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/api/v1/klines")
    Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                               @Query("startTime") Long startTime, @Query("endTime") Long endTime);

    @GET("/api/v1/ticker/24hr")
    Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

    @GET("/api/v1/ticker/24hr")
    Call<List<TickerStatistics>> getAll24HrPriceStatistics();

    @GET("/api/v1/ticker/allPrices")
    Call<List<TickerPrice>> getLatestPrices();

    @GET("/api/v3/ticker/price")
    Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

    @GET("/api/v1/ticker/allBookTickers")
    Call<List<BookTicker>> getBookTickers();

    // Account endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                    @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                                    @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                    @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                    @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order")
    Call<NewOrderResponse> newOrderQuoteQty(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                            @Query("timeInForce") TimeInForce timeInForce, @Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
                                            @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                            @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/api/v3/order/test")
    Call<Void> newOrderTest(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                            @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
                            @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                            @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                            @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/order")
    Call<Order> getOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                               @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                               @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/api/v3/order")
    Call<CancelOrderResponse> cancelOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                          @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/openOrders")
    Call<List<Order>> getOpenOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrders")
    Call<List<Order>> getAllOrders(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                   @Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/allOrders")
    Call<List<Order>> getAllOrders(@Query("symbol") String symbol, @Query("orderId") Long orderId, @Query("startTime") Long startTime,
                                   @Query("endTime") Long endTime, @Query("limit") Integer limit, @Query("recvWindow") Long recvWindow,
                                   @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/account")
    Call<Account> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/api/v3/myTrades")
    Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp, @Query("startTime") Long startTime,
                                  @Query("endTime") Long endTime);

    // User stream endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/api/v3/userDataStream")
    Call<ListenKey> startUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/api/v3/userDataStream")
    Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @DELETE("/api/v3/userDataStream")
    Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey);

    // Margin Account endpoints
    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/transfer")
    Call<MarginTransaction> transfer(@Query("asset") String asset, @Query("amount") String amount, @Query("type") String type, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/loan")
    Call<MarginTransaction> borrow(@Query("asset") String asset, @Query("amount") String amount, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/loan")
    Call<LoanQueryResult> queryLoan(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/repay")
    Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/maxBorrowable")
    Call<MaxBorrowableQueryResult> queryMaxBorrowable(@Query("asset") String asset, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/repay")
    Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("startTime") Long starttime, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/margin/repay")
    Call<MarginTransaction> repay(@Query("asset") String asset, @Query("amount") String amount, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/account")
    Call<MarginAccount> getMarginAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/margin/openOrders")
    Call<List<Order>> getOpenMarginOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/margin/order")
    Call<MarginNewOrderResponse> newMarginOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                                @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity,
                                                @Query("price") String price, @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                                @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                                @Query("sideEffectType") SideEffectType sideEffectType, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/margin/order")
    Call<CancelOrderResponse> cancelMarginOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                                @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                                @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/order")
    Call<Order> getMarginOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                     @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                                     @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/margin/myTrades")
    Call<List<Trade>> getMyMarginTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                        @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @POST("/sapi/v1/userDataStream")
    Call<ListenKey> startMarginUserDataStream();

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @PUT("/sapi/v1/userDataStream")
    Call<Void> keepAliveMarginUserDataStream(@Query("listenKey") String listenKey);

    // Binance Liquidity Swap Pool endpoints

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
    @GET("/sapi/v1/bswap/pools")
    Call<List<Pool>> listAllSwapPools();

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidity")
    Call<List<Liquidity>> getPoolLiquidityInfo(@Query("poolId") String poolId,
                                               @Query("recvWindow") Long recvWindow,
                                               @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityAdd")
    Call<LiquidityOperationRecord> addLiquidity(@Query("poolId") String poolId,
                                                @Query("asset") String asset,
                                                @Query("quantity") String quantity,
                                                @Query("recvWindow") Long recvWindow,
                                                @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/liquidityRemove")
    Call<LiquidityOperationRecord> removeLiquidity(@Query("poolId") String poolId,
                                                   @Query("type") SwapRemoveType type,
                                                   @Query("asset") List<String> asset,
                                                   @Query("shareAmount") String shareAmount,
                                                   @Query("recvWindow") Long recvWindow,
                                                   @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidityOps")
    Call<List<LiquidityOperationRecord>> getPoolLiquidityOperationRecords(
            @Query("poolId") String poolId,
            @Query("limit") Integer limit,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/liquidityOps")
    Call<List<LiquidityOperationRecord>> getLiquidityOperationRecord(
            @Query("operationId") String operationId,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/quote")
    Call<SwapQuote> requestQuote(
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("quoteQty") String quoteQty,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @POST("/sapi/v1/bswap/swap")
    Call<SwapRecord> swap(
            @Query("quoteAsset") String quoteAsset,
            @Query("baseAsset") String baseAsset,
            @Query("quoteQty") String quoteQty,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers({BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER, BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER})
    @GET("/sapi/v1/bswap/swap")
    Call<List<SwapHistory>> getSwapHistory(
            @Query("swapId") String swapId,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/broker/subAccount")
    Call<CreateSubAccountResult> createSubAccount(
            @Query("tag") String tag,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/broker/subAccountApi")
    Call<SubAccountApiKey> createSubAccountApiKey(
            @Query("subAccountId") String subAccountId,
            @Query("canTrade") boolean canTrade,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/broker/subAccountApi")
    Call <List<SubAccountApiKey>> getSubAccountApiKey(
            @Query("subAccountId") String subAccountId,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @DELETE("/sapi/v1/broker/subAccountApi")
    Call<Void> deleteSubAccountApiKey(
            @Query("subAccountId") String subAccountId,
            @Query("subAccountApiKey") String subAccountApiKey,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/broker/info")
    Call<BrokerAccountInfo> getBrokerAccountInfo(
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/broker/subAccount")
    Call<List<SubAccount>> querySubAccount(
            @Query("subAccountId") String subAccountId,
            @Query("page") Integer page,
            @Query("size") Integer size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/broker/subAccount")
    Call<List<SubAccount>> querySubAccounts(
            @Query("page") Long page,
            @Query("size") Long size,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/broker/subAccount/depositHist")
    Call<List<SubAccountDeposit>> getSubAccountDepositHistory(
            @Query("subAccountId") String subAccountId,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/broker/transfer")
    Call<SubAccountTransferResult> subAccountTransfer(
            @Query("fromId") String fromId,
            @Query("toId") String toId,
            @Query("clientTranId") String clientTranId,
            @Query("asset") String asset,
            @Query("amount") String amount,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/broker/transfer")
    Call<List<SubAccountTransferRecord>> getSubAccountTransferHistory(
            @Query("fromId") String fromId,
            @Query("toId") String toId,
            @Query("clientTranId") String clientTranId,
            @Query("showAllStatus") boolean showAllStatus,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("page") Integer page,
            @Query("limit") Integer limit,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @POST("/sapi/v1/capital/withdraw/apply")
    Call<WithdrawResult> withdraw(
            @Query("coin") String coin,
            @Query("withdrawOrderId") String withdrawOrderId,
            @Query("network") String network,
            @Query("address") String address,
            @Query("addressTag") String addressTag,
            @Query("amount") String amount,
            @Query("transactionFeeFlag") boolean transactionFeeFlag,
            @Query("name") String name,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/withdraw/history")
    Call<List<Withdraw>> getWithdrawHistory(
            @Query("coin") String coin,
            @Query("status") Integer status,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/deposit/address")
    Call<DepositAddress> getDepositAddress(
            @Query("coin") String coin,
            @Query("network") String network,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);

    @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
    @GET("/sapi/v1/capital/deposit/hisrec")
    Call<List<Deposit>> getDepositHistory(
            @Query("coin") String coin,
            @Query("status") Integer status,
            @Query("startTime") Long startTime,
            @Query("endTime") Long endTime,
            @Query("offset") Integer offset,
            @Query("limit") Integer limit,
            @Query("recvWindow") Long recvWindow,
            @Query("timestamp") Long timestamp);
}
