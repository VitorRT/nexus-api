package br.com.ninus.rest.api.utils;

import br.com.ninus.rest.api.entity.ModelInputClass;

public abstract class GeneratorPromptGPT {
    public static String createPrompt(ModelInputClass input) {
        String prompt = "Você é um criador aulas no formato json de uma linha só. Sua especialidade é criar aulas a partir de dados e retornar a resposta de cada campo para aula em um json, porém em um json de uma linha só. Você é ótimo em uma aula no formato json de uma linha só."
                + "\n"
                + "aqui esta um exemplo de resposta de uma uma aula no formato json:"
                + "\n"
                + "{\"introduction\": \"Esta aula tem como objetivo ensinar as crianças a conviverem entre si, abordando o tema 'Conviver'. O tema será trabalhado por meio do eixo 'O eu, o outro e o nós', com duração de 50 minutos.\", \"learningObjective\": \"Ao final desta aula, as crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.\", \"deployment\": \"A aula será iniciada com uma conversa sobre o tema, seguida de uma atividade em grupo para que as crianças possam praticar o que foi discutido.\", \"resources\": \"Livros didâticos, brinquedos.\", \"adaptions\": \"Serão feitas adaptações para que as crianças com necessidades especiais possam participar da aula.\", \"contextWorld\": \"Serão abordados conceitos de convivência, respeito e empatia.\", \"valuingCultureDiversity\": \"Serão abordadas as diferenças culturais entre as crianças, valorizando a diversidade.\", \"games\": \"Serão realizados jogos para que as crianças possam praticar o que foi discutido.\", \"familyParticipation\": \"Será incentivada a participação dos pais na aula.\", \"conclusion\": \"Será realizada uma conversa para que as crianças possam compartilhar o que aprenderam.\", \"finalRemarks\": \"Serão dadas orientações para que as crianças possam aplicar o que aprenderam em suas vidas.\", \"goals\": \"As crianças deverão compreender o conceito de convivência e saber como aplicá-lo em seu dia a dia.\"}\n"
                + "\n"
                + "\n"
                + "você vai gerar as respostas para cada campo desses a partir de dados de entrada. Lembre-se você é um especialista em criar strings de aulas criadas no formato json. Lembre-se as respostas podem ser grandes."
                + "\n"
                + "agora que você sabe que você é um especialista em criar strings de aulas criadas no formato json. Crie uma aula a partir desses dados de entrada:"
                + "\n"
                + "\"\n"
                + "axle: " + input.getAxle() + "\n"
                + "classroom: " + input.getClassroom() + "\n"
                + "type_teaching:" + input.getTypeTaching() + "\n"
                + "class_theme:" + input.getClassTheme() + "\n"
                + "class_objective:" + input.getClassObjective() + "\n"
                + "fields_experience:" + input.getFieldsExperience() + "\n"
                + "duration_in_minutes:" + input.getDurationInMinutes() + "\n"
                + "\""
                + "\n"
                + "\n"
                + "crie uma aula e coloque a resposta em cada campo do json e retorne uma linha só de um json com as respostas em português de cada campo da sua criação de aula. Lembre-se você é um é um especialista em criar muma linha só de aulas criadas no formato json e vai criar uma aula e irá retorar uma resposta idêntica ao exemplo, apenas irá substituir os \"{sua resposta}\" pelas suas resposta de fato."
                + "\n"
                + "\n"
                + "Agora que você criou a aula, você só irá retornar o json em uma uma linha só, lembre-se não retorne nada mais além do que o json em uma linha só, apenas o json em uma linha só. Lembre-se você não deve retornar nada mais do que o json em uma linha só. não dê uma resposta explicativa, apenas retorne o json em uma linha só, não retorne uma explicação e nem uma mensagem de confirmação, apenas o json em uma linha só."
                ;

        return prompt;
    }
}
