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
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.service.ResearchService;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@RestController
@RequestMapping("/gis")
@Api(tags = "GIS controller")
@Validated
@RequiredArgsConstructor
public class GisController {

    private final ResearchService researchService;

    @GetMapping("/all")
    @ApiOperation(value = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Collection<Group>> findAll() {
        Collection<Group> all = researchService.findAll();
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
    public ResponseEntity<Group> get(@PositiveOrZero @PathVariable long id) {
        return ResponseEntity.of(researchService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Save new valid Gis")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Group create(@Valid @RequestBody Group newGis) {
        return researchService.save(newGis);
    }

    @PutMapping
    @ApiOperation(value = "Update existed Gis with new data")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Group update(@Valid @RequestBody Group gisToUpdate) {
        return researchService.update(gisToUpdate);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Gis by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PositiveOrZero @PathVariable long id) {
        researchService.deleteById(id);
    }
}
