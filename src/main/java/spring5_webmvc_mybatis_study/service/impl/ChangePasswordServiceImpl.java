package spring5_webmvc_mybatis_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.exception.MemberNotFoundException;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;
import spring5_webmvc_mybatis_study.service.ChangePasswordService;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Autowired
	private MemberMapper mapperapper;

	@Override
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = mapperapper.selectMemberByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		mapperapper.updateMember(member);

	}

}
