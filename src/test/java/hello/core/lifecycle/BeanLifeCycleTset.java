package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTset {
    @Test
    public void lifeCycleTest() {
        // 1. 스프링 컨테이너 생성
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        // 2. 스프링 빈 생성
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            // 3. 의존 관계 주입
            networkClient.setUrl("http://heelo-spring.dev");
            return networkClient;
        }
    }
}
