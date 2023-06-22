package com.example.onetomany.Repositories;

import com.example.onetomany.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepo  extends JpaRepository<Client,Integer> {
}
