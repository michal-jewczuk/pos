package net.jewczuk.posdomain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("net.jewczuk.posdomain.repository")
@EntityScan("net.jewczuk.posdomain.entity")
public class PosDomainConfig {
}
