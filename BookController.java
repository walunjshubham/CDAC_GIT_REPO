package study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import study.dao.BookDAO;
import study.pojo.Book;

@Controller
//@RequestMapping("/book")
public class BookController 
{
	@Autowired
	BookDAO dao;
	
	@RequestMapping("/getnames")
	public String show(Model model) 
	{
		
		  List<Book> al=dao.allbook(); 
		 model.addAttribute("book",al);
		 
		
		return "index";
		

	}
	
	
	@RequestMapping(method=RequestMethod.GET,path="/delete")
	public void deleteBook(@RequestParam int id) 
	{
		dao.delete(id);

	}

}
