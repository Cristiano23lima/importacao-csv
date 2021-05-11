package com.teste.demo.controller;

import com.teste.demo.service.ImportadorCsvTeste;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ControllerTeste {
    private final ImportadorCsvTeste importador;

    @PostMapping(value = "/importar-csv", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public void importarCsv(@RequestPart(name = "file") MultipartFile file) throws Exception {
        try {
            this.importador.importarCsvTeste(file);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
