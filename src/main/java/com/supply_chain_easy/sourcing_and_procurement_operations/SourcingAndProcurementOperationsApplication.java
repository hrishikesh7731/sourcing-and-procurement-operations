package com.supply_chain_easy.sourcing_and_procurement_operations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.supply_chain_easy.sourcing_and_procurement_operations",
		"com.supply_chain_easy.supply_chain_base_operations"
})
@EnableJpaRepositories(
		"com.supply_chain_easy.supply_chain_base_operations.repositories"
)
public class SourcingAndProcurementOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				SourcingAndProcurementOperationsApplication.class,
				args
		);
	}
}
