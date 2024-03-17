package com.musinsa.util.globals;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class GlobalProperties {

    // 인스턴스 필드로 변경
    @Value("${jwt.security.encoding.value}")
    private String jwtSecurityValue;

    // 정적 컨텍스트에서 접근하기 위한 정적 필드
    private static String JWT_SECURITY_VALUE;

    // @PostConstruct를 사용하여 모든 의존성 주입이 완료된 후에 정적 필드를 초기화
    @PostConstruct
    private void init() {
        JWT_SECURITY_VALUE = jwtSecurityValue;
    }

    // 정적 메서드를 통해 값에 접근
    public static String getJwtSecurityValue() {
        return JWT_SECURITY_VALUE;
    }


}
