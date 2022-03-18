package com.jef.js2p2.service;

import com.jef.js2p2.dto.PersonSportDTO;
import com.jef.js2p2.entity.Person;
import com.jef.js2p2.entity.Sport;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class SportsService {

    private List<Sport> sports = new ArrayList<>();
    private List<Person> people = new ArrayList<>();

    public SportsService() {
        sports.add(new Sport("Futebol", 22L));
        sports.add(new Sport("Futebol", 19L));
        sports.add(new Sport("Volei", 12L));
        sports.add(new Sport("Basquete", 32L));
        sports.add(new Sport(null, null));

        people.add(new Person("Jhon", "Travolta", 25));
        people.add(new Person("Brad", "Pitt", 21));
        people.add(new Person("Peter", "Travolta", 27));
        people.add(new Person("Mary", "Jay", 22));
        people.add(new Person("Douglas", "McGregor", 21));

    }

    public List<Sport> findSports(String sport) {
        if (sport != null)
            return sports.stream().filter(s -> s.getName().equals(sport)).findFirst().stream().collect(Collectors.toList());

        return this.getSports().stream().filter(s -> s.getName()!=null).collect(Collectors.toList());
    }

    public List<PersonSportDTO> findSportsPersons() {
        List<PersonSportDTO> personSportDTOList = new ArrayList<>();

        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).getName() != null)
                personSportDTOList.add(new PersonSportDTO(people.get(i).getName(), people.get(i).getLastName(), sports.get(i).getName()));
        }
        return personSportDTOList;
    }
}
