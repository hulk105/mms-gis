package ua.nure.informationgismodels.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.nure.informationgismodels.entity.Gis;
import ua.nure.informationgismodels.service.GisService;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@RestController
@RequestMapping("/gis")
@Api(tags = "GIS controller")
@Validated
@RequiredArgsConstructor
public class GisController {

    private final GisService gisService;

    @GetMapping("/all")
    @ApiOperation(value = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Collection<Gis>> findAll() {
        Collection<Gis> all = gisService.findAll();
        return !all.isEmpty()
                ? new ResponseEntity<>(all, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Gis by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Gis> get(@PositiveOrZero @PathVariable long id) {
        return ResponseEntity.of(gisService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Save new valid Gis")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Gis create(@Valid @RequestBody Gis newGis) {
        return gisService.save(newGis);
    }

    @PutMapping
    @ApiOperation(value = "Update existed Gis with new data")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Gis update(@Valid @RequestBody Gis gisToUpdate) {
        return gisService.update(gisToUpdate);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Gis by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PositiveOrZero @PathVariable long id) {
        gisService.removeById(id);
    }
}
