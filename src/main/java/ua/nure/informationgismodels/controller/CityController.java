package ua.nure.informationgismodels.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.informationgismodels.dao.CityRepository;
import ua.nure.informationgismodels.entity.City;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/city")
@Api(tags = "City controller")
@RequiredArgsConstructor
public class CityController {

    private final CityRepository cityRepository;

    @GetMapping("/all")
    @ApiOperation(value = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Collection<City>> findAll() {
        List<City> all = cityRepository.findAll();
        return !all.isEmpty()
                ? new ResponseEntity<>(all, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
