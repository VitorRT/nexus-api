# Ninus API 🤍
### _Solução Oficial da Nexus_
> <small>Todos os direitos reservados para _Smash Code ©_<small/>


## Ninus Rest 💻
_Documentação Oficial da API Rest do aplicativo Ninus. Com essa API você será capaz de consumir todos os serviços e dados direto do nosso banco de dados. É importante lembrar que essa documentação específica do github abordará apenas os endpoints de acesso a serviços e dados mais importantes da Nexus. <br/> <br/>
> <small>_Equipe Smash Code! ❤_<small/>
<hr/>
</br>

<!-- Business Domain (Incio) -->
# Client Rest
- Criar client account
- Detalhar client account
- Listar client accounts
- Editar client account
- Desativar client account
</br>

## Cadastro de Client Account 🔨

<!-- Endereço do recurso -->
`POST` - **nexus/api/v1/business**

**Exemplo de Entrada** 

```js
{
    name: "Paula Vasconcelos",
    email: "paulinha@gmail.com",
    password: "Paulinha123",
    school_type: "CEI_PRIVADO",
}
```

| Campo       | Obrigatório | Tipo  | Descrição                                     |
|-------------|-------------|-------|-----------------------------------------------|
| name        | sim         | texto | nome do usuário                               |
| email       | sim         | texto | email unico do usuário                        |
| passoword   | sim         | texto | senha de identificação do usuário             |
| school_type | sim         | texto | tipo de escola                                |

**Exemplo de Resposta**

```js
{
    "_embedded": {
        "clientDetailsList": [
            {
                "id": 1,
                "name": "Paulinha Vasconcelos",
                "school_type": "CEI_PRIVADO"
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/v1/client?page=0&size=5"
        }
    },
    "page": {
        "size": 5,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | a conta foi criada com sucesso.      |
|400     | Os dados enviados são inválidos.     |


--- 


## Detalhar Client Account📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/client/{id}**

**Exemplo de Resposta**

```js
{
    "id": 1,
    "name": "Paulinha Vasconcelos",
    "school_type": "CEI_PRIVADO",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/v1/client/1"
        },
        "delete": {
            "href": "http://localhost:8080/api/v1/client/1"
        },
        "all": {
            "href": "http://localhost:8080/api/v1/client"
        }
    }
}
```


### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | a conta foi criada com sucesso.      |
|400     | Os dados enviados são inválidos.     |


--- 


## Listar Client Account 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/client**

**Exemplo de Resposta** 
```js
{
    "_embedded": {
        "clientDetailsList": [
            {
                "id": 1,
                "name": "Paulinha Vasconcelos",
                "school_type": "CEI_PRIVADO"
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/v1/client?page=0&size=5"
        }
    },
    "page": {
        "size": 5,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}
```
### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados das contas foram retornados.    |


--- 


## Editar Client Account ⚙

<!-- Endereço do recurso -->
`PUT` - **http://localhost:8080/api/v1/client?name=Informacao**

**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações                                    |
|-----------|----------|--------------------------------------------------|
| name      | sim      | o nome do usuário  é editável.                   |


**Exemplo de Resposta**

```js
{
    "id": 1,
    "name": "Pedro Luiz",
    "school_type": "CEI_PRIVADO",
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/v1/client/1"
        },
        "delete": {
            "href": "http://localhost:8080/api/v1/client/1"
        },
        "all": {
            "href": "http://localhost:8080/api/v1/client"
        }
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da conta foram retornados.      |
|400     | Não existe uma conta com esse ID.        |


---


## Deletar Client Account 🗑

<!-- Endereço do recurso -->
`DELETE` - **http://localhost:8080/api/v1/client/{id}**

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da conta foram excluidos        |
|400     | Não existe uma conta com esse ID.        |


</br>
</br>
</br>

---

</br>
</br>
</br> 
  
    
<!-- Customer Domain (Incio) -->
# Class 👨‍💼
- Crie uma Aula
</br>

## Cadastro de Aula 🔨

<!-- Endereço do recurso -->
`POST` - **http://localhost:8080/api/v1/class**

**Exemplo de Entrada** 

```js
{
    "client_id": 1,
    "class_name": "Convivendo com outras crianças"
}
```

| Campo         | Obrigatório | Tipo    | Descrição                                                     |
|---------------|-------------|---------|---------------------------------------------------------------|
| client_id     | sim         | numero  | esse campo é a FK que identifica o usuário.                   |
| businessId    | sim         | numero  | esse campo é o campo que indentifica o nome da classe         |

**Exemplo de Resposta**

```js
{
    "id": 1,
    "client": {
        "id": 1,
        "name": "Paulinha Vasconcelos",
        "school_type": "CEI_PRIVADO"
    },
    "class_name": "Convivendo com outras crianças",
    "categorie": "PROGRESS",
    "createdAt": [
        2023,
        9,
        12,
        16,
        1,
        7,
        322686200
    ],
    "updatedAt": [
        2023,
        9,
        12,
        16,
        1,
        7,
        322686200
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/1"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/1"
        },
        {
            "rel": "all-progress",
            "href": "http://localhost:8080/api/v1/class/progress"
        },
        {
            "rel": "all-finished",
            "href": "http://localhost:8080/api/v1/class/finished"
        },
        {
            "rel": "all-favorite",
            "href": "http://localhost:8080/api/v1/class/favorite"
        }
    ]
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | o cliente foi criado com sucesso.    |
|400     | Os dados enviados são inválidos.     |


--- 


## Detalhar Aula 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost/api/v1/business/class/{id}**

**Exemplo de Resposta**

```js
{
    "id": 1,
    "client": {
        "id": 2,
        "name": "Paulinha Vasconcelos",
        "school_type": "CEI_PRIVADO"
    },
    "class_name": "Convivendo com outras crianças",
    "categorie": "PROGRESS",
    "createdAt": [
        2023,
        9,
        12,
        16,
        54,
        22,
        364000000
    ],
    "updatedAt": [
        2023,
        9,
        12,
        16,
        54,
        22,
        364000000
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/1"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/1"
        },
        {
            "rel": "all-progress",
            "href": "http://localhost:8080/api/v1/class/progress"
        },
        {
            "rel": "all-finished",
            "href": "http://localhost:8080/api/v1/class/finished"
        },
        {
            "rel": "all-favorite",
            "href": "http://localhost:8080/api/v1/class/favorite"
        }
    ]
}

```


### **Códigos da Resposta**

| Código | Descrição                              |
|--------|----------------------------------------|
|200     | Os dados do cliente foram retornados.  |
|400     | Não existe um cleinte com esse ID.     | 


--- 


## Listar Aula 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/class**

**Exemplo de Resposta** 
```js
{
    "id": 2,
    "client": {
        "id": 2,
        "name": "Paulinha Vasconcelos",
        "school_type": "CEI_PRIVADO"
    },
    "class_name": "Convivendo com outras crianças",
    "categorie": "PROGRESS",
    "createdAt": [
        2023,
        9,
        12,
        16,
        55,
        41,
        949898500
    ],
    "updatedAt": [
        2023,
        9,
        12,
        16,
        55,
        41,
        949898500
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/2"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/2"
        },
        {
            "rel": "all-progress",
            "href": "http://localhost:8080/api/v1/class/progress"
        },
        {
            "rel": "all-finished",
            "href": "http://localhost:8080/api/v1/class/finished"
        },
        {
            "rel": "all-favorite",
            "href": "http://localhost:8080/api/v1/class/favorite"
        }
    ]
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados dos clientes foram retornados.  |


--- 

## Editar Aula 🗑

<!-- Endereço do recurso -->
`PUT` - **http://localhost:8080/api/v1/business/class/1/?className=InformacaoAAlterar**

**Exemplo de Resposta** 
```js
{
    "id": 1,
    "client": {
        "id": 1,
        "name": "Pedro Luiz",
        "school_type": "CEI_PRIVADO"
    },
    "class_name": "Alfabetizacao",
    "categorie": "PROGRESS",
    "createdAt": [
        2023,
        9,
        12,
        17,
        21,
        33,
        692287000
    ],
    "updatedAt": [
        2023,
        9,
        12,
        17,
        32,
        47,
        318355400
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/1"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/1"
        },
        {
            "rel": "all-progress",
            "href": "http://localhost:8080/api/v1/class/progress"
        },
        {
            "rel": "all-finished",
            "href": "http://localhost:8080/api/v1/class/finished"
        },
        {
            "rel": "all-favorite",
            "href": "http://localhost:8080/api/v1/class/favorite"
        }
    ]
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do cliente foram retornados.    |
|400     | Não existe um perfil com esse ID.        |


## Deletar Aula 🗑

<!-- Endereço do recurso -->
`DELETE` - **http://localhost:8080/api/v1/business/class/{id}**


### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do aula foram excluidos.        |
|400     | Não existe um perfil com esse ID.        |


</br>
</br>
</br>

---

</br>
</br>
</br> 
  
<!-- Communcation Channel Domain (Incio) -->
# Input - Aula - GPT 👨‍💼
- Criar input 
- Detalhar input 
- Listar input 
- Editar input
</br>

## Cadastro de Input 🔨
 
<!-- Endereço do recurso -->
`POST` - **http//:localhost:8080/api/v1/class/input**

**Exemplo de Entrada** 

```js
{
    "class_ninus_id": 1,
    "axle": "CONVIVER",
    "class_room": "Maternal 2",
    "didatic_resources": "brinquedos e livros.",
    "type_teaching": "Ensino Infântil",
    "learning_objective": "CRIANCAS_BEM_PEQUENAS",
    "class_theme": "Convivência entre as crianças",
    "class_objective": "Aula que ensine as crianças a conviverem entre si.",
    "fields_experience": "O eu, o outro e o nós",
    "duration_in_minutes": 50
}
```


| Campo              | Obrigatório | Tipo    | Descrição                                           |
|--------------------|-------------|---------|-----------------------------------------------------|
| class_ninus_id     | sim         | numero  | esse campo é a FK que identifica a aula.            |
| axle               | sim         | texto   | temas bem especifico da aula                        |
| class_room         | sim         | texto   | nome da sala de aula                                |
| didatic_resources  | sim         | texto   | recursos a serem usados em aula                     |
| type_teaching      | sim         | texto   | tipo de ensino                                      |
| learning_objective | sim         | texto   | objetivo didático da aula                           |
| class_theme        | sim         | texto   | tema principal da aula                              |
| class_objective    | sim         | texto   | objetivos específicos para cada grupo               |
| fields_experience  | não         | texto   | campos de experiências                              |
| duration_in_minutes| sim         | número  | duração total da aula em minutos                    |

**Exemplo de Resposta**

```js
{
    "id": 1,
    "class": {
        "id": 1,
        "className": "Convivendo com outras crianças",
        "categorie": "PROGRESS"
    },
    "axle": "CONVIVER",
    "classroom": "Maternal 2",
    "type_teaching": "Ensino Infântil",
    "class_theme": "Convivência entre as crianças",
    "learning_objective": "CRIANCAS_BEM_PEQUENAS",
    "learning_objective_code": "EI02EO",
    "age_group": "de 4 anos até 5 anos e 11 meses",
    "class_objective": "Aula que ensine as crianças a conviverem entre si.",
    "fields_experience": "O eu, o outro e o nós",
    "duration_in_minutes": 50,
    "createdAt": [
        2023,
        9,
        12,
        16,
        1,
        10,
        611113800
    ],
    "updatedAt": [
        2023,
        9,
        12,
        16,
        1,
        10,
        611113800
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/input/1"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/input/1"
        },
        {
            "rel": "all",
            "href": "http://localhost:8080/api/v1/class/input"
        }
    ]
}
```

### **Códigos da Resposta**

| Código | Descrição                              |
|--------|----------------------------------------|
|201     | o input foi criada com sucesso.        |
|400     | Os dados enviados são inválidos.       |


--- 


## Detalhar Input 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/channel/class/input/{id}**

**Exemplo de Resposta**

```js
{
    "id": 1,
    "class": {
        "id": 1,
        "className": "Convivendo com outras crianças",
        "categorie": "PROGRESS"
    },
    "axle": "CONVIVER",
    "classroom": "Maternal 2",
    "type_teaching": "Ensino Infântil",
    "class_theme": "Convivência entre as crianças",
    "learning_objective": "CRIANCAS_BEM_PEQUENAS",
    "learning_objective_code": "EI02EO",
    "age_group": "de 4 anos até 5 anos e 11 meses",
    "class_objective": "Aula que ensine as crianças a conviverem entre si.",
    "fields_experience": "O eu, o outro e o nós",
    "duration_in_minutes": 50,
    "createdAt": [
        2023,
        9,
        12,
        17,
        1,
        21,
        685003000
    ],
    "updatedAt": [
        2023,
        9,
        12,
        17,
        1,
        21,
        685003000
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/input/1"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/input/1"
        },
        {
            "rel": "all",
            "href": "http://localhost:8080/api/v1/class/input"
        }
    ]
}
```


### **Códigos da Resposta**

| Código | Descrição                                    |
|--------|----------------------------------------------|
|200     | Os dados da comunicação foram retornados.    |
|400     | Não existe um perfil com esse ID.            | 


--- 


## Listar Input 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/channel/class/input**

**Exemplo de Resposta** 
```js
{
    "id": 1,
    "class": {
        "id": 1,
        "className": "Convivendo com outras crianças",
        "categorie": "PROGRESS"
    },
    "axle": "CONVIVER",
    "classroom": "Maternal 2",
    "type_teaching": "Ensino Infântil",
    "class_theme": "Convivência entre as crianças",
    "learning_objective": "CRIANCAS_BEM_PEQUENAS",
    "learning_objective_code": "EI02EO",
    "age_group": "de 4 anos até 5 anos e 11 meses",
    "class_objective": "Aula que ensine as crianças a conviverem entre si.",
    "fields_experience": "O eu, o outro e o nós",
    "duration_in_minutes": 50,
    "createdAt": [
        2023,
        9,
        12,
        16,
        1,
        10,
        611113800
    ],
    "updatedAt": [
        2023,
        9,
        12,
        16,
        1,
        10,
        611113800
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/input/1"
        },
        {
            "rel": "delete",
            "href": "http://localhost:8080/api/v1/class/input/1"
        },
        {
            "rel": "all",
            "href": "http://localhost:8080/api/v1/class/input"
        }
    ]
}
```

### **Códigos da Resposta**

| Código | Descrição                                      |
|--------|------------------------------------------------|
|200     | Os dados das comnunicações foram retornados.   |


--- 

## Deletar Input 🗑

<!-- Endereço do recurso -->
`DELETE` - **http://localhost:8080/api/v1/business/class/input/{id}**

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do input foram excluidos.       |
|400     | Não existe uma comunicação com esse ID.  |


</br>
</br>
</br>

---

</br>
</br>
</br>
   
<!-- Chat Domain (Incio) -->
# Output 👨‍💼
- Detalhar output
- Listar output
- Desativar 
</br>

## Detalhar Chat 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/model**

**Exemplo de Resposta**

```js
{
    "id": 1,
    "model_input": {
        "id": 1
    },
    "introduction": "Esta aula tem como objetivo ensinar as crianças a conviverem entre si, abordando o tema 'Conviver'. O tema será trabalhado por meio do eixo 'O eu, o outro e o nós', com duração de 50 minutos.",
    "learning_objective": "Ao final desta aula, as crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
    "deployment": "A aula será iniciada com uma conversa sobre o tema, seguida de uma atividade em grupo para que as crianças possam praticar o que foi discutido.",
    "resources": "Livros didâticos, brinquedos.",
    "adaptions": "Serão feitas adaptações para que as crianças com necessidades especiais possam participar da aula.",
    "context_world": "Serão abordados conceitos de convivência, respeito e empatia.",
    "valuing_culture_diversity": "Serão abordadas as diferenças culturais entre as crianças, valorizando a diversidade.",
    "games": "Serão realizados jogos para que as crianças possam praticar o que foi discutido.",
    "family_participation": "Será incentivada a participação dos pais na aula.",
    "conclusion": "Será realizada uma conversa para que as crianças possam compartilhar o que aprenderam.",
    "final_remarks": "Serão dadas orientações para que as crianças possam aplicar o que aprenderam em suas vidas.",
    "goals": "As crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
    "createdAt": [
        2023,
        9,
        12,
        17,
        1,
        30,
        847947000
    ],
    "updatedAt": [
        2023,
        9,
        12,
        17,
        1,
        30,
        847947000
    ],
    "links": [
        {
            "rel": "self",
            "href": "http://localhost:8080/api/v1/class/model/1"
        },
        {
            "rel": "all",
            "href": "http://localhost:8080/api/v1/class/model"
        }
    ]
}
```


### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|200     | Os dados do gpt foram retornados.    |
|400     | Não existe um chat com esse ID.      | 


--- 


## Listar Communcation Channels 📋

<!-- Endereço do recurso -->
`GET` - **http://localhost:8080/api/v1/model**

**Exemplo de Resposta** 
```js
{
    "_embedded": {
        "modelOutputClassDetailsList": [
            {
                "id": 1,
                "model_input": {
                    "id": 1
                },
                "introduction": "Esta aula tem como objetivo ensinar as crianças a conviverem entre si, abordando o tema 'Conviver' por meio do eixo 'O eu, o outro e o nós', com duração de 50 minutos.",
                "learning_objective": "Ao final desta aula, as crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
                "deployment": "A aula será iniciada com uma conversa sobre o tema, seguida de uma atividade em grupo para que as crianças possam praticar o que foi discutido.",
                "resources": "Livros didâticos, brinquedos.",
                "adaptions": "Serão feitas adaptações para que as crianças com necessidades especiais possam participar da aula.",
                "context_world": "Serão abordados conceitos de convivência, respeito e empatia.",
                "valuing_culture_diversity": "Serão abordadas as diferenças culturais entre as crianças, valorizando a diversidade.",
                "games": "Serão realizados jogos para que as crianças possam praticar o que foi discutido.",
                "family_participation": "Será incentivada a participação dos pais na aula.",
                "conclusion": "Será realizada uma conversa para que as crianças possam compartilhar o que aprenderam.",
                "final_remarks": "Serão dadas orientações para que as crianças possam aplicar o que aprenderam em suas vidas.",
                "goals": "As crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
                "createdAt": "2023-09-12T16:01:19.143008",
                "updatedAt": "2023-09-12T16:01:19.143008",
                "links": [
                    {
                        "href": "http://localhost:8080/api/v1/class/model/1"
                    },
                    {
                        "href": "http://localhost:8080/api/v1/class/model"
                    }
                ]
            },
            {
                "id": 2,
                "model_input": {
                    "id": 2
                },
                "introduction": "Esta aula tem como objetivo ensinar as crianças a conviverem entre si, abordando o tema 'Conviver' pelo eixo 'O eu, o outro e o nós', com duração de 50 minutos.",
                "learning_objective": "Ao final desta aula, as crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
                "deployment": "A aula será iniciada com uma conversa sobre o tema, seguida de uma atividade em grupo para que as crianças possam praticar o que foi discutido.",
                "resources": "Livros didâticos, brinquedos.",
                "adaptions": "Serão feitas adaptações para que as crianças com necessidades especiais possam participar da aula.",
                "context_world": "Serão abordados conceitos de convivência, respeito e empatia.",
                "valuing_culture_diversity": "Serão abordadas as diferenças culturais entre as crianças, valorizando a diversidade.",
                "games": "Serão realizados jogos para que as crianças possam praticar o que foi discutido.",
                "family_participation": "Será incentivada a participação dos pais na aula.",
                "conclusion": "Será realizada uma conversa para que as crianças possam compartilhar o que aprenderam.",
                "final_remarks": "Serão dadas orientações para que as crianças possam aplicar o que aprenderam em suas vidas.",
                "goals": "As crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.",
                "createdAt": "2023-09-12T16:28:00.910761",
                "updatedAt": "2023-09-12T16:28:00.910761",
                "links": [
                    {
                        "href": "http://localhost:8080/api/v1/class/model/2"
                    },
                    {
                        "href": "http://localhost:8080/api/v1/class/model"
                    }
                ]
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/v1/class/model?page=0&size=5"
        }
    },
    "page": {
        "size": 5,
        "totalElements": 2,
        "totalPages": 1,
        "number": 0
    }
}
```

### **Códigos da Resposta**

| Código | Descrição                              |
|--------|----------------------------------------|
|200     | Os dados dos chats foram retornados.   |


--- 

## Deletar Output 🗑

<!-- Endereço do recurso -->
`DELETE` - **http://localhost:8080/api/v1/model/{id}**

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do chat foram retornados.       |
|400     | Não existe um chat com esse ID.          |
