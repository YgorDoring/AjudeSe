package dev.ygordoring.ajude_se.model

class DailyIntakeCalculator {
    private val ML_JOVEM = 40.0
    private val ML_ADULTO = 35.0
    private val ML_IDOSO = 30.0
    private val ML_SENIOR = 25.0

    private var resultadoMl = 0.0
    private var resultado_total_ml = 0.0

    fun CalcularTotalMl(peso: Double, idade: Int) {
        if(idade<=17) {
            resultadoMl = peso*ML_JOVEM
            resultado_total_ml = resultadoMl
        } else if(idade<=55) {
            resultadoMl = peso*ML_ADULTO
            resultado_total_ml = resultadoMl
        } else if(idade<=65) {
            resultadoMl = peso*ML_IDOSO
            resultado_total_ml=resultadoMl
        } else {
            resultadoMl = peso*ML_SENIOR
            resultado_total_ml = resultadoMl
        }
    }

    fun ResultadoLitros() : Double {
        return resultado_total_ml/1000
    }
}