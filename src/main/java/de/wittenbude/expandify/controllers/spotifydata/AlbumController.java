package de.wittenbude.expandify.controllers.spotifydata;

import de.wittenbude.expandify.models.spotifydata.Album;
import de.wittenbude.expandify.models.spotifydata.helper.SavedAlbum;
import de.wittenbude.expandify.services.spotifydata.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private static final Logger LOG = LoggerFactory.getLogger(AlbumController.class);
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    /**
     * Loads a page of saved albums from spotify to the db, including its tracks.
     *
     * @param offset The offset for the page.
     * @return The albums from the page
     */
    @GetMapping("/saved")
    public List<SavedAlbum> loadSavedAlbums(@RequestParam(required = false) Integer offset) throws SpotifyWebApiException {
        return albumService.loadSavedAlbums(offset == null ? 0 : offset);
    }

    /**
     * Loads a single album from db if present, from spotify otherwise.
     * @return The Album
     */
    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable String id) {
        return null;
    }


}