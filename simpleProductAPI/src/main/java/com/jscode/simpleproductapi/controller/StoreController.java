package com.jscode.simpleproductapi.controller;

import com.jscode.simpleproductapi.dto.StoreDTO;
import com.jscode.simpleproductapi.entity.Store;
import com.jscode.simpleproductapi.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    final StoreService storeService;

    @PostMapping("")
    public Store postNewStore(@RequestBody Store newStore) {
        return storeService.postNewStore(newStore);
    }

    @GetMapping("/all")
    public List<StoreDTO> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("")
    public StoreDTO getStoreInformationById(@RequestParam Long id) {
        StoreDTO store;

        try {
            store = storeService.getStoreInformationById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return store;
    }
}
