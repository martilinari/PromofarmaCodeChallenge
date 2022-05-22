package com.profarma.challenge.profarmacodechallenge.service.implementation;

import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import com.profarma.challenge.profarmacodechallenge.mapper.Mapper;
import com.profarma.challenge.profarmacodechallenge.repository.SellerRepository;
import com.profarma.challenge.profarmacodechallenge.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sellerService")
public class SellerServiceImpl implements ISellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    @Qualifier("Mapper")
    private Mapper mapper;


    @Override
    @Transactional
    public void save(SellerEntity seller) {
        sellerRepository.save(seller);
    }

    @Override
    @Transactional(readOnly = true)
    public SellerEntity findById(Long id) {
        return sellerRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public SellerEntity findSeller(SellerEntity sellerEntity) {
        return sellerRepository.findByEmail(sellerEntity.getEmail());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SellerDto> findAll() {
        return mapper.convertListSeller(sellerRepository.findAll());
    }

}
