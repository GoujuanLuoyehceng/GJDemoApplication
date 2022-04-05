package com.luobo.service;

import com.luobo.dao.IOrderDao;
import com.luobo.dao.IStockDao;
import com.luobo.model.OrderPO;
import com.luobo.model.SaleResult;
import com.luobo.model.StockPO;
import com.luobo.mq.MsgProducer;
import com.luobo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Component
public class SaleService {

    private static String lock_key="lock_1";

    private static String stock_key="stock_1";

    @Autowired
    private MsgProducer msgProducer;

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IStockDao stockDao;

    @Autowired
    private RedisUtil redisUtil;

    public SaleResult trySale(long uid, long sid){
        Long ret = redisUtil.setnx(lock_key, "1");
        SaleResult saleResult=new SaleResult();
        if(ret == 0){
            saleResult.setCode(500);
            saleResult.setMessage("抢购失败");
            saleResult.setSuccess(false);
        }else{
            Long res = redisUtil.decr(stock_key);
            if(res<0){
                saleResult.setSuccess(false);
                saleResult.setCode(300);
                saleResult.setMessage("商品已售空！");
            }else{
                sendMessage(uid, sid);
                saleResult.setSuccess(true);
                saleResult.setCode(400);
                saleResult.setMessage("抢购成功");
            }
            redisUtil.del(lock_key);
        }
        return saleResult;
    }

    private void sendMessage(long uid, long sid){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
        Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
        String content=uid+"_"+sid+"_"+df.format(now);
        msgProducer.sendMsg(content);
    }

    public void initStock(long sid){
        redisUtil.setex(stock_key,"100",6000);
    }

    public String checkStock(long sid){
        return redisUtil.get(stock_key, 1);
    }

    public Long decr(){
        return redisUtil.decr(stock_key);
    }

    public OrderPO insertOrderPO(OrderPO orderPO){
        return orderDao.save(orderPO);
    }

    public OrderPO updateOrderPO(OrderPO orderPO){
        return orderDao.save(orderPO);
    }

    public void deleteOrderPO(OrderPO orderPO){
        orderDao.delete(orderPO);
    }

    public StockPO insertStockPO(StockPO stockPO){
        return stockDao.save(stockPO);
    }

    public StockPO updateStockPO(StockPO stockPO){
        return stockDao.save(stockPO);
    }

    public void deleteStockPO(StockPO stockPO){
        stockDao.delete(stockPO);
    }

    public void tryCommend(){
        System.out.println("test");
    }
}
