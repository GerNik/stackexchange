package ru.gernik.stackexchange.controller

import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import ru.gernik.stackexchange.BaseTest

import static com.github.tomakehurst.wiremock.client.WireMock.*
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static wiremock.org.eclipse.jetty.http.HttpHeader.CONTENT_TYPE

class StackExchangeControllerTest extends BaseTest{

    @Test
    void "should return search response" () {
        given:
        stubFor(get(urlPathMatching('/search'))
                .withQueryParam('key', equalTo('testkeyQwE1#)-'))
                .withQueryParam('order', equalTo('desc'))
                .withQueryParam('sort', equalTo('activity'))
                .withQueryParam('site', equalTo('stackoverflow'))
                .withQueryParam('intitle', equalTo('java'))
                .willReturn(
                        aResponse().withStatus(200)
                                .withHeader(CONTENT_TYPE.asString(), APPLICATION_JSON_VALUE)
                                .withBody(getFileByName("StackoverflowSearchResponse.json").getText())))
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/search")
                .param("query", "java"))

        then:
        response.andExpect(status().is(HttpStatus.OK.value()))
    }
}
