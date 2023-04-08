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


## Editar Business Account ⚙

<!-- Endereço do recurso -->
`PUT` - **nexus/api/v1/business/{id}**

**Campos da Requisição** 
```js
{
    name: "Plusoft",
    email: "plusoft.contact@gmail.com",
    cntNumber: "+5511955367753",
    wppNumber: "+5511955367753"
}
```

**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações                                    |
|-----------|----------|--------------------------------------------------|
| name      | sim      | o nome formal da empresa é editável.             |
| email     | sim      | o email da empresa é editável.                   |
| cntNumber | sim      | o numero de contato da empresa é editável.       |
| wppNumber | sim      | o numero de atendimento do whatsapp é editável.  |


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

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da conta foram retornados.      |
|400     | Não existe uma conta com esse ID.        |


---


## Deletar Business Account 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/business/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "A conta foi desativada com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da conta foram retornados.      |
|400     | Não existe uma conta com esse ID.        |


</br>
</br>
</br>

---

</br>
</br>
</br> 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Business Domain (Incio) -->
# Business Profile Rest 👨‍💼
- Criar business profile
- Detalhar business profile
- Listar business profiles
- Editar business profile
- Desativar business profile
</br>

## Cadastro de Business Profile 🔨

<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/business/profile**

**Exemplo de Entrada** 

```js
{
    businessId: 1 // FK 
    bussName: "Plusoft 🧡",
    bussImg: "plusoft.png",
    shortDesc: "Trabalhamos diariamente para te ajudar a satisfazer o que mais importa na sua cadeia de valor: as pessoas. Escutamos, discutimos, propomos e caminhamos com você para transformar desafios nas melhores experiências."
}
```

| Campo       | Obrigatório | Tipo    | Descrição                                           |
|-------------|-------------|---------|-----------------------------------------------------|
| businessId  | sim         | numero  | esse campo é a FK que identifica a empresa.         |
| bussName    | sim         | texto   | nome informal do perfil da empresa.                 |
| bussImg     | sim         | texto   | nome da imagem do perfil da empresa com a extenção. |
| shortDesc   | não         | texto   | uma descriçao curta do perfil da empresa.           |

**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_profile: {
       bussName: "Plusoft 🧡",
       bussImg: "plusoft.png",
      shortDesc: "Trabalhamos diariamente para te ajudar a satisfazer o que mais importa na sua cadeia de valor: as pessoas. Escutamos, discutimos, propomos e caminhamos com você para transformar desafios nas melhores experiências.",
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
|201     | o perfil foi criada com sucesso.     |
|400     | Os dados enviados são inválidos.     |


--- 


## Detalhar Business Profile 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/profile/{id}**

**Exemplo de Resposta**

```js

 {
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_profile: {
       bussName: "Plusoft 🧡",
       bussImg: "plusoft.png",
      shortDesc: "Trabalhamos diariamente para te ajudar a satisfazer o que mais importa na sua cadeia de valor: as pessoas. Escutamos, discutimos, propomos e caminhamos com você para transformar desafios nas melhores experiências.",
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
 }

```


### **Códigos da Resposta**

| Código | Descrição                              |
|--------|----------------------------------------|
|200     | Os dados do perfil foram retornados.   |
|400     | Não existe um perfil com esse ID.      | 


--- 


## Listar Business Profile 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/profile**

**Exemplo de Resposta** 
```js
[
     {
        id: 1,
        business: {
          businessId: 1,
          name: "Plusoft"
        },
       data_profile: {
          bussName: "Plusoft 🧡",
          bussImg: "plusoft.png",
          shortDesc: "Trabalhamos diariamente para te ajudar a satisfazer o que mais importa na sua cadeia de valor: as pessoas. Escutamos, discutimos, propomos e caminhamos com você para transformar desafios nas melhores experiências.",
        },
        timestamps: {
          createdAt: "2022-12-10T05:47:08.644",
          updatedAt: "2022-12-10T05:47:08.644"  
        }
    },
     {
        id: 1,
        business: {
          businessId: 3,
          name: "Smash Code!"
        },
        data_profile: {
           bussName: "Smash Code! 🤍💻",
           bussImg: "smash.png",
          shortDesc: "Sempere inovando e causando a experiência!",
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
|200     | Os dados dos perfis foram retornados.    |


--- 


## Editar Business Profile ⚙

<!-- Endereço do recurso -->
`PUT` - **nexus/api/v1/business/profile/{id}**

**Campos da Requisição** 
```js
{
    bussName: "Plusoft 🧡",
    bussImg: "plusoft.png",
    shortDesc: "Trabalhamos diariamente para te ajudar a satisfazer o que mais importa na sua cadeia de valor: as pessoas. Escutamos, discutimos, propomos e caminhamos com você para transformar desafios nas melhores experiências."
}
```

**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações                                        |
|-----------|----------|------------------------------------------------------|
| bussName  | sim      | o nome informal do perfil da empresa é editável.     |
| bussImg   | sim      | a imagem de perfil da empresa é editável.            |
| shortDesc | sim      | a descrição curta do perfil da empresa é editável.   |


**Exemplo de Resposta**

```js
{
  id: 1,
  business: {
    businessId: 1,
    name: "Plusoft"
  },
 data_profile: {
    bussName: "Plusoft 🧡",
    bussImg: "plusoft.png",
    shortDesc: "Trabalhamos diariamente para te ajudar a satisfazer o que mais importa na sua cadeia de valor: as pessoas. Escutamos, discutimos, propomos e caminhamos com você para transformar desafios nas melhores experiências.",
  },
  timestamps: {
    createdAt: "2022-12-10T05:47:08.644",
    updatedAt: "2022-12-10T05:47:08.644"  
  }
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do perfil foram retornados.     |
|400     | Não existe uma perfil com esse ID.       |


---


## Deletar Business Profile 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/business/profile/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "O perfil da conta Plusoft foi desativado com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do perfil foram retornados.     |
|400     | Não existe um perfil com esse ID.        |


</br>
</br>
</br>

---

</br>
</br>
</br> 
