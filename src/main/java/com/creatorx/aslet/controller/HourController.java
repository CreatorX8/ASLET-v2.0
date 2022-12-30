package com.creatorx.aslet.controller;

import com.creatorx.aslet.dto.HourCreateDto;
import com.creatorx.aslet.dto.HourDto;
import com.creatorx.aslet.service.HourService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class HourController {
    @Autowired
    private HourService hourService;

    @PostMapping("/hour")
    public ResponseEntity<HourDto> createHour(@RequestBody @Valid HourCreateDto newHour) {
        return ResponseEntity.ok(hourService.createHour(newHour));
    }

    @GetMapping("/hours")
    public ResponseEntity<List<HourDto>> getAllHours() {
        return ResponseEntity.ok(hourService.getAllHours());
    }

    @GetMapping("/hour/{id}")
    public ResponseEntity<HourDto> getHourById(@PathVariable Long id) {
        return ResponseEntity.ok(hourService.getHourById(id));
    }

    @PutMapping("/hour/{id}")
    public ResponseEntity<HourDto> updateHour(@RequestBody @Valid HourDto updatedHour, @PathVariable Long id) {
        return ResponseEntity.ok(hourService.updateHour(updatedHour, id));
    }

    @DeleteMapping("/hour/{id}")
    public ResponseEntity deleteHour(@PathVariable Long id) {
        hourService.deleteHour(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
