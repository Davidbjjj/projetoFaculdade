package projetoArtigos.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

public class Artigos {
    private String titulo;
    private String autor;
    private String conteudo;

    public Artigos(String titulo, String autor, String conteudo) {
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getConteudo() { return conteudo; }
}

// Serviço
@Service
class ArtigoService {
    public List<Artigos> listarArtigos() {
        return Arrays.asList(
                new Artigos("Spring Boot MVC", "David Pontes",
                        "Spring Boot MVC é um poderoso framework para o desenvolvimento de aplicações web na plataforma Java. " +
                                "Ele simplifica a configuração e fornece uma estrutura robusta para criar APIs RESTful e aplicações " +
                                "baseadas no padrão MVC (Model-View-Controller). Com recursos como injeção de dependências, configuração " +
                                "automática e integração com bancos de dados, o Spring Boot facilita a criação de aplicações escaláveis. " +
                                "Neste artigo, exploramos os conceitos fundamentais do MVC, a estrutura de um projeto Spring Boot e como " +
                                "configurar controladores, serviços e repositórios para uma aplicação eficiente."
                ),

                new Artigos("React com Spring Boot", "David Pontes",
                        "A integração entre React e Spring Boot tem se tornado uma abordagem popular para o desenvolvimento " +
                                "de aplicações web modernas. React fornece uma interface interativa e dinâmica, enquanto Spring Boot " +
                                "garante uma API robusta e bem estruturada no backend. Neste artigo, veremos como configurar um backend " +
                                "Spring Boot, criar endpoints REST e consumir esses dados no React usando `fetch` ou `axios`. " +
                                "Abordaremos também conceitos como CORS, autenticação JWT e a comunicação entre frontend e backend " +
                                "por meio do padrão REST."
                ),

                new Artigos("REST API com Spring", "David Pontes",
                        "Desenvolver APIs REST com Spring Boot é uma prática essencial para criar serviços web eficientes. " +
                                "Neste artigo, vamos abordar desde a configuração inicial até o desenvolvimento de endpoints que seguem " +
                                "as melhores práticas RESTful. Exploraremos como criar controladores REST usando `@RestController`, " +
                                "definir métodos HTTP como GET, POST, PUT e DELETE, e utilizar o Spring Data JPA para persistência de " +
                                "dados. Além disso, discutiremos como implementar autenticação e segurança em APIs usando Spring Security."
                )
        );
    }
}

// Controlador
@RestController
@RequestMapping("/artigos")
class ArtigoController {
    private final ArtigoService artigoService;

    public ArtigoController(ArtigoService artigoService) {
        this.artigoService = artigoService;
    }

    @GetMapping("/listar")
    public List<Artigos> listarArtigos() {
        return artigoService.listarArtigos();
    }
}
