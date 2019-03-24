package com.ag.api;

import com.ag.api.controller.TaskController;
import com.ag.api.dto.BalanceTestResult;
import com.ag.api.service.TaskServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static junit.framework.TestCase.fail;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class TaskServiceTest
{
    @TestConfiguration
    static class TaskServiceImplTestContextConfiguration
    {
        @Bean
        public TaskServiceImpl taskService()
        {
            return new TaskServiceImpl();
        }
    }

    @Autowired
    private TaskServiceImpl taskService;

    @Test
    public void testValidateBrackets()
    {
        Assert.assertTrue(taskService.validateBrackets("").isBalanced());
        Assert.assertTrue(taskService.validateBrackets("{{}}").isBalanced());
        Assert.assertFalse(taskService.validateBrackets("{[}").isBalanced());
    }

//    @Test
//    public void testValidateBrackets()
//    {
//        BalanceTestResult balanceTestResult = new BalanceTestResult();
//        balanceTestResult.setInput("test");
//
//        given(taskService.validateBrackets(any())).willReturn(balanceTestResult);
//
//        try
//        {
//            mvc.perform(get("/api/tasks/validateBrackets")
//                    .contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//            .andExpect((ResultMatcher) jsonPath("$[0].input", is("test")));
//        } catch (Exception e)
//        {
//            fail(e.getMessage());
//        }

//        System.out.println("test");
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>("test", headers);
//        ResponseEntity<String> response = restTemplate.exchange(this.url + "/tasks/validateBrackets", HttpMethod.GET, entity, String.class);
//        Assert.assertNotNull(response.getBody());
//    }

//    @Test
//    public void testGetUserById()
//    {
//        User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
//        System.out.println(user.getFirstName());
//        Assert.assertNotNull(user);
//    }
//
//    @Test
//    public void testCreateUser()
//    {
//        User user = new User();
//        user.setEmail("admin@gmail.com");
//        user.setFirstName("admin");
//        user.setLastName("admin");
//        ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
//        Assert.assertNotNull(postResponse);
//        Assert.assertNotNull(postResponse.getBody());
//    }
//
//    @Test
//    public void testUpdatePost()
//    {
//        int id = 1;
//        User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
//        user.setFirstName("admin1");
//        user.setLastName("admin2");
//        restTemplate.put(getRootUrl() + "/users/" + id, user);
//        User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
//        Assert.assertNotNull(updatedUser);
//    }
//
//    @Test
//    public void testDeletePost()
//    {
//        int id = 2;
//        User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
//        Assert.assertNotNull(user);
//        restTemplate.delete(getRootUrl() + "/users/" + id);
//        try
//        {
//            user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
//        } catch (final HttpClientErrorException e)
//        {
//            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
}
