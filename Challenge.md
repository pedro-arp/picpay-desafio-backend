Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no
sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail;

Comuns:

- Nome Completo
- CPF (unico)
- e-mail (unico)
- senha
- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários;

Lojistas

- Nome Completo
- CNPJ (unico)
- e-mail (unico)
- senha
- Lojistas só recebem transferências, não enviam dinheiro para ninguém;

Validações:

- Validar se o usuário tem saldo antes da transferência;
- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este
  mock https://util.devi.tools/api/v2/authorize para simular o serviço utilizando o verbo GET;
- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o
  dinheiro deve voltar para a carteira do usuário que envia;
- No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um
  serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este
  mock https://util.devi.tools/api/v1/notify)) para simular o envio da notificação utilizando o verbo POST;
- Este serviço deve ser RESTFul.
  POST /transfer
  Content-Type: application/json

A implementação deve seguir o contrato abaixo.

POST /transfer
Content-Type: application/json

{
"value": 100.0,
"payer": 4,
"payee": 15
}

(Conhecimentos intermediários de construção de projetos manuteníveis:)

[//]: # ()

[//]: # (Aderência a recomendações de implementação como as PSRs)

[//]: # (Aplicação e conhecimentos de SOLID)

[//]: # (Identificação e aplicação de Design Patterns)

[//]: # (Noções de funcionamento e uso de Cache)

[//]: # (Conhecimentos sobre conceitos de containers &#40;Docker, Podman etc&#41;)

[//]: # (Documentação e descrição de funcionalidades e manuseio do projeto)

[//]: # (Implementação e conhecimentos sobre testes de unidade e integração)

[//]: # (Identificar e propor melhorias)

[//]: # (Boas noções de bancos de dados relacionais)

[//]: # (Aptidões para criar e manter aplicações de alta qualidade:)

[//]: # ()

[//]: # (Aplicação de conhecimentos de observabilidade)

[//]: # (Utlização de CI para rodar testes e análises estáticas)

[//]: # (Conhecimentos sobre bancos de dados não-relacionais)

[//]: # (Aplicação de arquiteturas &#40;CQRS, Event-sourcing, Microsserviços, Monolito modular&#41;)

[//]: # (Uso e implementação de mensageria)

[//]: # (Noções de escalabilidade)

[//]: # (Boas habilidades na aplicação do conhecimento do negócio no software)

[//]: # (Implementação margeada por ferramentas de qualidade &#40;análise estática, PHPMD, PHPStan, PHP-CS-Fixer etc&#41;)

[//]: # (Noções de PHP assíncrono)

(O que será um Diferencial)

[//]: # (Uso de Docker)

[//]: # (Uma cobertura de testes consistente)

[//]: # (Uso de Design Patterns)

[//]: # (Documentação)

[//]: # (Proposta de melhoria na arquitetura)

[//]: # (Ser consistente e saber argumentar suas escolhas)

[//]: # (Apresentar soluções que domina)

[//]: # (Modelagem de Dados)

[//]: # (Manutenibilidade do Código)

[//]: # (Tratamento de erros)

[//]: # (Cuidado com itens de segurança)

[//]: # (Arquitetura &#40;estruturar o pensamento antes de escrever&#41;)

[//]: # (Carinho em desacoplar componentes &#40;outras camadas, service, repository&#41;)