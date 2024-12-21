package com.dev.config;

import org.springframework.batch.item.ItemProcessor;

import com.dev.entity.Family;

public class FamilyProcessor implements ItemProcessor<Family, Family >{

	@Override
	public Family process(Family item) throws Exception {
		
		//logic to process data
		
		return item;
	}

}
