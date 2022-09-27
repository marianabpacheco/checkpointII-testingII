# checkpointII-testingII

# Projeto Final

- Objetivo <br>
 Criar um projeto completo de Testes Automatizados utilizando Java e Selenium, com Suítes, Tags, e Reports, validando também uma API RestAssured. E pra finalizar faremos uma integração com Jenkins (opcional)
Site a ser testado: Para Bank

- Pré-condições: Abrir o site <br>
Título do Caso de Teste: Processo de registro, abertura de nova conta, visão geral das contas, transferir fundos, atividade da conta, para todas as etapas de Testes Front-end

- Testes Front-end: 
- Registro <br>
 Clicar em <Register>
 Preencher o formulário de registro com os dados exigidos
Clicar em <Register> novamente 
Verificar se o texto “Your account was created successfully. You are now logged in.” está visível na tela

- Abertura de nova conta <br>
Clicar em <Open New Account>
Em tipo de conta “What type of Account would you like to open?” selecionar a opção <SAVINGS>
Clicar am <Open New Account> 
Verificar se o texto “Congratulations, your account is now open.” está visível na tela
Visão geral das contas
Clicar em <Accounts Overview>
Verificar se o texto “*Balance includes deposits that may be subject to holds” está visível na tela

- Transferir Fundos <br>
Clicar em <Transfer Funds>
Verificar se o texto “Transfer Funds” está visível na tela
No campo <Amount: $> preencher o valor a ser transferido
No campo <From account #> selecionar uma conta
No campo <to account #> selecionar uma conta diferente da conta anterior
Clicar em <Transfer>
Verificar se o texto “Transfer Complete!” está visível na tela

- Atividades da conta (todos os meses) <br>
Clicar <Accounts Overview>
Verificar se o texto “*Balance includes deposits that may be subject to holds” está visível na tela
Clicar am em uma conta na coluna <Account> 
Verificar se o texto “Account Details” está visível na tela
Em “Account Activity” clicar em <Activity Period:> e selecionar “All”
Em “Account Activity” clicar em <Type:> e selecionar “All”
Clicar em <Go>

- Testes back-end API Rest:
Validação de status code 200 para todas as etapas de Testes Front-end <br>
 Registro URL: https://parabank.parasoft.com/parabank/register.htm <br>
 Abertura de nova conta URL: https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=xxxxx <br>
Visão geral das contas URL: https://parabank.parasoft.com/parabank/overview.htm <br> 
Transferir Fundos URL: https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx <br>
Atividades da conta (todos od meses) URL: https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All <br>
