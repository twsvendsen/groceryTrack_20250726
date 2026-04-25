package repository;

import com.tws.grocerytracker.model.Commodity;
import com.tws.grocerytracker.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Integer> {
    List<GroceryItem> findAllByNameIn(List<String> inputGroceryItems);
}
