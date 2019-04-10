package ru.gernik.stackexchange

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.containers.GenericContainer

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = [StackExchangeApplication], initializers = Initializer.class)
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
class BaseTest {

    @Autowired
    protected MockMvc mockMvc

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        void initialize(ConfigurableApplicationContext applicationContext) {
            def redis = new GenericContainer<>("redis:5.0.4")
                    .withExposedPorts(6379)
            redis.start()
            TestPropertyValues values = TestPropertyValues.of(
                    "spring.redis.port=" + redis.getMappedPort(6379),
                    "spring.redis.host=" + "localhost"
            )
            values.applyTo(applicationContext)

        }
    }

    File getFileByName(String fileName) {
        return new File(this.getClass().getClassLoader().getResource(fileName).getFile())
    }

}
