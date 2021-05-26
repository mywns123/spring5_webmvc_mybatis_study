package spring5_webmvc_mybatis_study.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import spring5_webmvc_mybatis_study.dto.ListCommand;
import spring5_webmvc_mybatis_study.dto.Member;

@Component
public interface MemberMapper {

	List<Member> selectMemberByAll();
	
	Member selectMemberByEmail(String email);
	
	public Member selectbyId(long memId);
	
	int countMember();
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int deleteMember(Member member);
	
	List<Member> selectByRegdate(ListCommand listCommand);
}
