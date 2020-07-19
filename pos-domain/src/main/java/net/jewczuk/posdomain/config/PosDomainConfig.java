package net.jewczuk.posdomain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "net.jewczuk.posdomain.repository")
@EntityScan("net.jewczuk.posdomain.entity")
public class PosDomainConfig {
}
