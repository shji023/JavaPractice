package Pack01;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Pack01.Dao;
@Controller
public class SurveyControl {
	/*@RequestMapping("/survey")
	String func01(Model model,
			@RequestParam(value="name")String name,
			@RequestParam(value="age")String age,
			@RequestParam(value="phone")String phone,
			@RequestParam(value="living_region")String living_region,
			@RequestParam(value="role")String role,
			@RequestParam(value="tool")String tool,
			@RequestParam(value="wts")String wts) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("phone",phone);
		model.addAttribute("living_region",living_region);
		model.addAttribute("role",role);
		model.addAttribute("tool",tool);
		model.addAttribute("wts",wts);
		return "SurveyResultView";
	}*/
	
	@RequestMapping("/survey")
	String func01(DTO dto) {
		Dao aut = new Dao();
		Boolean tt = aut.setSurvey(dto);
		if (tt == true) {
			return "SurveyResultView";
		}
		return null;
	}
	
	

}
