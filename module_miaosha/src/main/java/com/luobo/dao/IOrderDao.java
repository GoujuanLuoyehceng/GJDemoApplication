package com.luobo.dao;

import com.luobo.model.OrderPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IOrderDao extends JpaRepository<OrderPO,Long> {
}
