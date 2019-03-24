package com.forexservice.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forexservice.entity.ExchangeValue;

@Repository
public interface ExchangeRepo extends JpaRepository<ExchangeValue, Long>
{
	ExchangeValue findByFromAndTo(String from, String to);

}
