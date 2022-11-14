package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.services.dto.Warehouse;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {

    public List<Warehouse> getWarehouses();

    public Optional<Warehouse> getWarehouseByCode (String code);

    public void saveWarehouse(Warehouse warehouse);
}
