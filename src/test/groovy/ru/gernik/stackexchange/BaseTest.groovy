package ru.gernik.stackexchange

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@SpringBootTest(webEnvironment= RANDOM_PORT)
@ContextConfiguration(classes = [StackExchangeApplication])
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
class BaseTest {

    @Autowired
    protected MockMvc mockMvc

    File getFileByName(String fileName) {
        return new File(this.getClass().getClassLoader().getResource(fileName).getFile())
    }

}
