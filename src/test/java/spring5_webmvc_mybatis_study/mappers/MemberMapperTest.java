package spring5_webmvc_mybatis_study.mappers;

import java.util.List;

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
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_webmvc_mybatis_study.config.ContextRoot;
import spring5_webmvc_mybatis_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class MemberMapperTest {

	private static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
			
		List<Member> list = mapper.selectMemberByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
	
	}
	
	@Test
	public void  test02selectMemberByEmail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		String email = "test@test.co.kr";		
		Member member = mapper.selectMemberByEmail(email);
		log.debug(member.toString());		
		Assert.assertNotNull(member);
	}
	
	@Test
	public void  test03countMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		int cnt = mapper.countMember();
		Assert.assertNotEquals(-1, cnt);
		log.debug("cnt >> " + cnt);	
	}
	
	@Test
	public void test04InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		Member member = new Member("test20@test.co.kr","1111","test20");
		int res = mapper.insertMember(member);
		Assert.assertEquals(1, res);		
	}

	@Test
	public void test05UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		Member member = new Member("test20@test.co.kr","111111","테스트20");
		int res = mapper.updateMember(member);
		Assert.assertEquals(1, res);	
	}

	@Test
	public void test06DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		Member member = new Member("test20@test.co.kr","111111","테스트20");
		int res = mapper.deleteMember(member);
		Assert.assertEquals(1, res);	
	}

}
