package org.kainovk.symbolcounterservice.controller;

import lombok.RequiredArgsConstructor;
import org.kainovk.symbolcounterservice.dto.TextRequest;
import org.kainovk.symbolcounterservice.service.SymbolCounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SymbolCounterController {

    private final SymbolCounterService symbolCounterService;

    @GetMapping("/count-symbols")
    public Map<Character, Integer> countSymbols(@RequestBody TextRequest request) {
        return symbolCounterService.countSymbols(request.getText());
    }
}
