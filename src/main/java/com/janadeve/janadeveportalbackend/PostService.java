package com.janadeve.janadeveportalbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Field;
import java.util.Map;
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

    public Post atualizar(Post post, Long id){
        Optional<Post> oldPost = this.buscar(id);
        if(oldPost.isPresent()){
            BeanUtils.copyProperties(post, oldPost,"id");
            return postRepository.save(post);
        }
        throw new EntityNotFoundException();
    }

    public Post atualizarParcial(Map<String, Object> post, Long id){
        Optional<Post> oldPost = this.buscar(id);
        if(oldPost.isPresent()){
            merge(post, oldPost.get());
            return this.atualizar(oldPost.get(), id);
        }
        throw new EntityNotFoundException();
    }

    protected void merge(Map<String, Object> dadosOrigem, Object objetoDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object objetoOrigem = objectMapper.convertValue(dadosOrigem, objetoDestino.getClass());


        dadosOrigem.forEach((nomePropriedade, valorPropriedade) ->{
            Field field = ReflectionUtils.findField(objetoDestino.getClass(), nomePropriedade);
            field.setAccessible(true);
            System.out.println(nomePropriedade + " - " + valorPropriedade);

            Object novoValor = ReflectionUtils.getField(field, objetoOrigem);

            ReflectionUtils.setField(field, objetoDestino, novoValor);

        });
    }
}
