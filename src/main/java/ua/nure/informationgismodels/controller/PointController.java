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
import ua.nure.informationgismodels.dto.CreatePointDto;
import ua.nure.informationgismodels.dto.UpdatePointDto;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.entity.Point;
import ua.nure.informationgismodels.service.PointService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@RestController
@RequestMapping("/point")
@Api(tags = "Point controller")
@Validated
@RequiredArgsConstructor
public class PointController {

    private final PointService pointService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Point by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Point> get(@PositiveOrZero @PathVariable long id) {
        return ResponseEntity.of(pointService.findById(id));
    }

    @GetMapping
    @ApiOperation(value = "Find Point by section")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<Point>> getBySection(
            @NotNull @RequestParam Group.Section section) {
        Collection<Point> all = pointService.findBySection(section);
        return !all.isEmpty()
                ? new ResponseEntity<>(all, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ApiOperation(value = "Save new valid Point")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Point create(@Valid @RequestBody CreatePointDto dto) {
        return pointService.save(dto);
    }

    @PatchMapping
    @ApiOperation(value = "Update existed Point with new data")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Point update(@Valid @RequestBody UpdatePointDto dto) {
        return pointService.update(dto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Point by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PositiveOrZero @PathVariable long id) {
        pointService.deleteById(id);
    }
}
