package de.wittenbude.exportify.spotify.clients;

import de.wittenbude.exportify.credentials.api.CredentialsInterceptor;
import de.wittenbude.exportify.spotify.data.SpotifyPrivateUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "SpotifyUserClient",
        url = "https://api.spotify.com/v1/me",
        configuration = {CredentialsInterceptor.class})
public interface SpotifyUserClient {

    @GetMapping
    SpotifyPrivateUser getCurrentUser(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String authorizationHeader);

    @GetMapping
    SpotifyPrivateUser getCurrentUser();

}
