package com.guliany.movies.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")
public class DBSetting {

	private Map<String, String> connection;
	private String host;
	private int port;

	public DBSetting() {
		super();
	}

	public DBSetting(Map<String, String> connection, String host, int port) {
		super();
		this.connection = connection;
		this.host = host;
		this.port = port;
	}

	public Map<String, String> getConnection() {
		return connection;
	}

	public void setConnection(Map<String, String> connection) {
		this.connection = connection;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "DBSetting [connection=" + connection + ", host=" + host + ", port=" + port + "]";
	}

}
