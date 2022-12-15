package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {

    public Optional<List<Warehouse>> getWarehouses();

    public Optional<Warehouse> getWarehouseByCode (String code);

    public void saveWarehouse(Warehouse warehouse);
}
