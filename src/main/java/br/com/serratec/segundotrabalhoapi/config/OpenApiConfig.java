package br.com.serratec.segundotrabalhoapi.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Value("${dominio.openapi.dev-url}")
    private String devUrl;

    @Value("${dominio.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {

        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Servidor de desenvolvimento");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Servidor de produção");

        Contact contact = new Contact();
        contact.setName("Grupo 6 Segundo Trabalho API");
        contact.setEmail("gabrielamontescoelho@gmail.com");
        contact.setUrl("https://github.com/gabrielamontescoelho/Segundo_Trabalho_API");

        Info info = new Info()
                .title("API de Vendedores e Lançamentos de Vendas")
                .version("1.0")
                .description("API REST desenvolvida em Spring Boot para gerenciamento de vendedores e lançamentos de vendas.")
                .contact(contact);

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }
}

