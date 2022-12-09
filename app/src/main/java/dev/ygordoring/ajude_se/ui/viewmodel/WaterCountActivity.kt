package dev.ygordoring.ajude_se.ui.viewmodel

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.*
import androidx.appcompat.app.AlertDialog
import dev.ygordoring.ajude_se.R
import dev.ygordoring.ajude_se.data.model.DailyIntakeCalculator
import java.text.NumberFormat
import java.util.*

class WaterCountActivity : AppCompatActivity() {

    private lateinit var edit_peso: EditText
    private lateinit var edit_idade: EditText
    private lateinit var bt_calcular: Button
    private lateinit var txt_resultado: TextView
    private lateinit var ic_redefinir_dados: ImageView

    private lateinit var bt_lembrete: Button
    private lateinit var bt_alarme: Button
    private lateinit var txt_hora: TextView
    private lateinit var txt_minuto: TextView

    private lateinit var calcularIngestaoDiaria: DailyIntakeCalculator
    private var resultadoMl = 0.0
    lateinit var timePickerDialog: TimePickerDialog
    lateinit var calendario: Calendar
    var horaAtual = 0
    var minutoAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_count)


        IniciarComponentes()

        calcularIngestaoDiaria = DailyIntakeCalculator()

        bt_calcular.setOnClickListener {
            if (edit_idade.text.toString().isEmpty()) {
                Toast.makeText(this, R.string.toast_informe_idade, Toast.LENGTH_SHORT).show()
            } else if (edit_peso.text.toString().isEmpty()) {
                Toast.makeText(this, R.string.toast_informe_peso, Toast.LENGTH_SHORT).show()
            } else {
                val peso = edit_peso.text.toString().toDouble()
                val idade = edit_idade.text.toString().toInt()
                calcularIngestaoDiaria.CalcularTotalMl(peso, idade)
                resultadoMl = calcularIngestaoDiaria.ResultadoLitros()
                val formatar = NumberFormat.getNumberInstance(Locale("pt", "BR"))
                formatar.isGroupingUsed = false
                txt_resultado.text = formatar.format(resultadoMl) + " " + "Litros"
            }

        }

        ic_redefinir_dados.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(R.string.dialog_titulo)
                .setMessage(R.string.dialog_descricao)
                .setPositiveButton("OK") { dialogInterface, i ->
                    edit_peso.setText("")
                    edit_idade.setText("")
                    txt_resultado.text = ""
                }
            alertDialog.setNegativeButton("Cancelar") { dialogInterface, i -> }
            val dialog = alertDialog.create()
            dialog.show()

        }

        bt_lembrete.setOnClickListener {
            calendario = Calendar.getInstance()
            horaAtual = calendario.get(Calendar.HOUR_OF_DAY)
            minutoAtual = calendario.get(Calendar.MINUTE)
            timePickerDialog =
                TimePickerDialog(this, { timePicker: TimePicker, hourOfDay: Int, minutes: Int ->
                    txt_hora.text = String.format("%02d", hourOfDay)
                    txt_minuto.text = String.format("%02d", minutes)
                }, horaAtual, minutoAtual, true)
            timePickerDialog.show()
        }

        bt_alarme.setOnClickListener {
            if (!txt_hora.text.toString().isEmpty() && !txt_minuto.text.toString().isEmpty()) {
                val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_HOUR, txt_hora.text.toString().toInt())
                intent.putExtra(AlarmClock.EXTRA_MINUTES, txt_minuto.text.toString().toInt())
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, getString(R.string.alarm_message))
                startActivity(intent)

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
    }

    private fun IniciarComponentes() {
        edit_peso = findViewById(R.id.et_peso);
        edit_idade = findViewById(R.id.et_idade);
        bt_calcular = findViewById(R.id.bt_calcular);
        txt_resultado = findViewById(R.id.tv_resultado);
        ic_redefinir_dados = findViewById(R.id.ic_redefinir);

        bt_lembrete = findViewById(R.id.bt_lembrete)
        bt_alarme = findViewById(R.id.bt_alarme)
        txt_hora = findViewById(R.id.txt_hora)
        txt_minuto = findViewById(R.id.txt_min)

    }


}