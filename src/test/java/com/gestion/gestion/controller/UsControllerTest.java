package com.gestion.gestion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestion.gestion.entity.Us;
import com.gestion.gestion.repository.UsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsRepository usRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void getUs() throws Exception{
        final ArrayList< Us > expectedUs = new ArrayList<>();
        final Us us = new Us();

        us.setLabel("test");
        us.setPoints(1);
        us.setValue(2);
        expectedUs.add(us);
        when(usRepository.findAll(any(Pageable.class)))
                .thenReturn(new PageImpl(expectedUs));

        final MvcResult mvcResult = mockMvc.perform(get("/api/us"))
                .andExpect(status().isOk())
                .andReturn();

        final String json = mvcResult.getResponse().getContentAsString();


        assertThat(json).contains("test");
    }
}