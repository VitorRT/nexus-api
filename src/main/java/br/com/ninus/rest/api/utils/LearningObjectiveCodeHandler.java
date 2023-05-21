package br.com.ninus.rest.api.utils;

import br.com.ninus.rest.api.utils.constants.LearningObjective;
import br.com.ninus.rest.api.utils.constants.LearningObjectiveCode;

public class LearningObjectiveCodeHandler {

    /* objetivo: Retornar um código correto de acordo com o objetivo de aprendizagem. */
    /* Para saber mais: http://basenacionalcomum.mec.gov.br/abase/#estrutura */
    public static LearningObjectiveCode getCode(LearningObjective objective, String xp) {

        String EO = "O eu, o outro e o nós";
        String CG = "Corpo, gestos e movimentos";
        String TS = "Traços, sons, cores e formas";
        String EF = "Escuta, fala, pensamento e imaginação";
        String ET = "Espaços, tempos, quantidades, relações e transformações";



        /* BEBES */
        if(objective.equals(LearningObjective.BEBES) && xp.equals(EO)) {
            return LearningObjectiveCode.EI01EO;
        } else if (objective.equals(LearningObjective.BEBES) && xp.equals(CG)) {
            return LearningObjectiveCode.EI01CG;
        } else if (objective.equals(LearningObjective.BEBES) && xp.equals(TS)) {
            return LearningObjectiveCode.EI01TS;
        } else if(objective.equals(LearningObjective.BEBES) && xp.equals(EF)) {
            return LearningObjectiveCode.EI01EF;
        } else if (objective.equals(LearningObjective.BEBES) && xp.equals(ET)) {
            return LearningObjectiveCode.EI01ET;
        }

        /* CRIANCAS BEM PEQUENAS */
        else if(objective.equals(LearningObjective.CRIANCAS_BEM_PEQUENAS) && xp.equals(EO)) {
            return LearningObjectiveCode.EI02EO;
        }else if (objective.equals(LearningObjective.CRIANCAS_BEM_PEQUENAS) && xp.equals(CG)) {
            return LearningObjectiveCode.EI02CG;
        } else if (objective.equals(LearningObjective.CRIANCAS_BEM_PEQUENAS) && xp.equals(TS)) {
            return LearningObjectiveCode.EI02TS;
        } else if(objective.equals(LearningObjective.CRIANCAS_BEM_PEQUENAS) && xp.equals(EF)) {
            return LearningObjectiveCode.EI02EF;
        } else if (objective.equals(LearningObjective.CRIANCAS_BEM_PEQUENAS) && xp.equals(ET)) {
            return LearningObjectiveCode.EI02ET;
        }

        /* CRIANCAS PEQUENAS */
        else if(objective.equals(LearningObjective.CRIANCAS_PEQUENAS) && xp.equals(EO)) {
            return LearningObjectiveCode.EI03EO;
        }else if (objective.equals(LearningObjective.CRIANCAS_PEQUENAS) && xp.equals(CG)) {
            return LearningObjectiveCode.EI03CG;
        } else if (objective.equals(LearningObjective.CRIANCAS_PEQUENAS) && xp.equals(TS)) {
            return LearningObjectiveCode.EI03TS;
        } else if(objective.equals(LearningObjective.CRIANCAS_PEQUENAS) && xp.equals(EF)) {
            return LearningObjectiveCode.EI03EF;
        } else if (objective.equals(LearningObjective.CRIANCAS_PEQUENAS) && xp.equals(ET)) {
            return LearningObjectiveCode.EI03ET;
        }

        return null;
    }

}
