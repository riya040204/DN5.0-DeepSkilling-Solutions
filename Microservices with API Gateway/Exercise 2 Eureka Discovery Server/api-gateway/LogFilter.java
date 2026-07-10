package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global Filter - logs ALL incoming requests
 * Runs before every request through the API Gateway
 */
@Component
public class LogFilter implements GlobalFilter {

    private static final Logger LOGGER =
        LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        LOGGER.info("API Gateway Request: {} {}",
            exchange.getRequest().getMethod(),
            exchange.getRequest().getURI());

        return chain.filter(exchange);
    }
}
