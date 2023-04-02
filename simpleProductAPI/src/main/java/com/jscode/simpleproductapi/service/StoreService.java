package com.jscode.simpleproductapi.service;

import com.jscode.simpleproductapi.dto.StoreDTO;
import com.jscode.simpleproductapi.entity.Store;
import com.jscode.simpleproductapi.repository.StoreJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    final StoreJPARepository storeJPARepository;

    public Store postNewStore(Store newStore) {
        return storeJPARepository.save(newStore);
    }

    public List<StoreDTO> getAllStores() {
        return transformEntityToDTO(storeJPARepository.findAll());
    }

    public StoreDTO getStoreInformationById(Long id) throws Exception {
        Optional<Store> store = storeJPARepository.findById(id);

        if (store.isEmpty()) {
            throw new NullPointerException();
        }

        return transformEntityToDTO(store.get());
    }

    private StoreDTO transformEntityToDTO(Store store) {
        return new StoreDTO(store.getName(), store.getAddress(), store.getTelephoneNumber());
    }

    private List<StoreDTO> transformEntityToDTO(List<Store> stores) {
        List<StoreDTO> newList = new ArrayList<>();

        for(Store store: stores) {
            newList.add(transformEntityToDTO(store));
        }

        return newList;
    }
}
