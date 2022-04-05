package com.luobo.mq;

import com.luobo.dao.IOrderDao;
import com.luobo.dao.IStockDao;
import com.luobo.model.OrderPO;
import com.luobo.model.StockPO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {
    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IStockDao stockDao;

    @RabbitHandler
    public void process(String content) {
        System.out.println("接收处理队列A当中的消息： " + content);
        String[] strs = content.split("_");
        String uid=strs[0];
        String sid=strs[1];
        String date=strs[2];
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp ts = Timestamp.valueOf(date);
        Optional<StockPO> optional = stockDao.findById(Long.parseLong(sid));
        if(!optional.isPresent()){
            System.out.println("商品不存在！创建订单失败");
        }
        StockPO stockPO= optional.get();
        OrderPO orderPO=new OrderPO();
        orderPO.setName(stockPO.getName());
        orderPO.setSid(Integer.parseInt(sid));
        orderPO.setUid(Integer.parseInt(uid));
        orderPO.setCreateTime(ts);
        orderDao.save(orderPO);
        stockPO.setSale(stockPO.getSale()+1);
        stockDao.save(stockPO);
        System.out.println("订单处理完成！");
        System.out.println(orderPO);
    }

}