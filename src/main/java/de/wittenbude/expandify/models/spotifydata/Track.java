package de.wittenbude.expandify.models.spotifydata;

import com.neovisionaries.i18n.CountryCode;
import de.wittenbude.expandify.models.spotifydata.helper.TrackLink;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import se.michaelthelin.spotify.enums.ModelObjectType;

import java.util.Arrays;
import java.util.Map;

@Data
@NoArgsConstructor
@Document(collection = "tracks")
public class Track {
    @DocumentReference(lazy = true)
    private AlbumSimplified albumSimplified;
    @DocumentReference(lazy = true)
    private ArtistSimplified[] artistSimplified;
    private CountryCode[] availableMarkets;
    private Integer discNumber;
    private Integer durationMs;
    private Boolean explicit;
    private Map<String, String> externalIds;
    private Map<String, String> externalUrls;
    private String href;
    @Id
    private String id;
    private Boolean isPlayable;
    private TrackLink linkedFrom;
    private String restrictionReason;
    private String name;
    private Integer popularity;
    private String previewUrl;
    private Integer trackNumber;
    private ModelObjectType type;
    private String uri;


    public Track(se.michaelthelin.spotify.model_objects.specification.Track track) {
        this.albumSimplified = new AlbumSimplified(track.getAlbum());
        this.artistSimplified = Arrays.stream(track.getArtists()).map(ArtistSimplified::new).toArray(ArtistSimplified[]::new);
        this.discNumber = track.getDiscNumber();
        this.explicit = track.getIsExplicit();
        this.externalIds = track.getExternalIds().getExternalIds();
        this.externalUrls = track.getExternalUrls().getExternalUrls();
        this.href = track.getHref();
        this.id = track.getId();
        this.isPlayable = track.getIsPlayable();
        this.linkedFrom = new TrackLink(track.getLinkedFrom());
        this.restrictionReason = track.getRestrictions().getReason();
        this.name = track.getName();
        this.popularity = track.getPopularity();
        this.previewUrl = track.getPreviewUrl();
        this.trackNumber = track.getTrackNumber();
        this.type = track.getType();
        this.uri = track.getUri();
    }
}