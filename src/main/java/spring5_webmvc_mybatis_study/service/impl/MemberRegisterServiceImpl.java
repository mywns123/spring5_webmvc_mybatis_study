package spring5_webmvc_mybatis_study.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;
import spring5_webmvc_mybatis_study.service.MemberRegisterService;

@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public Long regist(RegisterRequest req) {
		Member member = mapper.selectMemberByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getConfirmPassword(), req.getName(), LocalDateTime.now());
		mapper.insertMember(newMember);
		return newMember.getId();
	}

}
