package com.crmapp.crmbackend;

import com.crmapp.crmbackend.repositories.ActivitiesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrmBackendApplicationTests {
	@Autowired
	private ActivitiesRepository activitiesRepository;

	@Test
	void test() {
		Assertions.assertEquals(0 ,activitiesRepository.findAll().size()); ;
	}

}
