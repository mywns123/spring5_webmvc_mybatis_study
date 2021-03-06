package spring5_webmvc_mybatis_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.dto.RegisterRequest;
import spring5_webmvc_mybatis_study.exception.DuplicateMemberException;
import spring5_webmvc_mybatis_study.service.RestMemberService;
import spring5_webmvc_mybatis_study.validator.RegisterRequestValidator;


@RestController
public class RestMemberController {

	@Autowired
	private RestMemberService restService;
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return restService.showMembers();
	}

	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable long id, HttpServletResponse response) throws IOException {
		Member member = restService.showMemberbyId(id);
		if (member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}

	@PostMapping("/api/members")
	public void newMember(@Valid @RequestBody RegisterRequest regReq,Errors errors, HttpServletResponse response) throws IOException {
		try {
			new RegisterRequestValidator().validate(regReq, errors);
			if(errors.hasErrors()) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}		
			
			long newMemberId = restService.regist(regReq);
			response.setHeader("Location", "/api/members/" + newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (DuplicateMemberException e) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
	}
}
