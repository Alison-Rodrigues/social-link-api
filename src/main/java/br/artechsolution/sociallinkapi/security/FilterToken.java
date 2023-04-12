package br.artechsolution.sociallinkapi.security;

import br.artechsolution.sociallinkapi.repository.UserAdminRepository;
import br.artechsolution.sociallinkapi.services.TokenService;
import com.auth0.jwt.interfaces.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Antes de qualquer requisição, o token é passado por esse filtro

@Component
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserAdminRepository userAdminRepository;


    //Filtro para verificar se o usuário está autenticado quando uma requisição for enviada
    //Intercepta as requests e impede ou libera o acesso às rotas
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token;

        //Pega a Authorization que é passada no header
        var headerAuthorization = request.getHeader("Authorization");

        if (headerAuthorization != null) {
            //Replace para tirar o Bearer do token e obter um token limpo
            token = headerAuthorization.replace("Bearer ", "");

            //Pega o subject (email) passando o token
            var subject = this.tokenService.getSubject(token);

            //Usa o método findByEmail passando o subject
            var user = this.userAdminRepository.findByEmail(subject);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            //Passa para o spring para saber que o usuário está autenticado
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);



    }
}
