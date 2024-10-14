package com.javabing.bilibili.service.config;/*
 * ClassName: ElasticSearchConfig
 * Package: com.javabing.bilibili.service.config
 * Description:
 * @Author WangBing
 * @Create 2024/10/14/星期一 12:06
 * @Version 1.0
 **/

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.url}")
    private String esUrl;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient(){
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(esUrl)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }


}
