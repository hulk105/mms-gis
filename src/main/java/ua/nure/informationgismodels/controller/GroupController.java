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
import ua.nure.informationgismodels.dto.UpdateGroupDto;
import ua.nure.informationgismodels.entity.Group;
import ua.nure.informationgismodels.service.GroupService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Collection;

@RestController
@RequestMapping("/group")
@Api(tags = "Group controller")
@Validated
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/all")
    @ApiOperation(value = "Find all")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<Collection<Group>> findAll() {
        Collection<Group> all = groupService.findAll();
        return !all.isEmpty()
                ? new ResponseEntity<>(all, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Group by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Group> get(@PositiveOrZero @PathVariable long id) {
        return ResponseEntity.of(groupService.findById(id));
    }

    @GetMapping
    @ApiOperation(value = "Find Group by section")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Collection<Group>> getBySection(
            @NotNull @RequestParam Group.Section section) {
        Collection<Group> all = groupService.findBySection(section);
        return !all.isEmpty()
                ? new ResponseEntity<>(all, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ApiOperation(value = "Save new valid Group")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.CREATED)
    public Group create(@Valid @RequestBody Group newGis) {
        return groupService.save(newGis);
    }

    @PatchMapping
    @ApiOperation(value = "Update existed Group with new data")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Group update(@Valid @RequestBody UpdateGroupDto dto) {
        return groupService.update(dto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Group by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Accepted"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PositiveOrZero @PathVariable long id) {
        groupService.deleteById(id);
    }
}
