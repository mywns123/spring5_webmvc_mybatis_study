package spring5_webmvc_mybatis_study.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;
import spring5_webmvc_mybatis_study.service.RestMemberService;

@Service
public class RestMemberServiceImpl implements RestMemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Member showMemberbyId(long memId) {
		return memberMapper.selectbyId(memId);
	}

	@Override
	public List<Member> showMembers() {
		return memberMapper.selectMemberByAll();
	}

	@Override
	public Long regist(RegisterRequest req) {
		Member member = memberMapper.selectMemberByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getConfirmPassword(), req.getName(), LocalDateTime.now());
		memberMapper.insertMember(newMember);
		return newMember.getId();
	}

}
