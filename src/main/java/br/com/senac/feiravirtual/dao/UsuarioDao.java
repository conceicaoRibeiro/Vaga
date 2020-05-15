package br.com.senac.feiravirtual.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.senac.feiravirtual.domain.Usuario;

public interface UsuarioDao {
		
	void save(Usuario funcionario);

    void update(Usuario funcionario);

    void delete(Long id);

    Usuario findById(Long id);

    List<Usuario> findAll();
    
    List<Usuario> findByNome(String nome);

	List<Usuario> findByDataNascimento(LocalDate dataNascimento);
	
	List<Usuario> findByCpf(String cpf);
	
}
