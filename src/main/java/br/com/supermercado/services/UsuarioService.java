package br.com.supermercado.services;

import br.com.supermercado.models.Usuario;
import br.com.supermercado.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void criarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public ArrayList<Usuario> pegarTodosUsuarios() {
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    public Usuario pegarUmUsuario(Long id) {
        Optional<Usuario> usuarioPeloId = usuarioRepository.findById(id);
        return usuarioPeloId.get();
    }

    public void atualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        Usuario usuarioParaAtualizar = usuarioOptional.get();
        usuarioParaAtualizar.setCargo(usuario.getCargo());
        usuarioParaAtualizar.setNome(usuario.getNome());
        usuarioParaAtualizar.setSenha(usuario.getSenha());
        usuarioRepository.save(usuarioParaAtualizar);
    }

    public void excuirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public ArrayList<Usuario> pegarUsuarioPorNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.pesquisaPorNome(nome);
        return (ArrayList<Usuario>) usuarios;
    }
}
