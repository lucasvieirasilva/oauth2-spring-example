package com.example.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter())
				.authenticationManager(authenticationManager);
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("authserver.jks"),
				"authserverpass".toCharArray());
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair("authserver"));
		return converter;
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
				.withClient("implicit-client")
				.authorizedGrantTypes("implicit")
				.scopes("read")
			.and()
				.withClient("read-client")
				.secret("secret")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
				.scopes("read")
			.and()
				.withClient("write-client").secret("secret")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
				.scopes("read", "write");
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients();
	}	
}
