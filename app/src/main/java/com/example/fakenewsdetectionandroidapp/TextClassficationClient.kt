package com.example.fakenewsdetectionandroidapp

import android.content.Context
import android.util.Log
import org.tensorflow.lite.task.text.nlclassifier.BertNLClassifier
//import com.example.fakenewsdetectionandroidapp.TextClassificationClient
import java.io.IOException
import java.util.*

//import org.tensorflow.lite.support.label.Category

/** Load TfLite model and provide predictions with task api.  */
class TextClassificationClient(private val context: Context) {
    var classifier: BertNLClassifier? = null
    fun load() {
        try {
            classifier = BertNLClassifier.createFromFile(context, MODEL_PATH)
        } catch (e: IOException) {
            Log.e(TAG, e.message!!)
        }
    }

    fun unload() {
        classifier?.close()
        classifier = null
    }

    fun classify(text: String?): List<Result> {
        val apiResults = classifier!!.classify(text)
        val results: MutableList<Result> = ArrayList<Result>(apiResults.size)
        for (i in apiResults.indices) {
            val category = apiResults[i]
            results.add(Result("" + i, category.label, category.score))
        }
        results.sort()
        return results
    }

    companion object {
        const val TAG = "TaskApi"
        private const val MODEL_PATH = "bert.tflite"
    }
}


