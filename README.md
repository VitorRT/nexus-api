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

**Regras de Negócio - Edição de Profile**

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

  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Customer Domain (Incio) -->
# Customer Data Rest 👨‍💼
- Criar customer data
- Detalhar customer data
- Listar customer datas
- Desativar customer data
</br>

## Cadastro de Customer Data 🔨

<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/business/customer**

**Exemplo de Entrada** 

```js
{
    businessId: 1 // FK 
    cusName: "Paulo Silva",
    cusEmail: "paulosilvana@gmail.com",
    cusPhone: "+5511944563385",
    channelOrigin: "INSTAGRAM"
}
```

| Campo         | Obrigatório | Tipo    | Descrição                                           |
|---------------|-------------|---------|-----------------------------------------------------|
| businessId    | sim         | numero  | esse campo é a FK que identifica a empresa.         |
| cusName       | não         | texto   | nome de comunicação do cliente da empresa.          |
| cusEmail      | não         | texto   | email de comunicação do cliente da empresa.         |
| cusPhone      | não         | texto   | telefone de comunicação do cliente da empresa.      |
| channelOrigin | sim         | texto   | canal de comunicação de origem do cliente.          |

**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_customer: {
      cusName: "Paulo Silva",
      cusEmail: "paulosilvana@gmail.com",
      cusPhone: "+5511944563385",
      channelOrigin: "INSTAGRAM"
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
|201     | o cliente foi criado com sucesso.    |
|400     | Os dados enviados são inválidos.     |


--- 


## Detalhar Customer Data 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/customer/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_customer: {
      cusName: "Paulo Silva",
      cusEmail: "paulosilvana@gmail.com",
      cusPhone: "+5511944563385",
      channelOrigin: "INSTAGRAM"
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
|200     | Os dados do cliente foram retornados.  |
|400     | Não existe um cleinte com esse ID.     | 


--- 


## Listar Customer Datas 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/customer**

**Exemplo de Resposta** 
```js
[
     {
        id: 1,
        business: {
          businessId: 1,
          name: "Plusoft"
        },
        data_customer: {
          cusName: "Paulo Silva",
          cusEmail: "paulosilvana@gmail.com",
          cusPhone: "+5511944563385",
          channelOrigin: "INSTAGRAM"
        },
        timestamps: {
          createdAt: "2022-12-10T05:47:08.644",
          updatedAt: "2022-12-10T05:47:08.644"  
        }
    },
     {
        id: 2,
        business: {
          businessId: 3,
          name: "Smash Code!"
        },
        data_customer: {
          cusName: "Mirela Cunha",
          cusEmail: "mihh.cunha@gmail.com",
          cusPhone: "+5511944563385",
          channelOrigin: "WHATSAPP"
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
|200     | Os dados dos clientes foram retornados.  |


--- 


## Deletar Customer Data 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/business/customer/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "O Cliente da empresa Plusoft foi deletado com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do cliente foram retornados.    |
|400     | Não existe um perfil com esse ID.        |


</br>
</br>
</br>

---

</br>
</br>
</br> 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Communcation Channel Domain (Incio) -->
# Communcation Channel Rest 👨‍💼
- Criar communcation channel
- Detalhar communcation channel
- Listar communcation channels
- Editar communcation channel
- Desativar communcation channel
</br>

## Cadastro de Communcation Channel 🔨
 
<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/channel/comunication**

**Exemplo de Entrada** 

```js
{
    businessId: 1 // FK 
    channel: "MENSAGER",
    numberChannel: "+5511965774398",
    emailChannel: "foo@gmail.com"
}
```


| Campo           | Obrigatório | Tipo    | Descrição                                           |
|-----------------|-------------|---------|-----------------------------------------------------|
| businessId      | sim         | numero  | esse campo é a FK que identifica a empresa.         |
| numberChannel   | não         | texto   | numero de comunicação de algum canal digital.       |
| emailChannel    | não         | texto   | email de comunicação de algum canal digital         |


**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_profile: {
      channel: "MENSAGER",
      numberChannel: "+5511965774398",
      emailChannel: "foo@gmail.com"
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
|201     | a comunicação foi criada com sucesso.  |
|400     | Os dados enviados são inválidos.       |


--- 


## Detalhar Communcation Channel 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/channel/comunication/{id}**

**Exemplo de Resposta**

```js
 {
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_profile: {
      channel: "MENSAGER",
      numberChannel: "+5511965774398",
      emailChannel: "foo@gmail.com"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```


### **Códigos da Resposta**

| Código | Descrição                                    |
|--------|----------------------------------------------|
|200     | Os dados da comunicação foram retornados.    |
|400     | Não existe um perfil com esse ID.            | 


--- 


## Listar Communcation Channels 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/channel/comunication**

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
          channel: "MENSAGER",
          numberChannel: "+5511965774398",
          emailChannel: "foo@gmail.com"
        },
        timestamps: {
          createdAt: "2022-12-10T05:47:08.644",
          updatedAt: "2022-12-10T05:47:08.644"  
        }
    },
      {
        id: 1,
        business: {
          businessId: 1,
          name: "Plusoft"
        },
        data_profile: {
          channel: "INSTAGRAM",
          numberChannel: "+5511965774398",
          emailChannel: "yukari@gmail.com"
        },
        timestamps: {
          createdAt: "2022-12-10T05:47:08.644",
          updatedAt: "2022-12-10T05:47:08.644"  
        }
    },
]
```

### **Códigos da Resposta**

| Código | Descrição                                      |
|--------|------------------------------------------------|
|200     | Os dados das comnunicações foram retornados.   |


--- 


## Editar Communcation Channel ⚙

<!-- Endereço do recurso -->
`PUT` - **nexus/api/v1/channel/comunication/{id}**

**Campos da Requisição** 
```js
{
    numberChannel: "+5511965774398",
    emailChannel: "foo@gmail.com"
}
```

**Regras de Negócio - Edição de Profile**

| Campos        | Editável | Considerações                                        |
|---------------|----------|------------------------------------------------------|
| numberChannel | sim      | O numero de comunicação do canal é editável.         |
| emailChannel  | sim      | O email de comunicação do canal é editável.          |


**Exemplo de Resposta**

```js
 {
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_profile: {
      channel: "MENSAGER",
      numberChannel: "+5511965774398",
      emailChannel: "foo@gmail.com"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-12T05:47:08.644"  
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados a comunicação foram retornados. |
|400     | Não existe uma comunicação com esse ID.  |


---


## Deletar Communcation Channel 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/business/profile/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "A comunicação do canal INSTAGRAM foi desativada com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados a comunicação foram retornados. |
|400     | Não existe uma comunicação com esse ID.  |


</br>
</br>
</br>

---

</br>
</br>
</br>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Chat Domain (Incio) -->
# Chat Rest 👨‍💼
- Criar chat
- Detalhar chat
- Listar chats
- Editar chat
- Desativar chat
</br>

## Cadastro de Chat 🔨
 
<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/chat**

**Exemplo de Entrada** 

```js
{
    businessId: 1 // FK 
    chatStatus: "ABERTO",
    chatImage: "chat_default.png"
}
```


| Campo           | Obrigatório | Tipo    | Descrição                                     |
|-----------------|-------------|---------|-----------------------------------------------|
| businessId      | sim         | numero  | esse campo é a FK que identifica a empresa.   |
| chatStatus      | sim         | texto   | Situação em que o chat sem encontra.          |
| chatImage       | sim         | texto   | Nome da imagem do chat com a extensão.        |


**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_chat: {
      chatStatus: "ABERTO",
      chatImage: "chat_default.png"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                        |
|--------|----------------------------------|
|201     | o chat foi criada com sucesso.   |
|400     | Os dados enviados são inválidos. |


--- 


## Detalhar Chat 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/chat/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_chat: {
      chatStatus: "ABERTO",
      chatImage: "chat_default.png"
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
|200     | Os dados do chat foram retornados.   |
|400     | Não existe um chat com esse ID.      | 


--- 


## Listar Communcation Channels 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/chat**

**Exemplo de Resposta** 
```js
[
       {
          id: 1,
          business: {
            businessId: 1,
            name: "Plusoft"
          },
          data_chat: {
            chatStatus: "ABERTO",
            chatImage: "chat_default.png"
          },
          timestamps: {
            createdAt: "2022-12-10T05:47:08.644",
            updatedAt: "2022-12-10T05:47:08.644"  
          }
      },
      {
        id: 1,
        business: {
          businessId: 1,
          name: "Plusoft"
        },
        data_chat: {
          chatStatus: "FECHADO",
          chatImage: "chat_default.png"
        },
        timestamps: {
          createdAt: "2022-12-10T05:47:08.644",
          updatedAt: "2022-12-10T05:47:08.644"  
      }
  }
]
```

### **Códigos da Resposta**

| Código | Descrição                              |
|--------|----------------------------------------|
|200     | Os dados dos chats foram retornados.   |


--- 


## Editar Chat ⚙

<!-- Endereço do recurso -->
`PUT` - **nexus/api/v1/chat/{id}**

**Campos da Requisição** 
```js
{
    chatStatus: "ABERTO",
}
```

**Regras de Negócio - Edição de Profile**

| Campos      | Editável | Considerações                    |
|-------------|----------|----------------------------------|
| chatStatus  | sim      | A situação do chat é editável.   |


**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    data_chat: {
      chatStatus: "ABERTO",
      chatImage: "chat_default.png"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                          |
|--------|------------------------------------|
|200     | Os dados do chat foram retornados. |
|400     | Não existe um chat com esse ID.    |


---


## Deletar Communcation Channel 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/chat/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "O Chat foi desativado com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do chat foram retornados.       |
|400     | Não existe um chat com esse ID.          |


</br>
</br>
</br>

---

</br>
</br>
</br>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Chat Domain (Incio) -->
# Dino Bot Rest 👨‍💼
- Criar um dino bot
- Ativar dino
- Desativar dino
</br>

## Cadastro de um Dino 🔨
 
<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/dino**

**Exemplo de Entrada** 

```js
{
    chatId: 1 // FK 
    dinoOn: true,
    dinoItents: "PURCHASE"
}
```


| Campo           | Obrigatório | Tipo      | Descrição                                     |
|-----------------|-------------|-----------|-----------------------------------------------|
| chatId          | sim         | numero    | esse campo é a FK que identifica o chat.      |
| dinoOn          | sim         | boolean   | flag de ativação do dino bot.                 |
| dinoItents      | sim         | texto     | intenções do dino bot na conversa.            |


**Exemplo de Resposta**

```js
{
    id: 1,
    chat: {
      chatId: 1
    },
    data_profile: {
      dinoOn: true,
      dinoItents: "PURCHASE"
    },
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
|201     | o dino foi criado com sucesso.         |
|400     | Os dados enviados são inválidos.       |


--- 


## Detalhar Dino 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/dino/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    chat: {
      chatId: 1
    },
    data_profile: {
      dinoOn: true,
      dinoItents: "PURCHASE"
    },
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
|200     | Os dados do chat foram retornados.     |
|400     | Não existe um chat com esse ID.        | 


--- 


## Listar Communcation Channels 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/dino/{id}**

**Exemplo de Resposta** 
```js
[
      {
          id: 1,
          chat: {
            chatId: 1
          },
          data_profile: {
            dinoOn: true,
            dinoItents: "PURCHASE"
          },
          },
          timestamps: {
            createdAt: "2022-12-10T05:47:08.644",
            updatedAt: "2022-12-10T05:47:08.644"  
          }
      },
      {
        id: 1,
        chat: {
          chatId: 3
        },
        data_profile: {
          dinoOn: true,
          dinoItents: "PURCHASE"
        },
        },
        timestamps: {
          createdAt: "2022-12-10T05:47:08.644",
          updatedAt: "2022-12-10T05:47:08.644"  
        }
    }
]
```

### **Códigos da Resposta**

| Código | Descrição                              |
|--------|----------------------------------------|
|200     | Os dados dos chats foram retornados.   |


--- 


## Editar Chat ⚙

<!-- Endereço do recurso -->
`PUT` - **nexus/api/v1/dino/{id}**

**Campos da Requisição** 
```js
{
    dinoOn: true,
    dinoItents: "PURCHASE"
}
```

**Regras de Negócio - Edição de Profile**

| Campos      | Editável | Considerações                                  |
|-------------|----------|------------------------------------------------|
| dinoOn      | sim      | A flag da ativação do dino é editável.         |
| dinoItents  | sim      | A intenção do dino é editável.                 |


**Exemplo de Resposta**

```js
{
    id: 1,
    chat: {
      chatId: 1
    },
    data_profile: {
      dinoOn: true,
      dinoItents: "PURCHASE"
    },
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
|200     | Os dados do chat foram retornados.     |
|400     | Não existe um chat com esse ID.        | 


</br>
</br>
</br>

---

</br>
</br>
</br>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Chat Domain (Incio) -->
# Business Message Rest 👨‍💼
- Criar business message
- Detalhar business message
- Listar business messages
- Desativar business message
</br>

## Cadastro de Business Message 🔨
 
<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/business/message**

**Exemplo de Entrada** 

```js
{
    businessId: 1, // FK 1
    chatId: 2, // FK 2
    msgContent: "Teste de mensagem",
    msgType: "TEXT"
}
```


| Campo           | Obrigatório | Tipo    | Descrição                                     |
|-----------------|-------------|---------|-----------------------------------------------|
| businessId      | sim         | numero  | esse campo é a FK que identifica a empresa.   |
| chatId          | sim         | numero  | esse campo é a FK que identifica o chat.      |
| msgContent      | sim         | texto   | Conteudo da mensagem enviada.                 |
| msgType         | sim         | texto   | Tipo do conteudo da mensagem enviada.         |


**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    chat: {
      chatId: 3,
    },
    data_message: {
      msgContent: "Teste de mensagem",
      msgType: "TEXT"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                          |
|--------|------------------------------------|
|201     | A mensagem foi criada com sucesso. |
|400     | Os dados enviados são inválidos.   |


--- 


## Detalhar Business Message 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/message/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    business: {
      businessId: 1,
      name: "Plusoft"
    },
    chat: {
      chatId: 3,
    },
    data_message: {
      msgContent: "Teste de mensagem",
      msgType: "TEXT"
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
|200     | Os dados da mensagem foram retornados.   |
|400     | Não existe uma mensagem com esse ID.     | 


--- 


## Listar Business Messages 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/business/message**

**Exemplo de Resposta** 
```js
[
       {
          id: 1,
          business: {
            businessId: 1,
            name: "Plusoft"
          },
          chat: {
            chatId: 3,
          },
          data_message: {
            msgContent: "Teste de mensagem",
            msgType: "TEXT"
          },
          timestamps: {
            createdAt: "2022-12-10T05:47:08.644",
            updatedAt: "2022-12-10T05:47:08.644"  
          }
      },
      {
          id: 2,
          business: {
            businessId: 1,
            name: "Plusoft"
          },
          chat: {
            chatId: 3,
          },
          data_message: {
            msgContent: "Olá!",
            msgType: "TEXT"
          },
          timestamps: {
            createdAt: "2022-12-10T05:47:08.644",
            updatedAt: "2022-12-10T05:47:08.644"  
          }
      }
]
```

### **Códigos da Resposta**

| Código | Descrição                                  |
|--------|--------------------------------------------|
|200     | Os dados das mensagens foram retornados.   |


--- 


## Deletar Business Message 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/business/message/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "A mensagem foi desativado com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da mensagem foram retornados.   |
|400     | Não existe uma mensagem com esse ID.     | 


</br>
</br>
</br>

---

</br>
</br>
</br>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
<!-- Chat Domain (Incio) -->
# Customer Message Rest 👨‍💼
- Criar customer message
- Detalhar customer message
- Listar customer messages
- Desativar customer message
</br>

## Cadastro de Business Message 🔨
 
<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/customer/message**

**Exemplo de Entrada** 

```js
{
    customerId: 1, // FK 1
    chatId: 2, // FK 2
    msgContent: "Teste de mensagem",
    msgType: "TEXT"
}
```


| Campo           | Obrigatório | Tipo    | Descrição                                     |
|-----------------|-------------|---------|-----------------------------------------------|
| customerId      | sim         | numero  | esse campo é a FK que identifica a empresa.   |
| chatId          | sim         | numero  | esse campo é a FK que identifica o chat.      |
| msgContent      | sim         | texto   | Conteudo da mensagem enviada.                 |
| msgType         | sim         | texto   | Tipo do conteudo da mensagem enviada.         |


**Exemplo de Resposta**

```js
{
    id: 1,
    customer: {
      customerId: 1,
      name: "Paulo Silva"
    },
    chat: {
      chatId: 3,
    },
    data_message: {
      msgContent: "Teste de mensagem",
      msgType: "TEXT"
    },
    timestamps: {
      createdAt: "2022-12-10T05:47:08.644",
      updatedAt: "2022-12-10T05:47:08.644"  
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                          |
|--------|------------------------------------|
|201     | A mensagem foi criada com sucesso. |
|400     | Os dados enviados são inválidos.   |


--- 


## Detalhar Customer Message 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/customer/message/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    customer: {
      customerId: 1,
      name: "Paulo Silva"
    },
    chat: {
      chatId: 3,
    },
    data_message: {
      msgContent: "Teste de mensagem",
      msgType: "TEXT"
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
|200     | Os dados da mensagem foram retornados.   |
|400     | Não existe uma mensagem com esse ID.     | 


--- 


## Listar Customer Messages 📋

<!-- Endereço do recurso -->
`GET` - **nexus/api/v1/customer/message**

**Exemplo de Resposta** 
```js
[
       {
          id: 1,
          customer: {
            customerId: 1,
            name: "Paulo Silva"
          },
          chat: {
            chatId: 3,
          },
          data_message: {
            msgContent: "Teste de mensagem",
            msgType: "TEXT"
          },
          timestamps: {
            createdAt: "2022-12-10T05:47:08.644",
            updatedAt: "2022-12-10T05:47:08.644"  
          }
      },
      {
          id: 2,
          business: {
            businessId: 1,
            name: "Mirela"
          },
          chat: {
            chatId: 3,
          },
          data_message: {
            msgContent: "Olá!",
            msgType: "TEXT"
          },
          timestamps: {
            createdAt: "2022-12-10T05:47:08.644",
            updatedAt: "2022-12-10T05:47:08.644"  
          }
      }
]
```

### **Códigos da Resposta**

| Código | Descrição                                  |
|--------|--------------------------------------------|
|200     | Os dados das mensagens foram retornados.   |


--- 


## Deletar Customer Message 🗑

<!-- Endereço do recurso -->
`DELETE` - **nexus/api/v1/customer/message/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "A mensagem foi desativado com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da mensagem foram retornados.   |
|400     | Não existe uma mensagem com esse ID.     | 


</br>
</br>
</br>

---

</br>
</br>
</br>
