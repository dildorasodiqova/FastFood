package uz.example.fastfood.service.locationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.example.fastfood.enties.Location;
import uz.example.fastfood.repository.LocationRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;
    public Location addOrUpdateLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location getLocationByUserId(UUID userId) {
        return locationRepository.findByUserId(userId);
    }
}
