package br.com.senac.feiravirtual.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senac.feiravirtual.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario,Long> implements UsuarioDao {

	@Override
	public List<Usuario> findByNome(String nome) {
		return createQuery("select u from Usuario u where u.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Usuario> findByDataNascimento(LocalDate dataNascimento) {
		String jpql = new StringBuilder("select u from Usuario u ")
				.append("where u.dataNascimento = ?1 ")
				.toString();
		return createQuery(jpql, dataNascimento);
	}

	@Override
	public List<Usuario> findByCpf(String cpf) {
		return createQuery("select u from Usuario u where u.cpf like concat('%',?1,'%')", cpf);
	}
}
