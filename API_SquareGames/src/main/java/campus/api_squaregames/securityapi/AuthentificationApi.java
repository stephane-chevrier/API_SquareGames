package campus.api_squaregames.securityapi;

import campus.api_squaregames.dtopersistencee.UserDtoPersistence;
import campus.api_squaregames.dtopersistencee.UserDtoPersistenceRepository;
import campus.api_squaregames.dtoweb.AuthentificationRequest;
import campus.api_squaregames.dtoweb.UserDtoWeb;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/public")
public class AuthentificationApi {

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthentificationApi(AuthenticationManager authenticationManager, SecurityConfig securityConfig) {
        this.authenticationManager = authenticationManager;
        this.securityConfig = securityConfig;
    }

    @Autowired
    private UserDtoPersistenceRepository userDao;

    @Autowired
    private final SecurityConfig securityConfig;

    private static final Long tokenLifeTime = 3600 * 1000L;

    @Secured(Roles.ROLE_ADMIN)
    @PostMapping("/create")
    public void create(@RequestBody UserDtoWeb userDtoWeb) {
        UserDtoPersistence userDtoPersistence = new UserDtoPersistence(
                userDtoWeb.getUsername(),
                securityConfig.passwordEncoder().encode(userDtoWeb.getPassword()));
        userDao.save(userDtoPersistence);
    }


    @PostMapping("/login")
    public ResponseEntity<UserDtoWeb> login(@RequestBody @Valid AuthentificationRequest request) {

        try {
            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                    );

            final UserDtoPersistence user = (UserDtoPersistence) authenticate.getPrincipal();
            final String token = Jwts.builder().setSubject(
                    authenticate.getName()).claim("authorities",
                    authenticate.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList())).setIssuedAt(new Date())
                            .setExpiration(new Date(System.currentTimeMillis() + tokenLifeTime))
                            .signWith(SignatureAlgorithm.HS512, JwtTokenAuthenticationFilter.keyFilter.getBytes()).compact();

            UserDtoWeb userDtoWeb = new UserDtoWeb(user);

            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body(userDtoWeb);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
