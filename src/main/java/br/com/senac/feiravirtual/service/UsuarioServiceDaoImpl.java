package br.com.senac.feiravirtual.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.senac.feiravirtual.dao.UsuarioDao;
import br.com.senac.feiravirtual.domain.Usuario;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceDaoImpl implements UsuarioService {

	@Autowired
	private UsuarioDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Usuario usuario) {
		dao.save(usuario);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Usuario usuario) {
		dao.update(usuario);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}


	@Override
	public Usuario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		return dao.findByNome(nome);
	}

	@Override
	public List<Usuario> buscarPorCpf(String cpf) {
		return dao.findByCpf(cpf);
	}

	@Override
	public List<Usuario> buscarPorDataNascimento(LocalDate dataNascimento) {
		return dao.findByDataNascimento(dataNascimento);
	}

}
