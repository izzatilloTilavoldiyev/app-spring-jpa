package uz.pdp.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.practice.model.Laptop;
import uz.pdp.practice.repository.LaptopRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    LaptopRepository laptopRepository;

    @RequestMapping(value = "/laptop", method = RequestMethod.GET)
    public List<Laptop> getLaptops() {
        return laptopRepository.findAll();
    }

    @RequestMapping(value = "/laptop", method = RequestMethod.POST)
    public String addLaptop(@RequestBody Laptop laptop) {
        laptopRepository.save(laptop);
        return "Laptop added";
    }

    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.GET)
    public Laptop getLaptop(@PathVariable Integer id) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()) {
            return optionalLaptop.get();
        }
        return new Laptop();
    }

    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.DELETE)
    public String deleteLaptop(@PathVariable Integer id) {
        laptopRepository.deleteById(id);
        return "Laptop deleted";
    }

    @RequestMapping(value = "/laptop/{id}", method = RequestMethod.PUT)
    public String editLaptop(@PathVariable Integer id, @RequestBody Laptop laptop) {
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent()) {
            Laptop editingLaptop = optionalLaptop.get();
            editingLaptop.setName(laptop.getName());
            editingLaptop.setBrandName(laptop.getBrandName());
            editingLaptop.setModel(laptop.getModel());
            editingLaptop.setRam(laptop.getRam());
            editingLaptop.setStorage(laptop.getStorage());
            editingLaptop.setMac_address(laptop.getMac_address());
            laptopRepository.save(editingLaptop);
            return "Laptop edited";
        }
        return "Laptop not found";
    }

}
