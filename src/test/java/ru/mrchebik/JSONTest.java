package ru.mrchebik;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mrchebik on 24.12.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:**/servlet-context.xml")
@WebAppConfiguration("webapp/WEB-INF/spring/appServlet")
public class JSONTest {
    @Test
    public void testConvertStringFromJSONToRequiredData() throws Exception {
        JSONObject jsonObject = new JSONObject("{ title: testTitle, text: testText }");
        assertEquals(jsonObject.getString("title"), "testTitle");
        assertEquals(jsonObject.getString("text"), "testText");
    }
}