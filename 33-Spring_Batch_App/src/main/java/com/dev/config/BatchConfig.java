package com.dev.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.dev.entity.Family;
import com.dev.repo.FamilyRepo;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	public FamilyRepo repo;

	/*
	 * step builder factory is not available 
	 * @Autowired
	 * private StepBuilderFactor  builderFactory
	 */
	
	/*
	 * job builder factory is not available 
	 * @Autowired
	 * private JobBuilderFactory  jobBuilderFactory
	 */
	
	
	//item reader bean
	@Bean
	public FlatFileItemReader<Family> familyReader(){
		
		FlatFileItemReader<Family> itemReader= new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resource/familyMember.csv"));
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMaper());
		
		return itemReader;
	}
	
	
	public LineMapper<Family> lineMaper(){
		DefaultLineMapper<Family> lineMaper= new DefaultLineMapper<>();
		
		DelimitedLineTokenizer tokenizer= new  DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames("id","firstName","lastName", "email", "gender","contactNo", "country","dob");
		
		BeanWrapperFieldSetMapper<Family> setMapper=new BeanWrapperFieldSetMapper<>();
		setMapper.setTargetType(Family.class);
		
		lineMaper.setFieldSetMapper(setMapper);
		lineMaper.setLineTokenizer(tokenizer);
		
		return lineMaper;
	}
	
	//item processor bean
	@Bean
	public FamilyProcessor familyProcessor() {
		return new FamilyProcessor();
	}
	
	//item writer bean
	@Bean
	public RepositoryItemWriter<Family> familyWriter(){
		RepositoryItemWriter<Family> itemWriter= new RepositoryItemWriter<>();
		itemWriter.setRepository(repo);
		itemWriter.setMethodName("save");
		return itemWriter;
	}
	
	//step bean 
	@Bean
	public Step step() {
		return null;
	}
	
	
	//job bean
	@Bean 
	public Job job() {
		return null;
	}

}
