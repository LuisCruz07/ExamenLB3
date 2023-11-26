package com.example.demo.controllador;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Producto;
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

	@GetMapping ("/registrar")
	public String registrarProducto(Model model) {
		model.addAttribute("registpro",new Producto());
		return "registrarProducto";
		
	}
	
	@PostMapping("/SafeProducto")
	public String GuardarProducto(Model model,@ModelAttribute Producto registpro) {
		interproduc.save(registpro);	
		return "redirect:/productos";
		
	}
	
	@GetMapping ("/Actualizar/{idproducto}")
	public String ActualizarProducto(Model model, @PathVariable Integer idproducto) {
		model.addAttribute("registpro",interproduc.findById(idproducto));
	
		return "registrarProducto";
	}
	
	@PostMapping("/EliminarProducto")
   public String EliminarProducto(@RequestParam Integer id) {
		interproduc.deleteById(id);
		return "redirect:/productos";
	}
	
}
