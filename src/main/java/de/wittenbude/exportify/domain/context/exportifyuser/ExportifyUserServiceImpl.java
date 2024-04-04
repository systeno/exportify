package de.wittenbude.exportify.domain.context.exportifyuser;

import de.wittenbude.exportify.domain.entities.ExportifyUser;
import org.springframework.stereotype.Service;

@Service
class ExportifyUserServiceImpl implements ExportifyUserService {

    private final ExportifyUserRepository exportifyUserRepository;

    ExportifyUserServiceImpl(ExportifyUserRepository exportifyUserRepository) {
        this.exportifyUserRepository = exportifyUserRepository;
    }


    public ExportifyUser findOrCreate(String spotifyID) {
        return exportifyUserRepository
                .findBySpotifyID(spotifyID)
                .orElseGet(() -> exportifyUserRepository.save(new ExportifyUser().setSpotifyUserID(spotifyID)));
    }
}