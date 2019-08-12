package com.teahel.powsers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages="com.teahel")
public class PowsersApplication {
	public static void main(String[] args) {
		SpringApplication.run(PowsersApplication.class, args);
	}

}
