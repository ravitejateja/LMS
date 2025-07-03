package com.teja;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
 
import javax.net.ssl.SSLContext;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class myConf {
	// normally when we add crt certificate in JDK serurity cacerts then no need to send the certifcate in request beacuse it just TLS
	//in case of MTLS only we send client certificate to server 
	
	
//cmd to generate certificate  keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks
	/*
	 * @Bean public HttpClient httpClient() throws IOException, KeyStoreException,
	 * NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException,
	 * KeyManagementException {
	 * 
	 * SSLContext sslContext = SSLContextBuilder .create() .loadTrustMaterial(new
	 * ClassPathResource("ssl-server.jks").getFile(), "changeit".toCharArray())
	 * .build(); var restClient=
	 * HttpClient.newBuilder().sslContext(sslContext).build(); //
	 * HttpComponentsClientHttpRequestFactory factory=new
	 * HttpComponentsClientHttpRequestFactory(restClient);
	 * 
	 * return HttpClient.newBuilder().sslContext(sslContext).build();
	 * 
	 * }
	 */
	
	@Bean
	public HttpClient httpClient() {
		return HttpClient.newBuilder().build();
		
	}

}
