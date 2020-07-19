package net.jewczuk.posrest;

import net.jewczuk.posdomain.config.PosDomainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(PosDomainConfig.class)
public class PosRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosRestApplication.class, args);
	}

}
