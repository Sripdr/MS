package in.shop.api.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
    public static final List<String> endpoints=List.of("/greet","/shop/user/auth/**","/wel","/shop/product/**");

public Predicate<ServerHttpRequest> isSecured= request -> endpoints.stream().noneMatch(endpoint -> endpoint.equals(request.getURI().getPath()));
}

