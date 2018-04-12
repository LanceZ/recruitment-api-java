package com.gmail.magiccircuit.recruitment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Configuration
@ConditionalOnClass(WxMaService.class)
@EnableConfigurationProperties(WxMaProperties.class)
public class WxMaConfiguration {

	@Autowired
	private WxMaProperties properties;

	@Bean
	@ConditionalOnMissingBean
	public WxMaConfig maConfig() {
		WxMaInMemoryConfig config = new WxMaInMemoryConfig();
		config.setAppid(this.properties.getAppid());
		config.setSecret(this.properties.getSecret());
		config.setToken(this.properties.getToken());
		config.setAesKey(this.properties.getAesKey());
		config.setMsgDataFormat(this.properties.getMsgDataFormat());

		return config;
	}

	@Bean
	@ConditionalOnMissingBean
	public WxMaService wxMaService(WxMaConfig maConfig) {
		WxMaService service = new WxMaServiceImpl();
		service.setWxMaConfig(maConfig);
		return service;
	}

}
