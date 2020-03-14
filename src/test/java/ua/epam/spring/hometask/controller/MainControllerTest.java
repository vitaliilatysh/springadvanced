package ua.epam.spring.hometask.controller;

import config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringRunner.class)
public class MainControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void createEmployeeAPI() throws Exception {
        MockMultipartFile jsonFile = new MockMultipartFile("users.json", "", "application/json", "{\"firstName\": \"Donald\", \"lastName\": \"Donawan\"}".getBytes());

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(MockMvcRequestBuilders.multipart("/files")
                .file(jsonFile)
                .param("some-random", "4"))
                .andExpect(status().is(200))
                .andExpect(content().string("success"));
    }
}
