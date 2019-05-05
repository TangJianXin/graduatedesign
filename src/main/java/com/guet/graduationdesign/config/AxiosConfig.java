package com.guet.graduationdesign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
* @Description:    跨域请求配置类
* @Author:         TJX
* @CreateDate:     2019-05-03 17:11
* @UpdateUser:
* @UpdateDate:     2019-05-03 17:11
* @UpdateRemark:
* @Version:        1.0
*/
@Configuration
public class AxiosConfig {

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        /**
        * @Description: 跨域请求配置方法
        * @Author:      TJX
         * @param
        * @Return      org.springframework.web.filter.CorsFilter
        * @Exception
        * @Date        2019-05-03 17:12
        */
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
