package com.example.demo.controllador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repositorio.interfacepro;
@Controller

public class ProductoControllador {
	@Autowired
	interfacepro interproduc;
	@GetMapping ("/productos")
	
	public String productolist(Model model){
		model.addAttribute("lista",interproduc.findAll());
		
		
		return "productolist";
		
		
		
	}
	
	
}
