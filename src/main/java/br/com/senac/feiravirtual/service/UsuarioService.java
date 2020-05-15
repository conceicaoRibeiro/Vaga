package br.com.senac.feiravirtual.service;

import java.time.LocalDate;
import java.util.List;

import br.com.senac.feiravirtual.domain.Usuario;

public interface UsuarioService {
	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(Long id);

	Usuario buscarPorId(Long id);

	List<Usuario> buscarTodos();

	List<Usuario> buscarPorNome(String nome);

	List<Usuario> buscarPorCpf(String cpf);

	List<Usuario> buscarPorDataNascimento(LocalDate dataNascimento);

}
