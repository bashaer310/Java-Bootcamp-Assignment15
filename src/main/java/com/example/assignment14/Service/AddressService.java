package com.example.assignment14.Service;


import com.example.assignment14.Api.ApiException;
import com.example.assignment14.DTO.AddressDTO;
import com.example.assignment14.Model.AddressModel;
import com.example.assignment14.Model.TeacherModel;
import com.example.assignment14.Repository.AddressRepository;
import com.example.assignment14.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<AddressModel> getAddresses(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        TeacherModel teacher=teacherRepository.findTeacherModelById(addressDTO.getTeacher_id());
        if (teacher==null)
            throw new ApiException("Id not found");

        AddressModel address =new AddressModel(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }
    public void updateAddress(AddressDTO addressDTO,Integer id){
        AddressModel oldAddress=addressRepository.findAddressModelById(id);
        if (oldAddress==null)
            throw new ApiException("Id not found");

        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    public void deleteAddress(Integer id){
        AddressModel address=addressRepository.findAddressModelById(id);
        TeacherModel teacher= teacherRepository.findTeacherModelById(id);

        if (address==null)
            throw new ApiException("Id not found");

        teacher.setAddressModel(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }
    public TeacherModel getTeacherDetails(Integer id){

        //teacher contains address object which store other info about it
        TeacherModel teacher= teacherRepository.findTeacherModelById(id);
        AddressModel address=addressRepository.findAddressModelById(id);

        if (teacher==null)
            throw new ApiException("Id not found");
        if (address==null)
            throw new ApiException("Teacher address not found");


        return teacher;
    }
}
