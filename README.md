# Nexus API 🤍
### _Solução Oficial da Nexus_
> <small>Todos os direitos reservados para _Nexus ©_<small/>


## Nexus Rest 💻
_Documentação Oficial da API Rest do aplicativo Nexus. Com essa API você será capaz de consumir todos os serviços e dados direto do noss banco de dados. É importante lembrar que essa documentação específica do github abordará apenas os endpoints de acesso a serviços e dados mais importantes da Nexus. Para usufluir da API completa acesse: https://doc.nexus.com/api_ <br/> <br/>
> <small>_Equipe Smash Code! ❤_<small/>
<hr/>
</br> 
  
  
  
  
  
  
<!-- Introdução (Inicio) -->
  
  
  
  
  
<!-- Business Domain (Incio) -->
# Business Rest 👨‍💼
- Criar business account
- Detalhar business account
- Listar business accounts
- Editar business account
- Desativar business account
</br>

## Cadastro de Business Account 🔨

<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/business**

**Exemplo de Entrada** 

```js
{
    name: "Plusoft",
    email: "plusoft.contact@gmail.com",
    password: "exemple123",
    cntNumber: "+5511955367753",
    wppNumber: "+5511955367753"
}
```

| Campo     | Obrigatório | Tipo  | Descrição                                     |
|-----------|-------------|-------|-----------------------------------------------|
| name      | sim         | texto | nome formal da empresa.                       |
| email     | sim         | texto | email unico profissional da empresa.          |
| passoword | sim         | texto | senha de identificação da empresa             |
| cntNumber | sim         | texto | número de contato da empresa                  |
| wppNumber | sim         | texto | número de atendimento do whatsapp da empresa. |

**Exemplo de Resposta**

```js
{
    id: 1,
    account_type: "BUSINESS",
    data_account: {
      name: "Plusoft",
      email: "plusoft.contact@gmail.com"
    },
    numbers: {
      cntNumber: "+5511955367753",
      wppNumber: "+5511955367753"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | a conta foi criada com sucesso.      |
|400     | Os dados enviados são inválidos.     |


--- 


## Detalhar Business Account 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    account_type: "BUSINESS",
    data_account: {
      name: "Plusoft",
      email: "plusoft.contact@gmail.com"
    },
    numbers: {
      cntNumber: "+5511955367753",
      wppNumber: "+5511955367753"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```


### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | a conta foi criada com sucesso.      |
|400     | Os dados enviados são inválidos.     |


--- 


## Listar Business Accounts 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business**

**Exemplo de Resposta** 
```js
[
    {
      id: 1,
      account_type: "BUSINESS",
      data_account: {
        name: "Plusoft",
        email: "plusoft.contact@gmail.com"
      },
      numbers: {
        cntNumber: "+5511955367753",
        wppNumber: "+5511955367753"
      },
      timestamps: {
        createdAt: "2022-12-10T05:47:08.644",
        updatedAt: "2022-12-10T05:47:08.644"  
      }
    },
    {
      id: 2,
      account_type: "BUSINESS",
      data_account: {
        name: "FIAP",
        email: "contato@fiap.com.br"
      },
      numbers: {
        cntNumber: "+5511955367753",
        wppNumber: "+5511955367753"
      },
      timestamps: {
        createdAt: "2022-12-10T05:47:08.644",
        updatedAt: "2022-12-10T05:47:08.644"  
      }
    },
]
```
### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados das contas foram retornados.    |


--- 

