package in.shop.api.config;

import jakarta.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;


public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter> {

    @Autowired
    private RouteValidator  routeValidator;
    @Autowired
    private JwtService jwtService;

    @Override
    public GatewayFilter apply(AuthenticationFilter config) {
        return ((exchange, chain) ->{
    if(routeValidator.isSecured.test((ServerHttpRequest) exchange.getRequest())){
        if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            throw new BadRequestException("Authorization header is missing");

        }
        String token= String.valueOf(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION));
            if(token!=null&&token.startsWith("Bearer ")){
             token=token.substring(7);
            }
            try {
                jwtService.validateToken(token);
            }
            catch (Exception e) {

                throw new BadRequestException("Invalid token");
            }
            }

       return chain.filter(exchange);
        });
    }
}
