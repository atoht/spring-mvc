package testMVC.org.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import testMVC.org.dao.MyDataDao;
import testMVC.org.entity.MyData;
import testMVC.org.repositories.MyDataRepository;
import testMVC.org.repositories.MyDataService;

@Controller
public class MyFindAppController<T> {

	@Autowired
	private MyDataDao<MyData> myDataDao;
	
	@Autowired
	private MyDataService service;
	
	@Autowired
	private MyDataRepository repository;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String find (Model model) {
		model.addAttribute("title", "Sample");
		model.addAttribute("message", "検索のサンプルです。");
//		List<MyData> list = myDataDao.getALL();
//		List<MyData> list = service.getAll();
		List<MyData> list = repository.findByIdIsNotNullOrderByIdDesc();
		model.addAttribute("datalist", list);
		return "find";
	}
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public String search (HttpServletRequest request, Model model) {
		String param = request.getParameter("fstr");
		model.addAttribute("title", "Sample");
		model.addAttribute("message", "「" + param +"」の検索結果。");
//		model.addAttribute("datalist", repository.findByNameLike(param));
		model.addAttribute("datalist", repository.findByAgeGreaterThan(Integer.parseInt(param)));
//		model.addAttribute("datalist", repository.findById(Long.parseLong(param)));
		return "find";
	}
}
