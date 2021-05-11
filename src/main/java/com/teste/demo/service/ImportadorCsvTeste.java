package com.teste.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvBindByName;
import com.teste.demo.model.TesteCsv;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImportadorCsvTeste {
    public void importarCsvTeste(MultipartFile arquivoCsv) throws Exception {
        if (!arquivoCsv.getContentType().equalsIgnoreCase("text/csv")) {// verifica a extensão do arquivo
            throw new Exception("Arquivo inválido, apenas arquivos csv são permitidos");
        }

        try {
            List<List<String>> record = new ArrayList<List<String>>();

            File arquivoCsvConvertido = conversaoDeMultipartParaFile(arquivoCsv);

            Reader reader = Files.newBufferedReader(arquivoCsvConvertido.toPath());

            CSVParser parser = new CSVParserBuilder().withSeparator(';').withIgnoreQuotations(true).build();

            CSVReader readerCsv = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();

            String[] linha;
            List<String[]> data = new ArrayList<>();
            Boolean eParaLer = false;
            while ((linha = readerCsv.readNext()) != null) {
                if (!eParaLer) {
                    eParaLer = this.isLinhaValidaParaLer(linha);
                } else if (eParaLer) {
                    log.info(linha[0]);
                    data.add(linha);
                    eParaLer = !this.isLinhaVazia(linha);
                }

            }

            log.info(String.valueOf(data.size()));

            // while ((values = reader.readNext()) != null) {
            // log.info(values[0]);
            // }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public File conversaoDeMultipartParaFile(MultipartFile file) throws Exception {
        File arquivoConvertido = new File(file.getOriginalFilename());
        arquivoConvertido.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(arquivoConvertido);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return arquivoConvertido;
    }

    public boolean isLinhaValidaParaLer(String[] linha) {
        TesteCsv teste = new TesteCsv();
        if (linha.length == 0 || linha == null) {
            return false;
        }

        for (Field campo : teste.getClass().getDeclaredFields()) {
            campo.setAccessible(true);
            CsvBindByName csv = campo.getDeclaredAnnotation(CsvBindByName.class);
            if (csv != null && csv.column() != null && !Arrays.asList(linha).contains(csv.column())) {
                return false;
            }
        }

        return true;
    }

    public boolean isLinhaVazia(String[] linha) {
        if (linha == null)
            return false;
        for (String campo : linha) {
            if (!campo.isBlank() && !campo.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
