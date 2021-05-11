package com.teste.demo.model;

import java.time.LocalDate;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class TesteCsv {
    // @CsvBindByName(column = "Banco")
    private Long banco;

    @CsvBindByName(column = "Proposta")
    private String propostaNumero;

    @CsvBindByName(column = "CPF")
    private String clienteCpf;

    @CsvBindByName(column = "Nome do Cliente")
    private String clienteNome;

    @CsvBindByName(column = "Data da Proposta")
    private LocalDate propostaData;

    @CsvBindByName(column = "Data do Contrato")
    private LocalDate contratoData;

    // @CsvBindByName(column = "Prazo")
    private int prazoQuantidade;

    @CsvBindByName(column = "Código Promotora")
    private Long promotoraCodigo;

    @CsvBindByName(column = "Nome Promotora")
    private String promotoraNome;

    @CsvBindByName(column = "Código Comissionado")
    private Long comissionadoCodigo;

    @CsvBindByName(column = "Nome Comissionado")
    private String comissionadoNome;

    @CsvBindByName(column = "Código Tabela")
    private String comissaoCodigo;

    @CsvBindByName(column = "Descrição Tabela")
    private String comissaoNome;

    @CsvBindByName(column = "Valor Saque")
    private Double valorSaqueOuFinanciado;

    @CsvBindByName(column = "Valor Saque Base de Cálculo")
    private Double valorBaseCalculo;

    @CsvBindByName(column = "Valor Comissao")
    private Double comissaoValor;

    @CsvBindByName(column = "% Comissão")
    private Double comissaoPercentual;

    @CsvBindByName(column = "Número da Parcela Paga")
    private int comissaoParcela;

    @CsvBindByName(column = "Valor Total da Comissão Manutenção")
    private Double valorTotalComissaoManut;

    @CsvBindByName(column = "Expectativa de Adiantamento")
    private Double expectativaAdiantamento;

    @CsvBindByName(column = "Data Evento")
    private LocalDate dataEvento;

    @CsvBindByName(column = "Tipo Operação")
    private String tipoOperacao;

    @CsvBindByName(column = "Tipo Pagamento")
    private String tipoPagamento;

    @CsvBindByName(column = "Data Credito Comissão")
    private LocalDate comissaoDataCredito;

    @CsvBindByName(column = "Tipo de Comissão")
    private String comissaoTipo;

    @CsvBindByName(column = "Data Vcto Primeira Parcela")
    private LocalDate prazoPrimeiraParcela;

    @CsvBindByName(column = "Data Vcto Última Parcela")
    private LocalDate prazoUltimaParcela;

    @CsvBindByName(column = "Seguro")
    private String seguro;

    @CsvBindByName(column = "Valor Margem RMC")
    private Double valorMargemRmc;

    @CsvBindByName(column = "Observação")
    private String observacao;

    @CsvBindByName(column = "Código Certificado")
    private String certificadoCodigo;

    @CsvBindByName(column = "Nome Certificado")
    private String certificadoNome;

    @CsvBindByName(column = "Tipo de Formalizacao")
    private String formalizacao;

    @CsvBindByName(column = "Tipo de Liberação")
    private String liberacaoTipo;

    @CsvBindByName(column = "Banco da Liberação")
    private int liberacaoBanco;

    // @CsvBindByName(column = "Taxa AP")
    private Double taxaAp;

    // @CsvBindByName(column = "Antecipação")
    private Double valorAntecipacao;

    // @CsvBindByName(column = "Status Variação")
    private String statusVariacao;

    // @CsvBindByName(column = "Status Contrato")
    private String statusContrato;

}
