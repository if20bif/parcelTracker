package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.rest.WarehouseApi;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.impl.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:14:49.172303Z[Etc/UTC]")
@Controller
public class WarehouseApiController implements WarehouseApi {

    @Autowired
    private final NativeWebRequest request;

    @Autowired
    private final WarehouseService warehouseService;

    public WarehouseApiController(NativeWebRequest nativeWebRequest, WarehouseService warehouseService){
        this.request = nativeWebRequest;
        this.warehouseService = warehouseService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Warehouse> exportWarehouses(){
        return new ResponseEntity<>(warehouseService.getWarehouses().get(0), HttpStatus.OK);
    }

    //Changed Interface Type to Warehouse
    @Override
    public ResponseEntity<Warehouse> getWarehouse(String code){
        Optional<Warehouse> result = warehouseService.getWarehouseByCode(code);

        if(result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse){

        warehouseService.saveWarehouse(warehouse);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
