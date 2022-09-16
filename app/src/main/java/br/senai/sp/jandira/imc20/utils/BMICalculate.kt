package br.senai.sp.jandira.imc20.utils

import android.content.Context
import br.senai.sp.jandira.imc20.R
import kotlin.math.pow

fun getBMI(weight: Int, height: Double): Double {

    return weight / height.pow(2);

}

fun getStatusBMI(bmi: Double, context: Context): String {

    if (bmi <= 18.5) {

        return context.getString(R.string.under_weight);

    } else if (bmi > 18.5 && bmi < 25.0) {

        return context.getString(R.string.ideal_weight)

    } else if (bmi >= 25.0 && bmi < 30.0) {

        return context.getString(R.string.slightly_overweight)

    } else if (bmi >= 30.0 && bmi < 35.0) {

        return context.getString(R.string.obesity_grade_I)

    } else if (bmi >= 35.0 && bmi < 40.0) {

        return context.getString(R.string.obesity_grade_II)

    } else {

        return context.getString(R.string.obesity_grade_III)

    }

}