package com.springbootintegrations3.spring_boot_s3_demo.services;

public interface S3Services {

	public void downloadFile(String keyName);

	public void uploadFile(String keyName, String uploadFilePath);

}
