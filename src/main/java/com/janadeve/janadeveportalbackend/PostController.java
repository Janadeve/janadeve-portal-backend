package com.janadeve.janadeveportalbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id){
        System.out.println("Acessando controller");
        Optional<Post> resultado = postService.buscar(id);
        return ResponseEntity.ok().body(resultado);
    }

    @PostMapping()
    public ResponseEntity<?> adicionar(@RequestBody Post post){
        Post resultado = postService.adicionar(post);
        return ResponseEntity.ok().body(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        try{
            postService.remover(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Post newPost, @PathVariable Long id){
        Post postSalvo = postService.atualizar(newPost, id);
        return ResponseEntity.ok().body(postSalvo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarParcial(@RequestBody Map<String, Object> newPost, @PathVariable Long id){
        Post postSalvo = postService.atualizarParcial(newPost, id);
        return ResponseEntity.ok().body(postSalvo);
    }
}
