package testMVC.org;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAppController {
	
	@Autowired
	IListDataModelSerice iListDataModelSerice;
	
	private List<FormModel> buyList = new ArrayList<FormModel>();

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello (Model model) {
		FormModel fm = new FormModel();
		fm.setInput1("ここに書く");
		model.addAttribute("formModel", fm);
		model.addAttribute("checks", iListDataModelSerice.getListDataModel());
//		model.addAttribute("checks", getList());
		model.addAttribute("message", "何か書いてください。");
		return "showMessage";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String hello (@ModelAttribute FormModel fm, Model model) {
		model.addAttribute("message", "you typed:" + fm.getInput1());
		return "showMessage";
	}
	
	@RequestMapping(value="/hel", method=RequestMethod.GET)
	public ModelAndView hel() {
		ModelAndView model = new ModelAndView("showMessage");
		model.addObject("title", "ModelAndView sample");
		model.addObject("message", "これはModelAndViewのテストです。");
		FormModel form = new FormModel();
		form.setInput1("type here...");
		model.addObject("formModel", form);
		return model;
	}
	
	@RequestMapping(value="/hel", method=RequestMethod.POST)
	public ModelAndView hel(@ModelAttribute FormModel form) {
		String str = "<ul><li>" + form.getInput1() + "</li><li>" + form.getPass1() + 
				"</li><li>" + form.getArea1() + "</li></ul>";
		if (form.getChecks1().length != 0) {
			str += "<ol>";
			for (String temp : form.getChecks1()) {
				str += "<li>" + temp + "</li>";
			}
			str += "</ol>";
		}
		ModelAndView model = new ModelAndView("showMessage");
		model.addObject("title", "ModelAndView sample");
		model.addObject("checks", iListDataModelSerice.getListDataModel());
		model.addObject("message", str);
		return model;
	}
	
	@RequestMapping(value="/showItems", method=RequestMethod.GET)
	public String showItems (Model model) {
		model.addAttribute("title", "Sample");
		model.addAttribute("message", "Selectのサンプルです。");
		model.addAttribute("formModel", new FormModel());
		return "showItems";
	}
	
	@RequestMapping(value="/showItems", method=RequestMethod.POST)
	public String showItems (@Valid @ModelAttribute FormModel fModel, BindingResult result, 
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Sample [ERROR]");
			model.addAttribute("message", "値を再チェックしてください！");
		} else {
			buyList.add(fModel);
			String str = "<ol>";
			str += "<li>" + fModel.getItem() + "</li>";
			str += "<li>" + fModel.getPrice() + "</li>";
			str += "<li>" + fModel.getMemo() + "</li>";
			str += "<li>" + Calendar.getInstance().getTime() + "</li>";
			str += "</ol>";
			str += "<p>" + buyList.size() + "</p>";
			model.addAttribute("message", str);
		}
		model.addAttribute("dataList", buyList);
		return "showItems";
	}
}
