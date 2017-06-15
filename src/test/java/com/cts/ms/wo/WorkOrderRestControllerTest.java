package com.cts.ms.wo;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.cts.ms.wo.ServiceEndPoint.GET_SERVICES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WorkEngineApp.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkOrderRestControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void thatGotSuccessResponseWhenCallGetServiceOrderList() throws Exception {
        RequestBuilder mockRequest = MockMvcRequestBuilders.get(GET_SERVICES);
        ResultMatcher expectedResult = status().isOk();
        mockMvc.perform(mockRequest)
                .andExpect(expectedResult);
    }


    @Test
    public void thatGotServiceListWhenRequestServiceList() throws Exception {

        RequestBuilder getServiceRequest = MockMvcRequestBuilders.get(GET_SERVICES)
                .accept(MediaType.APPLICATION_JSON);
        ResultMatcher expectedResult = jsonPath("$.name").exists();
        mockMvc.perform(getServiceRequest).andExpect(expectedResult);


    }


}
