package application; /**
 * Created by yehuixiang on 6/28/18.
 */
import application.SupplyLocation;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "supplyLocations")
public interface SupplyLocationRespository extends PagingAndSortingRepository<SupplyLocation, String> {

    SupplyLocation findFirstByLocationNear(@Param("location") Point location);
}