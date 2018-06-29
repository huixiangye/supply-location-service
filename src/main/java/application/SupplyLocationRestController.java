package application; /**
 * Created by yehuixiang on 6/29/18.
 */
import application.SupplyLocation;
import application.SupplyLocationRespository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
public class SupplyLocationRestController {

    private SupplyLocationRespository repository;

    @Autowired
    public SupplyLocationRestController(SupplyLocationRespository repository){
        this.repository= repository;
    }

    @RequestMapping(value = "/bulk/supplyLocations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<SupplyLocation> locations){
        this.repository.save(locations);
    }

    @RequestMapping(value = "/purge", method = RequestMethod.DELETE)
    public void purge() {
        this.repository.deleteAll();
    }

}