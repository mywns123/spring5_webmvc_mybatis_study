package spring5_webmvc_mybatis_study.mapper;

import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_webmvc_mybatis_study.config.ControllerConfig;
import spring5_webmvc_mybatis_study.controller.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {

	private static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		Map<String, Object> map = new HashMap<String, Object>();
		List<Member> list = mapper.selectMemberByAll(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
	
	}

//	@Test
	public void testInsertMember() {
		fail("Not yet implemented");
	}

//	@Test
	public void testUpdateMember() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDeleteMember() {
		fail("Not yet implemented");
	}

}
