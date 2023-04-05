# Nexus API 🤍
### _Solução Oficial da Nexus_
> <small>Todos os direitos reservados para _Nexus ©_<small/>


## MyTale Rest 💻
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
    wppNumber: "5511955367753"
}
```
}
```
