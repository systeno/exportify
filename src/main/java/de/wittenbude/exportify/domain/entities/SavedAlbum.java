package de.wittenbude.exportify.domain.entities;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
@Embeddable
public class SavedAlbum {

    private Instant savedAt;

    @ManyToOne
    @JoinColumn
    private Album album;
}