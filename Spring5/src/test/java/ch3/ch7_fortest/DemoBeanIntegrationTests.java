package ch3.ch7_fortest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit4ClassRunner 在JUnit环境下提供 Spring TestContext Framework功能
@ContextConfiguration(classes = {TestConfig.class}) // 用来加载配置 ApplicationContext，其中 class 属性用来加载配置类
@ActiveProfiles("prod") // 用来声明活动的 profile
public class DemoBeanIntegrationTests {

    @Autowired // 使用普通的注入
    private TestBean testBean;

    @Test // 测试结果是否一致
    public void prodBeanShouldInject(){
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected, actual);
    }
}
