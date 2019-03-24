/**
 * 
 */
package com.forexservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.forexservice.entity.ExchangeValue;
import com.forexservice.repo.ExchangeRepo;

/**
 * @author akhil.babu
 *
 * @author akhilbabu92@gmail.com
 */
@RestController
public class ForexController
{
	@Autowired
	public ExchangeRepo repo;
	
	@Autowired
	public Environment evn;
	
	
	@GetMapping("/test")
	public String currencyConverter()
	{
		return "test";
	}
	
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue currencyConvertion(@PathVariable String from,@PathVariable String to)
	{
	    ExchangeValue value=	repo.findByFromAndTo(from, to);
	    value.setPort(Integer.valueOf(evn.getProperty("local.server.port"))); 
		return value;
	}
	
	
	
	

}
