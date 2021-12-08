package com.janadeve.janadeveportalbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Optional<Post> buscar(Long id){
        System.out.println("Acessando serviço");
        Optional<Post> resultado = postRepository.findById(id);

        return resultado;
    }

    public Post adicionar(Post post){
        Post resultado = postRepository.save(post);
        return resultado;
    }

    public void remover(Long id){
        postRepository.deleteById(id);
    }
}
