package com.jef.js2p2.controller;

import com.jef.js2p2.dto.PersonSportDTO;
import com.jef.js2p2.entity.Sport;
import com.jef.js2p2.service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportsController {

    private SportsService sportsService;

    @Autowired
    public SportsController() {
        this.sportsService = new SportsService();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findAllSports() {
        return new ResponseEntity<>(sportsService.findSports(null), HttpStatus.OK);
    }

    @GetMapping("/findSports/{sport}")
    public ResponseEntity<List<Sport>> findSports(@PathVariable(required = false) String sport) {
        return new ResponseEntity<>(sportsService.findSports(sport), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonSportDTO>> findSportsPersons() {
        List<PersonSportDTO> personSportDTOList = sportsService.findSportsPersons();
        return new ResponseEntity<>(personSportDTOList, HttpStatus.OK);
    }
}
