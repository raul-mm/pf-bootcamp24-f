package com.bootcamp.ms.client;

import com.bootcamp.ms.commons.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MicroserviceClientApplicationTests {

	private final Client client = Client.builder()
			.id("1234567")
			.firstName("Jair")
			.lastName("Rivero")
			.age("23")
			.documentNumber("70976181")
			.type("Personal")
			.build();

	@Test
	void create() {
		assertNotNull(client);
	}

	@Test
	void findById() {
		assertAll(
				() -> assertNotNull(client.getId()),
				() -> assertEquals("1234567", client.getId())
		);
	}

	@Test
	void findByDocumentNumber() {
		assertAll(
				() -> assertNotNull(client.getDocumentNumber()),
				() -> assertEquals("70976181", client.getDocumentNumber())
		);
	}

	@Test
	void findByType() {
		assertAll(
				() -> assertNotNull(client.getType()),
				() -> assertEquals("Personal", client.getType())
		);
	}

	@Test
	void testNotNull() {
		assertAll(
				() -> assertNotNull(client.getFirstName()),
				() -> assertNotNull(client.getLastName()),
				() -> assertNotNull(client.getAge())
		);
	}
}
