package com.luobo.dao;

import com.luobo.model.StockPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IStockDao extends JpaRepository<StockPO,Long> {
}
