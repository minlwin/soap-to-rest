package com.jdc.demo;

import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.demo.entity.Country;
import com.jdc.demo.model.CountryWithStateName;
import com.jdc.demo.model.CountryWithStateNameDto;
import com.jdc.demo.repo.CountryRepo;

@SpringBootTest
class OneToManyQueryApplicationTests {
	
	@Autowired
	private CountryRepo repo;
	
	@Test
	@Transactional(readOnly = true)
	void loadWithSingleProjection() {
		var result = repo.search(cb -> {
			var cq = cb.createQuery(CountryWithStateNameDto.class);
			var country = cq.from(Country.class);
			cq.multiselect(
				country.get("id"),
				country.get("name"),
				country.get("states").get("name")
			);
			return cq;
		});
		
		System.out.println(result);
	}
	

	@Test
	@Transactional(readOnly = true)
	void loadWithEntity() {
		var result = repo.search(cb -> {
			var cq = cb.createQuery(Country.class);
			var country = cq.from(Country.class);
			cq.select(country);
			return cq;
		});
		
		System.out.println(result.stream().map(a -> CountryWithStateNameDto.from(a)).toList());
	}

	@Test
	@Transactional(readOnly = true)
	void loadTurpleAndGrouping() {
		var result = repo.search(cb -> {
			var cq = cb.createQuery(CountryWithStateName.class);
			var country = cq.from(Country.class);
			cq.multiselect(country.get("id"), country.get("name"), country.get("states").get("name"));
			return cq;
		});
		
		var map = result.stream().collect(
				Collectors.groupingBy(a -> a.country(), 
				Collectors.mapping(t -> t.state(), Collectors.toList())));
		
		System.out.println(map.entrySet().stream().map(a -> CountryWithStateNameDto.from(a.getKey(), a.getValue())));
	}
}
