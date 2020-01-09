Feature: Validar Simulação FAP

  Background: Acessar a Pagina do Blog SOC
    Given Que eu esteja no site do SOC

    Scenario: Simular FAP com Sucesso
      When eu acessar a tela do FAP
      And Preencher os campos necessarios
      Then Eu clico no botao Simular FAP e recebo as informacoes

        Scenario: Validar Obrigatoriedade do Campo FAP
          When eu acessar a tela do FAP
          And Preecher os campos exceto FAP
          Then Eu clico no botao Simular FAP e recebo uma mensagem avisando que o campo FAP é obrigatorio

          Scenario: Validar Obrigatoriedade do Campo RAT
            When eu acessar a tela do FAP
            And Preecher os campos exceto RAT
            Then Eu clico no botao Simular FAP e recebo uma mensagem avisando que o campo RAT é obrigatorio

            Scenario: Validar Obrigatoriedade do Campo Projecao de Massa Salarial
              When eu acessar a tela do FAP
              And Preecher os campos exceto Projecao de Massa Salarial
              Then Eu clico no botao Simular FAP e recebo uma mensagem avisando que o campo Projecao de Massa Salarial é obrigatorio

              Scenario: Validar Botão Limpar Formulario
                When eu acessar a tela do FAP
                And Preencher os campos necessarios
                Then Eu clico no botao Limpar Formulario e os Campos devem ficar vazios