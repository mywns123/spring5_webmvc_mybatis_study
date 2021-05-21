package spring5_webmvc_mybatis_study.mapper;

import java.util.List;
import java.util.Map;


import spring5_webmvc_mybatis_study.controller.Member;

public interface MemberMapper {

	List<Member> selectMemberByAll(Map<String, Object> map);
	
	int insertMember(Map<String, Object> map);
	
	int updateMember(Map<String, Object> map);
	
	int deleteMember(Map<String, Object> map);
	
}
