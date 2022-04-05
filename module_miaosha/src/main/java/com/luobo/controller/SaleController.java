package com.luobo.controller;

import com.luobo.model.SaleResult;
import com.luobo.model.StockPO;
import com.luobo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/sale.json/{uid}/{sid}")
    public void sale(@PathVariable int uid, @PathVariable int sid){
        SaleResult saleResult = saleService.trySale(uid, sid);
        System.out.println(saleResult);
    }

    @GetMapping("/insert.json")
    public void testInsert(){
        StockPO stockPO=new StockPO();
        stockPO.setId(10);
        stockPO.setSale(0);
        stockPO.setCount(100);
        stockPO.setName("phone");
        stockPO.setVersion(0);
        saleService.updateStockPO(stockPO);
        System.out.println("try insert new stock");
    }

    @GetMapping("init.json")
    public void init(){
        saleService.initStock(1);
        System.out.println("init stock");
    }

    @GetMapping("check.json")
    public void check(){
        String stock = saleService.checkStock(1);
        System.out.println("check:"+stock);
    }

    @GetMapping("decr.json")
    public void decr(){
        System.out.println(saleService.decr());
    }
}
