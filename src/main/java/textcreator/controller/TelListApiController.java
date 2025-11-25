package textcreator.controller;

import org.springframework.web.bind.annotation.*;
import textcreator.entity.TelListEntity;
import textcreator.service.TelListService;

import java.util.List;

@RestController
@RequestMapping("/api/tellist")
public class TelListApiController {

    private final TelListService telListService;

    public TelListApiController(TelListService telListService) {
        this.telListService = telListService;
    }

    @GetMapping
    public List<TelListEntity> search(
            @RequestParam(required = false, defaultValue = "") String companyName,
            @RequestParam(required = false, defaultValue = "") String personName,
            @RequestParam(required = false, defaultValue = "") String telNumber
    ) {
        return telListService.searchByFields(companyName, personName, telNumber);
    }
}
