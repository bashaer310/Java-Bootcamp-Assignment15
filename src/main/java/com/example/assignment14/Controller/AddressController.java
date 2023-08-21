package com.example.assignment14.Controller;


import com.example.assignment14.Api.ApiResponse;
import com.example.assignment14.DTO.AddressDTO;
import com.example.assignment14.Model.TeacherModel;
import com.example.assignment14.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAddresses(){
        return  ResponseEntity.status(200).body(addressService.getAddresses());
    }


    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO address){
        addressService.addAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO address, @PathVariable Integer id) {
        addressService.updateAddress(address,id);
        return ResponseEntity.status(200).body(new ApiResponse("Address updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted"));
    }

    @GetMapping("/getTeacherDetails/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id){
        return ResponseEntity.status(200).body(addressService.getTeacherDetails(id));

    }
}
