package de.wittenbude.exportify.db.entity;

import com.neovisionaries.i18n.CountryCode;
import de.wittenbude.exportify.spotify.data.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class SpotifyUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String displayName;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> externalUrls;

    @JdbcTypeCode(SqlTypes.JSON)
    private Followers followers;

    private String href;

    private String spotifyID;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<Image> images;

    private SpotifyObjectType type;

    private String uri;

    private CountryCode country;

    private String email;

    @JdbcTypeCode(SqlTypes.JSON)
    private ExplicitContent explicitContent;

    private ProductType product;
}

