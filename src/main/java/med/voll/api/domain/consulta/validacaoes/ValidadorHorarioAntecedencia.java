package med.voll.api.domain.consulta.validacaoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agro = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agro, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new RuntimeException("Consulta deve agendada com antecedência minima de 30 minutos");
        }
    }

}
