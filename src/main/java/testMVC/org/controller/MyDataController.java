package testMVC.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import testMVC.org.dao.MyDataDao;
import testMVC.org.entity.MyData;

@Controller
public class MyDataController {
	
	@Autowired
	private MyDataDao<MyData> myDataDao;
	
	@RequestMapping(value="/helo", method=RequestMethod.GET)
	public String helo (Model model) {
		model.addAttribute("title", "Sample");
		model.addAttribute("message", "MyDataのサンプルです。");
		MyData md = new MyData();
		model.addAttribute("myData", md);
		List<MyData> all = myDataDao.getALL();
		model.addAttribute("allMyData", all);
		return "showMyData";
	}
	
	@RequestMapping(value="/helo", method=RequestMethod.POST)
	public String form (@Valid @ModelAttribute MyData myData, Errors result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Sample [ERROR]");
			model.addAttribute("message", "値を再チェックしてください。");
			return "showMyData";
		}
		myDataDao.add(myData);
		return "redirect:/helo";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String edit(@RequestParam(value="id") int id, Model model) {
		model.addAttribute("title", "Sample");
		model.addAttribute("message", "更新のページ");
		MyData myData = myDataDao.findById(id);
		model.addAttribute("myData", myData);
		model.addAttribute("allMyData", myDataDao.getALL());
		return "showMyData";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(@RequestParam(value="id") int id, @Valid @ModelAttribute MyData myData,
			Errors result, Model model) {
		myDataDao.update(myData);
		return "redirect:/helo";
	}
	
	@RequestMapping(value="/delect", method=RequestMethod.GET)
	public String delect(@RequestParam(value="id")int id, Model model) {
		myDataDao.delete(id);
		return "redirect:/helo";
	}
}
