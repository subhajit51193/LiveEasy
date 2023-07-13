package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.PayLoad;

public interface PayLoadRepository extends JpaRepository<PayLoad, Integer>{

	public List<PayLoad> findByShipperId(String shipperId);
}
