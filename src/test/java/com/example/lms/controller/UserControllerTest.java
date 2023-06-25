package com.example.lms.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    public MockMvc mvc;

    @Test
    @DisplayName("测试用户列表页面")
    void testUserIndex() throws Exception {
        String currentPage = "2";
        mvc.perform(MockMvcRequestBuilders
                        .get("/users")
                        .param("p", currentPage)
                )
                .andExpect(MockMvcResultMatchers.view().name("users"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("page"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("当前第 " + currentPage + " 页")))
        ;
    }


    @Test
    @DisplayName("测试用户删除")
    void testDeleteUser() throws Exception {
        String userId = "5"; // 由于每页显示 3 条记录，所以 id=5 的用户在第 2 页显示
        String currentPage = "2";
        mvc.perform(MockMvcRequestBuilders
                        .delete("/users/" + userId)
                        .param("p", currentPage)
                )
                .andExpect(MockMvcResultMatchers.view().name("redirect:/users"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/users?p=" + currentPage))
        ;
    }
}
