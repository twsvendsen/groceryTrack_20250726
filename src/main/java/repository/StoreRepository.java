package repository;

import com.tws.grocerytracker.model.StoreLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreLocation, Integer> {
    Optional<StoreLocation> findByStoreNameAndAddress(String storeName, String address);

}
