package com.springbootintegrations3.spring_boot_s3_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Config {
	@Value("${chimp.aws.access_key_id}")
	private String awsId;
 
	@Value("${chimp.aws.secret_access_key}")
	private String awsKey;
	
	@Value("${chimp.s3.region}")
	private String region;
 
	@Bean
	public AmazonS3 getS3client() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
								.withRegion(Regions.fromName(region))
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .build();
		
		return s3Client;
	}
}