package spring5_webmvc_mybatis_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_webmvc_mybatis_study.dto.AuthInfo;
import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.exception.WrongIdPasswordException;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;

@Service
public class AuthService {
	
	@Autowired
	private MemberMapper memberDao;

	public AuthInfo authenicate(String email, String password) {
		Member member = memberDao.selectMemberByEmail(email);
		if (member == null) {
			throw new WrongIdPasswordException();
		}

		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}

		return new AuthInfo(member.getId(), member.getEmail(), member.getName());

	}
}
