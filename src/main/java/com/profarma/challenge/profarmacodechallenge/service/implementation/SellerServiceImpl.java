package com.profarma.challenge.profarmacodechallenge.service.implementation;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import com.profarma.challenge.profarmacodechallenge.repository.SellerRepository;
import com.profarma.challenge.profarmacodechallenge.service.ISellerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("sellerService")
public class SellerServiceImpl implements ISellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(SellerDto sellerDto) {
        sellerDto.setSellerName(sellerDto.getSellerName().toLowerCase());
        sellerRepository.save(convertDtoToEntity(sellerDto));
    }

    @Override
    @Transactional(readOnly = true)
    public SellerDto findSellerByName(SellerDto sellerDto) {
        return convertEntityToDto(sellerRepository.findBySellerName(sellerDto.getSellerName().toLowerCase()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SellerDto> getAllSellers() {
        return sellerRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SellerDto findById(Long id) {
        return convertEntityToDto(sellerRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }

//
//    @Override
//    @Transactional(readOnly = true)
//    public SellerEntity findSeller(SellerEntity sellerEntity) {
//        return sellerRepository.findByName(sellerEntity.getName());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public List<SellerDto> findAll() {
//        return mapper.convertListSeller(sellerRepository.findAll());
//    }

    private SellerDto convertEntityToDto(SellerEntity sellerEntity) {
        SellerDto sellerDto = null;
        if (sellerEntity != null) {
            new SellerDto();
            sellerDto = modelMapper.map(sellerEntity, SellerDto.class);
        }
        return sellerDto;
    }

    private SellerEntity convertDtoToEntity(SellerDto sellerDto) {
        SellerEntity sellerEntity = null;
        if (sellerDto != null) {
            new SellerEntity();
            sellerEntity = modelMapper.map(sellerDto, SellerEntity.class);
        }
        return sellerEntity;
    }

}
