package br.com.senac.feiravirtual.web.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.senac.feiravirtual.domain.UF;
import br.com.senac.feiravirtual.domain.Usuario;
import br.com.senac.feiravirtual.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/cadastrar")
	public String cadastrar(Usuario usuario) {
		return "/usuario/cadastro";
	}

	@GetMapping("/listar")
	public String listar(Usuario usuario, ModelMap model) {
		 model.addAttribute("usuarios", usuarioService.buscarTodos()); 
		return "/usuario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Usuario usuario, RedirectAttributes attr) {
		usuarioService.salvar(usuario);
		attr.addFlashAttribute("success", "Usuário inserido com sucesso.");
		return "redirect:/usuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("usuario", usuarioService.buscarPorId(id));
		return "usuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Usuario usuario,RedirectAttributes attr) {
		usuarioService.editar(usuario);
		attr.addFlashAttribute("success", "Usuário editado com sucesso.");
		return "redirect:/usuarios/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		usuarioService.excluir(id);
		attr.addFlashAttribute("success", "Usuário removido com sucesso.");
		return "redirect:/usuarios/listar";
	}	

	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("usuarios",usuarioService.buscarPorNome(nome));
		return "usuario/lista";
	}
	@GetMapping("/buscar/cpf")
	public String getPorCpf(@RequestParam("cpf") String cpf, ModelMap model) {		
		model.addAttribute("usuarios",usuarioService.buscarPorCpf(cpf));
		return "usuario/lista";
	}
	
	@GetMapping("/buscar/data")
    public String getPorData(@RequestParam("dataNascimento") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataNascimento,
                              ModelMap model) {
        model.addAttribute("usuarios", usuarioService.buscarPorDataNascimento(dataNascimento));
        return "usuario/lista";
    }

	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
