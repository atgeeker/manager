package systemman;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.busi.log.SystemLogService;

public class LoginControllerTest extends TestWebBase {
	// @Test
	public void tests() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("", "");

		String url = "/loginPage";
		String result = mockMvc
				.perform(MockMvcRequestBuilders.post(url).params(params))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
				.getResponse().getContentAsString();
		System.out.println(result);
	}

	@Autowired
	private SystemLogService systemLogService;
	
	@Test
	public void systemLogTest() throws Exception{
		String message = "测试";
		systemLogService.saveLog(message);
	}
}
