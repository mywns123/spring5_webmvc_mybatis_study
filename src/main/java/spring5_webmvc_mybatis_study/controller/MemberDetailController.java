package spring5_webmvc_mybatis_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.exception.MemberNotFoundException;
import spring5_webmvc_mybatis_study.mappers.MemberMapper;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberMapper memberMapper;

	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id") long memId) {
		Member member = memberMapper.selectbyId(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
	}
}