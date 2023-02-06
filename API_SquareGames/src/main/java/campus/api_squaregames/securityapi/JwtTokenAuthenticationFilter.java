package campus.api_squaregames.securityapi;

import campus.api_squaregames.dtopersistencee.UserDaoPersistenceRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    // creation de l'objet userDtoPersistenceRepository
    @Autowired
    UserDaoPersistenceRepository userDaoPersistenceRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenAuthenticationFilter.class);

    protected static String keyFilter = "Sq2#@";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // recuperation de l'entete
        final String header = request.getHeader("Authorization");

        // si l'entete est renseignee
        if (header!=null) {

            // si l'entete commence par Bearer
            if (header.startsWith("Bearer")) {

                // recuperation du jeton
                final String token = header.split(" ")[1].trim();

                // On “parse” le token en utilisant la même clé de signature qui sera
                // utilisee pour generer le token à l’authentification (“Sq2#@”)
                final Claims claims =
                        Jwts.parser().setSigningKey(keyFilter.getBytes()).parseClaimsJws(token)
                                .getBody();

                // si la date d'expiration du jeton n'est pas expire
                if (claims.getExpiration().after(new Date())) {

                    // On recupere le nom de l’utilisateur indique dans l’objet
                    final String username = claims.getSubject();

                    // On recupere les informations de l’utilisateur grace au repository
                    final UserDetails userDetails = userDaoPersistenceRepository.findByUsername(username);
                    final UsernamePasswordAuthenticationToken
                            authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null,
                            userDetails == null ?
                                    List.of() : userDetails.getAuthorities()
                    );

                    // Ajoute les informations de l’utilisateur
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    // Met à jour le contexte d’authentification
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                } else {
                    // implementation du .log de l'erreur rencontree
                    LOGGER.warn("la requête est expirée : "+claims.getExpiration()+" ,requete : "+request);
                }
            } else {
                // implementation du .log de l'erreur rencontree
                LOGGER.warn("L'entête de la requête ne commence pas par Bearer, requete :"+request);
            }
        } else {
            // implementation du .log de l'erreur rencontree
            LOGGER.warn("La requête ne comporte pas d'entête, requete : "+request);
        }

        // Important : permet à Spring de continuer le traitement !
        filterChain.doFilter(request, response);

    }
}
