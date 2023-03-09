package iesrafaelalberti.apitarea;

import com.fasterxml.jackson.databind.ObjectMapper;
import iesrafaelalberti.apitarea.Models.Board;
import iesrafaelalberti.apitarea.Models.Userlo;
import iesrafaelalberti.apitarea.Repositories.BoardRepository;
import iesrafaelalberti.apitarea.Repositories.TaskRepository;
import iesrafaelalberti.apitarea.Repositories.UserloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiTareaApplicationTests {
    @Autowired
    MockMvc mvc;
    @Autowired
    UserloRepository userloRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    TaskRepository taskRepository;
    @Test
    void contextLoads() {
        assert userloRepository.count() == 2;
        assert boardRepository.count() == 2;
    }


    @Test
    void listTest() throws Exception {
        mvc.perform(get("/userslo")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].userName").value("daniela"));
    }

    @Test
    void showTest() throws Exception {
        mvc.perform(get("/userslo/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.userName").value("daniela"));
    }
    @Test
    public void createTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.post("/userslo/create")
            .content(asJsonString(new Userlo("lola", "pestillo")))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(3));
        assert userloRepository.count() == 3;
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void updateTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.put("/userslo/{id}", 2)
            .content(asJsonString(new Userlo( "Teresita", "aitortilla")))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.userName").value("Teresita"))
            .andExpect(jsonPath("$.password").value("aitortilla"))
            .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders.delete("/userslo/{id}", 1) )
            .andExpect(status().isOk());
        assert userloRepository.count() == 1;
    }



}


