Feature: Validar Funcionalidade de Busca do Blog SOC
  Background: Acessar a página do SOC Blog
    Given Que eu abra o navegador e o site

  Scenario: Busca Realizada com Sucesso
    When Eu preencher o campo e pesquisar
    Then Devo ser encaminhado para pagina com o resultado da pesquisa

  Scenario: Falha na Realização da Busca
    When Eu preencher o campo com valores nao existentes na base
    Then Devo ser encaminhado para pagina dizendo que a busca nao trouxe resultados

  Scenario: Validar Botão de Limpeza do Campo
    When Eu preencher o campo e clicar no botão Limpar
    Then O campo deve ficar vazio