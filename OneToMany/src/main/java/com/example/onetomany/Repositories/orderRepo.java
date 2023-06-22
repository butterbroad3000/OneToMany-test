package com.example.onetomany.Repositories;

import com.example.onetomany.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo  extends JpaRepository<Order,Integer> {
}
